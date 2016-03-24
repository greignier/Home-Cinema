package reignier.guillaume.homecinema;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

public class SingleListItem extends Activity{

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    View convertView;
    private LayoutInflater inflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_list_item_view);

        Intent details = getIntent();
        TextView titre = (TextView) findViewById(R.id.titrefilm);
        TextView titre_ori = (TextView) findViewById(R.id.titre_ori);
        TextView genre = (TextView) findViewById(R.id.genre);
        TextView synopsis = (TextView) findViewById(R.id.synopsis);


        if (details != null) {
            titre.setText(details.getStringExtra("titre"));
            titre_ori.setText(details.getStringExtra("titre_ori"));
            genre.setText(details.getStringExtra("genre"));
            synopsis.setText(details.getStringExtra("synopsis"));


    }
}
}
