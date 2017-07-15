package com.androidapps.avinashtadavarthy.musicplayer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;

public class AlbumActivity extends AppCompatActivity {

    ListView listView;
    TextView art, selected_track_title;
    String albumname, artist, albumart;
    ImageView play, pause;
    AppBarLayout app_bar;
    MediaPlayer music;
    ProgressBar spinner;
    SeekBar sBar;

    String[] vivegam = {
            "Thalai Viduthalai", "Surviva"
    };

    String[] vivegamurl = {
            "http://9xmusiq.com/songs2/tamil/vivegam/Thalai%20Viduthalai%20%5bStarmusiq.info%5d.mp3",
            "http://9xmusiq.com/songs2/tamil/vivegam/Surviva%20%5bStarmusiq.info%5d.mp3"
    };

    String[] got = {
            "Light of the Seven", "Rains of Castamere"
    };

    String[] goturl = {
            "http://musicgo.me/download-m.php?song_id=3197",
            "http://a.tumblr.com/tumblr_mambeldOf41qzr7ibo1.mp3"
    };

    String[] jagga = {
            "Ullu ka Pattha", "Musafir", "Galti se Mistake", "Jhumritalaiyya", "Phir Wahi"
    };

    String[] jaggaurl = {
            "https://dl.pagal.link/upload_file/5570/6757/Latest%20Bollywood%20Hindi%20Mp3%20Songs%20-%202017/Jagga%20Jasoos%20%282017%29%20Mp3%20Songs/01%20Ullu%20Ka%20Pattha%20-%20Jagga%20Jasoos%20%28Arijit%20Singh%29%20190Kbps.mp3",
            "https://dl.pagal.link/upload_file/5570/6757/Latest%20Bollywood%20Hindi%20Mp3%20Songs%20-%202017/Jagga%20Jasoos%20%282017%29%20Mp3%20Songs/05%20Musafir%20-%20Jagga%20Jasoos%20%28Tushar%20Joshi%29%20190Kbps.mp3",
            "https://dl.pagal.link/upload_file/5570/6757/Latest%20Bollywood%20Hindi%20Mp3%20Songs%20-%202017/Jagga%20Jasoos%20%282017%29%20Mp3%20Songs/02%20Galti%20Se%20Mistake%20-%20Jagga%20Jasoos%20%28Arijit%20Singh%29%20190Kbps.mp3",
            "https://dl.pagal.link/upload_file/5570/6757/Latest%20Bollywood%20Hindi%20Mp3%20Songs%20-%202017/Jagga%20Jasoos%20%282017%29%20Mp3%20Songs/03%20Jhumritalaiyya%20-%20Jagga%20Jasoos%20%28Arijit%20Singh%29%20320Kbps.mp3",
            "https://dl.pagal.link/upload_file/5570/6757/Latest%20Bollywood%20Hindi%20Mp3%20Songs%20-%202017/Jagga%20Jasoos%20%282017%29%20Mp3%20Songs/04%20Phir%20Wahi%20-%20Jagga%20Jasoos%20%28Arijit%20Singh%29%20190Kbps.mp3",
    };

    String[] memories = {
            "The One", "Break up Every Night", "Something Just Like This", "My Type", "Paris", "Young"
    };

    String[] memoriesurl = {
            "http://songspkdload.com/English/Memories%20Do%20Not%20Open%20Full%20Album/The%20Chainsmokers-The%20One-Songspksongspks.Com.mp3",
            "http://songspkdload.com/English/Memories%20Do%20Not%20Open%20Full%20Album/Break%20Up%20Every%20Night-Songspksongspks.Com.mp3",
            "http://songspkdload.com/English/Memories%20Do%20Not%20Open%20Full%20Album/Something%20Just%20Like%20This-Songspksongspks.mp3",
            "http://songspkdload.com/English/Memories%20Do%20Not%20Open%20Full%20Album/My%20Type-Songspksongspks.Com.mp3",
            "http://songspkdload.com/English/Memories%20Do%20Not%20Open%20Full%20Album/Paris%20-Songspksongspks.Com.mp3",
            "http://songspkdload.com/English/Memories%20Do%20Not%20Open%20Full%20Album/Young-Songspksongspks.Com.mp3"

    };

    String[] divide = {
            "Castle on the Hill", "Shape of You", "Galway Girl", "Supermarket Flowers", "Perfect"
    };

    String[] divideurl = {
            "https://www.dlstreams.com/download/a1d34f499ff00d3697eb4c9182faca46",
            "https://www.dlstreams.com/download/9330a932530aeb686f9a88b794c0ba4d",
            "https://www.dlstreams.com/download/e2cbff7b67fd30700d1a00260cb2d44e",
            "https://www.dlstreams.com/download/e3627710ac7be14dbcdc226982110337",
            "https://www.dlstreams.com/download/85d50577121c9cca2f6ddacfef8693c4"
    };

    String the_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listView);

        albumname = getIntent().getStringExtra("albumname");
        albumart = getIntent().getStringExtra("albumart");
        artist = getIntent().getStringExtra("artist");

        app_bar = (AppBarLayout) findViewById(R.id.app_bar);
        selected_track_title = (TextView) findViewById(R.id.selected_track_title);
        play = (ImageButton) findViewById(R.id.play);
        pause = (ImageButton) findViewById(R.id.pause);
        spinner = (ProgressBar) findViewById(R.id.loading);
        spinner.setVisibility(View.GONE);

        final ListViewSongs customList1 = new ListViewSongs(this, vivegam, vivegamurl);
        final ListViewSongs customList2 = new ListViewSongs(this, memories, memoriesurl);
        final ListViewSongs customList3 = new ListViewSongs(this, jagga, jaggaurl);
        final ListViewSongs customList4 = new ListViewSongs(this, got, goturl);
        final ListViewSongs customList5 = new ListViewSongs(this, divide, divideurl);

        switch (albumname) {
            case "Vivegam":

                listView.setAdapter(customList1);
                append();
                break;
            case "Memories - Do Not Open":

                listView.setAdapter(customList2);
                append();
                break;

            case "Jagga Jasoos":

                listView.setAdapter(customList3);
                append();
                break;

            case "Game of Thrones":

                listView.setAdapter(customList4);
                append();
                break;

            case "Divide":

                listView.setAdapter(customList5);
                append();
                break;
        }

        music = new MediaPlayer();
        music.setAudioStreamType(AudioManager.STREAM_MUSIC);

        sBar = (SeekBar) findViewById(R.id.sBar);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                music.reset();

                TextView songname = (TextView) view.findViewById(R.id.songname);
                String name = songname.getText().toString();
                selected_track_title.setText(name);
                TextView surl = (TextView) view.findViewById(R.id.surl);
                the_url = surl.getText().toString();

                try {
                    music.setDataSource(the_url);
                    music.prepare();
                    music.start();

                    sBar.setMax(music.getDuration());
                    sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }

                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            if (music != null && fromUser) {
                                music.seekTo(progress);
                            }
                        }
                    });


                    if (!music.isPlaying())
                        spinner.setVisibility(View.VISIBLE);
                    else
                        spinner.setVisibility(View.GONE);
                } catch (IOException e) {

                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!music.isPlaying())
                    music.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (music.isPlaying())
                    music.pause();
            }
        });


        getSupportActionBar().setTitle(albumname);

        art = (TextView) findViewById(R.id.artist);
        art.setText(artist);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "NULL ACTION", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        music.reset();
        this.finish();
    }

    public void append() {

        Picasso.with(getApplicationContext()).load(albumart).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Drawable d = new BitmapDrawable(getResources(), bitmap);
                app_bar.setBackground(d);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Log.d("TAG", "FAILED");
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                Log.d("TAG", "Prepare Load");
            }
        });

    }

}
