package com.example.multimediaapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        setTitle("MusicActivity");
    }

    public void lancerLaMusic(View view) {
        startService(new Intent(MusicActivity.this, MusicService.class));
    }

    public void stopperLaMusic(View view) {
        stopService(new Intent(MusicActivity.this, MusicService.class));
    }
}
