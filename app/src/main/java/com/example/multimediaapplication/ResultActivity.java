package com.example.multimediaapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Intent intent = new Intent(this, DetailsActivity.class);
        startActivityForResult(intent, 10);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 10) {

            if (resultCode == Activity.RESULT_OK) {
                String resultats = data.getStringExtra("texte");
                Log.e("resultats", resultats);
            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
