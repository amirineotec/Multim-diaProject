package com.example.multimediaapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.desmond.squarecamera.CameraActivity;
import com.desmond.squarecamera.ImageUtility;

public class CamActivity extends AppCompatActivity {
    ImageView iconImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        iconImage = findViewById(R.id.iconImage);


    }

    public void camera(View view) {
        try {
            Intent startCustomCameraIntent = new Intent(CamActivity.this, CameraActivity.class);
            startActivityForResult(startCustomCameraIntent, 99);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {

        try {
            if (requestCode == 99) {
                Uri photoUri = intent.getData();
                Bitmap bitmap = ImageUtility.decodeSampledBitmapFromPath(photoUri.getPath(), 1000, 1000);
                iconImage.setImageBitmap(bitmap);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }
}
