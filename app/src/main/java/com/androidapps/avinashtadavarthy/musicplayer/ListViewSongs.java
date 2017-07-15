package com.androidapps.avinashtadavarthy.musicplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ListViewSongs extends ArrayAdapter<String> {

    private Activity context;
    private String[] songnames;
    private String[] songurl;

    public ListViewSongs(Activity context, String[] songnames, String[] songurl) {
        super(context, R.layout.list_view_layout, songnames);
        this.context = context;
        this.songnames = songnames;
        this.songurl = songurl;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout, null, true);
        TextView songname = (TextView) listViewItem.findViewById(R.id.songname);
        songname.setText(songnames[position]);
        TextView surl = (TextView) listViewItem.findViewById(R.id.surl);
        surl.setText(songurl[position]);
        return listViewItem;
    }
}
