package com.example.multimediaapplication;

import android.media.MediaRecorder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;

import java.io.IOException;

public class RecordActivity extends AppCompatActivity {
    private MediaRecorder recorder = null;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        chronometer = findViewById(R.id.chronometer);

    }

    public void startRecording(View view) {
        String fileName = getExternalCacheDir().getAbsolutePath();
        fileName += "/audiorecordtest.3gp";
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(fileName);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try {
            recorder.prepare();
        } catch (IOException e) {
            Log.e("IOException", "prepare() failed");
        }
        recorder.start();
        chronometer.start();
    }

    public void stopRecording(View view) {
        try {
            recorder.stop();
            recorder.release();
            recorder = null;
            chronometer.stop();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
