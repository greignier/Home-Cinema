package reignier.guillaume.homecinema;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();

    // Movies json url
    private static final String url = "http://centrale.corellis.eu/filmseances.json";
    private ProgressDialog pDialog;
    private List<FilmMoment> listeFilmsMoment = new ArrayList<FilmMoment>();
    private ListView listView;
    private CustomListAdapter adapter;
    private ArrayAdapter<String> drawerItems;
    private ListView myDrawer;



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.films_moment:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.nav_view);
                drawer.closeDrawers();
                return true;
            case R.id.prochaines_seances:
                Intent monIntent2 = new Intent(MainActivity.this,SingleListItem.class);
                startActivity(monIntent2);
                return true;
            case R.id.events:
                Intent monIntent3 = new Intent(MainActivity.this,SingleListItem.class);
                startActivity(monIntent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //import du json
        ListView listView = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this, listeFilmsMoment);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Chargement en cours");
        pDialog.show();

        // Creating volley request obj
        JsonArrayRequest movieReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                FilmMoment film = new FilmMoment();
                                film.setTitre(obj.getString("titre"));
                                film.setTitre_ori(obj.getString("titre_ori"));
                                film.setAffiche(obj.getString("affiche"));
                                film.setWeb(obj.getString("web"));
                                film.setDistributeur(obj.getString("distributeur"));
                                film.setParticipants(obj.getString("participants"));
                                film.setRealisateur(obj.getString("realisateur"));
                                film.setSynopsis(obj.getString("synopsis"));
                                film.setAnnee(obj.getString("annee"));
                                film.setDuree(obj.getString("duree"));
                                film.setDate_sortie(obj.getString("date_sortie"));
                                film.setInfo(obj.getString("info"));
                                film.setGenre(obj.getString("genre"));
                                film.setCategorie(obj.getString("categorie"));
                                film.setReleaseNumber(obj.getString("ReleaseNumber"));
                                film.setPays(obj.getString("pays"));
                                film.setShare_url(obj.getString("share_url"));

                                film.setId(obj.getInt("id"));
                                film.setGenreid(obj.getInt("genreid"));
                                film.setCategorieid(obj.getInt("categorieid"));

                                film.setIs_visible(obj.getBoolean("is_visible"));
                                film.setIs_vente(obj.getBoolean("is_vente"));
                                film.setIs_avp(obj.getBoolean("is_avp"));
                                film.setIs_alaune(obj.getBoolean("is_alaune"));
                                film.setIsLastWeek(obj.getBoolean("is_lastWeek"));

                                film.setMedias(obj.getJSONArray("medias"));
                                film.setVideos(obj.getJSONArray("videos"));

                                listeFilmsMoment.add(film);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(movieReq);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent details = new Intent(MainActivity.this, SingleListItem.class);
                FilmMoment m = listeFilmsMoment.get(position);
                details.putExtra("titre", m.getTitre());
                details.putExtra("titre_ori", m.getTitre_ori());
                details.putExtra("date_sortie", m.getDate_sortie());
                details.putExtra("genre", m.getGenre());
                details.putExtra("synopsis", m.getSynopsis());

                startActivity(details);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.nav_view);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

}
