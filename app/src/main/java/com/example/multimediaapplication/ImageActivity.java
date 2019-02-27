package com.example.multimediaapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageActivity extends AppCompatActivity {
    ImageView imgIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imgIcon = findViewById(R.id.imgIcon);


        try {
            String path = "http://amiros.alwaysdata.net/android.jpg";

            Glide.with(this) //créer une instance de GLIDE
                    .load(path)  //affectation de l'url
                    .placeholder(R.mipmap.ic_launcher_round) // s'affiche avant la fin de chargement
                    .error(R.mipmap.ic_launcher) // elle s'affiche en cas d'erreur
                    .into(imgIcon); //affectation de l'image dans l'imageView
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
