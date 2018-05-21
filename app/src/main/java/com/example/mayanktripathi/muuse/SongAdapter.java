package com.example.mayanktripathi.muuse;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mayanktripathi on 21/05/18.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {

    Context context;
    ArrayList<SongModel> arrayList;

    SongAdapter(Context context, ArrayList<SongModel> arrayList){
        this.context = context;
        this. arrayList = arrayList;
    }

    @Override
    public SongHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(context).inflate(R.layout.song_list_item, parent, false);
        return new SongHolder(myView);
    }

    @Override
    public void onBindViewHolder(SongHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SongHolder extends RecyclerView.ViewHolder {

        TextView songName, artistName;
        Button action;

        public SongHolder(View itemView) {
            super(itemView);
            songName = (TextView) itemView.findViewById(R.id.song_name);
            artistName = (TextView) itemView.findViewById(R.id.song_artist);
            action = (Button) itemView.findViewById(R.id.action);
        }
    }
}
