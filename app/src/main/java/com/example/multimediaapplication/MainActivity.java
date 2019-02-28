package com.example.multimediaapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

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

    public void lancerImageActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ImageActivity.class);
        startActivity(intent);
    }

    public void lancerRecordActivity(View view) {
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.RECORD_AUDIO)
                .withListener(new MultiplePermissionsListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        Log.e("onPermissionsChecked", "onPermissionsChecked");
                        Intent intent = new Intent(MainActivity.this, RecordActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

                    }
                }).check();

    }

    public void lancerCamActivity(View view) {
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            Intent intent = new Intent(MainActivity.this, CamActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    public void lancerResultActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        startActivity(intent);
    }
}
