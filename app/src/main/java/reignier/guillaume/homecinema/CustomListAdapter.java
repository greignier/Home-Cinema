package reignier.guillaume.homecinema;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<FilmMoment> filmItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, List<FilmMoment> filmItems) {
        this.activity = activity;
        this.filmItems = filmItems;
    }

    @Override
    public int getCount() {
        return filmItems.size();
    }

    @Override
    public Object getItem(int location) {
        return filmItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView titre = (TextView) convertView.findViewById(R.id.movieTitle);
        TextView titre_ori = (TextView) convertView.findViewById(R.id.movieOriginalTitle);
        TextView genre = (TextView) convertView.findViewById(R.id.movieGenre);
        TextView date_sortie = (TextView) convertView.findViewById(R.id.movieSortie);

        // getting movie data for the row
        FilmMoment m = filmItems.get(position);

        // thumbnail image
        thumbNail.setImageUrl(m.getAffiche(), imageLoader);

        // titre
        titre.setText(m.getTitre());

        // titre original
        titre_ori.setText(String.valueOf(m.getTitre_ori()));

        // genre
        genre.setText(m.getGenre());

        // genre
        //String genreStr = "";
        //for (String str : m.getGenre()) {
        //    genreStr += str + ", ";
        //}
        //genreStr = genreStr.length() > 0 ? genreStr.substring(0,
        //        genreStr.length() - 2) : genreStr;
        //genre.setText(genreStr);

        // release year
        date_sortie.setText(String.valueOf(m.getDate_sortie()));

        return convertView;
    }

}