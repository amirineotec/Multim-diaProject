package com.example.multimediaapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {

    EditText edtRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        edtRetour = findViewById(R.id.edtRetour);
    }


    public void sauvgarder(View view) {
        String texte = edtRetour.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("texte", texte);
        setResult(Activity.RESULT_OK, intent);
        finish();

    }
}
