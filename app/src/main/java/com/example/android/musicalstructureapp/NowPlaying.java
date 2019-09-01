package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        /**
         * Here we check if the intent that led to this activity had any Extras in
         * "SONG_ID" and "SONG_ARRAY"
         */
        Intent intent = getIntent();
        if(intent.hasExtra("SONG_ID") && intent.hasExtra("SONG_ARRAY")){
            long songID = getIntent().getLongExtra("SONG_ID",0);
            int id = (int) songID;
            ArrayList<Song> musicList = getIntent().getParcelableArrayListExtra("SONG_ARRAY");
            Song currentSong =musicList.get(id);
            TextView songTitleTextView = (TextView) findViewById(R.id.song_title_text_view);
            songTitleTextView.setText(currentSong.getSongTitle());
            TextView artistTextView = (TextView) findViewById(R.id.artist_text_view);
            artistTextView.setText(currentSong.getSongArtist());
        }
        /**
         * Set onClickListener for Library Button
         */
        Button libraryBtn = (Button) findViewById(R.id.library_button);
        libraryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent libraryIntent = new Intent(NowPlaying.this, MainActivity.class);
                startActivity(libraryIntent);
            }
        });
    }
}
