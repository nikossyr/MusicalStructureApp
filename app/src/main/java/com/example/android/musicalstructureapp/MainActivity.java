package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an array of words
        final ArrayList<Song> musicList = new ArrayList<Song>();
        musicList.add(new Song("Pump it up", "Black Eyed Peas"));
        musicList.add(new Song("Take me to church", "Hozier"));
        musicList.add(new Song("Angel of the Morning", "Juice Newton"));
        musicList.add(new Song("Shoop", "Salt-N-Pepa"));
        musicList.add(new Song("Something So Right", "Four Star Riot"));
        musicList.add(new Song("The Boys Are Back", "Campfire"));
        musicList.add(new Song("It's Great When We're Together", "Finley Quaye"));
        musicList.add(new Song("Love Is a Tricky Thing", "Cate Song"));
        musicList.add(new Song("Swing That Thang", "Mentally Disturbed"));
        musicList.add(new Song("I'll Be Home for Christmas", "Bing Crosby"));
        musicList.add(new Song("Poor St. John", "Joe Marson"));
        musicList.add(new Song("Deadpool Rap", "Teamheadkick"));
        musicList.add(new Song("Light and Easy", "David Snell"));
        musicList.add(new Song("Hit The Road Jack", "Ray Charles"));
        musicList.add(new Song("Crazy", "Tim Garland"));
        musicList.add(new Song("Moonlight", "Hanni El Khatib"));
        musicList.add(new Song("No Clothes Zone", "Kidd Fresh"));
        musicList.add(new Song("Pick Me Up", "Hot Toothpaste"));
        musicList.add(new Song("X Gon' Give It to Ya", "DMX"));
        musicList.add(new Song("Careless Whisper", "George Michael"));

        SongAdapter adapter = new SongAdapter(this, musicList);

        ListView listView = (ListView) findViewById(R.id.song_list);
        listView.setAdapter(adapter);
        /**
         * Here we setOnItemClickListener for each object of the listView
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlaying.class);
                nowPlayingIntent.putParcelableArrayListExtra("SONG_ARRAY", musicList);
                nowPlayingIntent.putExtra("SONG_ID", id);
                startActivity(nowPlayingIntent);
            }
        });
        /**
         * Set onClickListener for Now Playing Button
         */
        Button nowPlayingBtn = (Button) findViewById(R.id.now_playing_button);
        nowPlayingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nowPlayingBtnIntent = new Intent(MainActivity.this, NowPlaying.class);
                startActivity(nowPlayingBtnIntent);
            }
        });
    }
}

