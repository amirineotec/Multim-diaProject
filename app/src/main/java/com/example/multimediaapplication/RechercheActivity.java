package com.example.multimediaapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class RechercheActivity extends AppCompatActivity {

    EditText edtTextSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        edtTextSearch = findViewById(R.id.edtTextSearch);
        setTitle("RechercheActivity");

    }

    public void search(View view) {
        String txtSearch = edtTextSearch.getText().toString();
        if (!TextUtils.isEmpty(edtTextSearch.getText())) {
            final String requeteSearch = "http://google.fr/search?q=" + txtSearch;
            Uri uri = Uri.parse(requeteSearch);
            //Creation intent implicite
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            //lancement de l'intent implicite
            startActivity(intent);
            edtTextSearch.setText("");

        }

    }
}
