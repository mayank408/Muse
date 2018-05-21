package com.example.mayanktripathi.muuse;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mayanktripathi on 21/05/18.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> implements View.OnClickListener{

    Context context;
    ArrayList<SongModel> arrayList = new ArrayList<>();
    MediaPlayer mediaPlayer;
    private Handler myHandler = new Handler();

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
    public void onBindViewHolder(final SongHolder holder, final int position) {
        holder.songName.setText(arrayList.get(position).songName);
        holder.artistName.setText(arrayList.get(position).artistName);
        holder.action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(holder.action.getText().equals("Stop")){
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = null;
                    holder.action.setText("Play");
                }else {

                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                mediaPlayer = new MediaPlayer();
                                mediaPlayer.setDataSource(arrayList.get(position).getSongUrl());
                                mediaPlayer.prepareAsync();
                                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                    @Override
                                    public void onPrepared(MediaPlayer mp) {
                                        mp.start();
                                    }
                                });
                                holder.action.setText("Stop");



                            }catch (Exception e){}
                        }

                    };
                    myHandler.postDelayed(runnable,100);

                }
            }


            }
        );
    }

//
//    public class runThread extends Thread {
//
//
//        @Override
//        public void run() {
//            while (true) {
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if (mediaPlayer != null) {
//                    //seekBar.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            //seekBar.setProgress(mediaPlayer.getCurrentPosition());
//                        }
//                    });
//
//                }
//            }
//        }
//
//    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.action){
            Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show();
        }

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
