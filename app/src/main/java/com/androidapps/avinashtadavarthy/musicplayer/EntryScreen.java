package com.androidapps.avinashtadavarthy.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupMenu;

import static java.security.AccessController.getContext;

public class EntryScreen extends AppCompatActivity {

    GridView gridView;

    String[] albumnameString = {
            "Vivegam",
            "Memories - Do Not Open", "Jagga Jasoos",
            "Game of Thrones", "Divide"
    } ;

    String[] artistString = {
            "Anirudh Ravichander", "The Chainsmokers",
            "Pritam", "Ramin Djawadi",
            "Ed Sheeran"
    };

    String[] albumartID = {
            "http://cdn.kollytalk.com/wp-content/uploads/2017/06/Vivegam-Audio-launch-on-july-27-300x300.jpg",
            "https://i.scdn.co/image/df3b17e748de56e4ce78ac29b216d3f99afd0c5a",
            "http://www.bollywoodlife.com/wp-content/uploads/2017/02/Jagga-Jasoos-poster.jpg",
            "http://media.metropotam.ro/metropotam_filme/metropotam_filme/stiri-despre-filme/2014/06/cat-te-costa-sa-ajungi-personaj-si-sa-mori-in-game-of-thrones-art3840714714/1.jpg",
            "https://wowone.ru/wp-content/uploads/2017/02/Ed-Sheeran-.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_screen);

        // For the gridview
        CustomGridViewActivity adapter = new CustomGridViewActivity(EntryScreen.this, albumartID, albumnameString, artistString);
        gridView=(GridView)findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent movetoAlbum = new Intent(EntryScreen.this,AlbumActivity.class)
                        .putExtra("albumname",albumnameString[i])
                        .putExtra("artist",artistString[i])
                        .putExtra("albumart",albumartID[i]);

                startActivity(movetoAlbum);
                overridePendingTransition(R.anim.right_enter, R.anim.left_out);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        this.finish();
        overridePendingTransition(R.anim.right_out,R.anim.left_enter);
    }
}
