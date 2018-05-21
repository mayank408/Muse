package com.example.mayanktripathi.muuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView songName, artistName;
    Button action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songName = (TextView) findViewById(R.id.song_name);
        artistName = (TextView) findViewById(R.id.song_artist);
        action = (Button) findViewById(R.id.action);


    }
}
