package com.example.multimediaapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void lancerRechercheActivity(View view) {
        //lancer une intent explicite
        Intent intent = new Intent(MainActivity.this, RechercheActivity.class);
        startActivity(intent);
    }

    public void lancerMusicActivity(View view) {
        Intent intent = new Intent(MainActivity.this, MusicActivity.class);
        startActivity(intent);
    }

    public void lancerVideoActivity(View view) {
        Intent intent = new Intent(MainActivity.this, VideoActivity.class);
        startActivity(intent);
    }
}
