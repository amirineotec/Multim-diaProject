package com.example.multimediaapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;


public class VideoActivity extends Activity {

    PlayerView player_view;
    SimpleExoPlayer player;
    DataSource.Factory dataSrouceFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        setTitle("VideoActivity");
        player_view = findViewById(R.id.player_view);
        try {
            player = ExoPlayerFactory.newSimpleInstance(this);
            dataSrouceFactory =
                    new DefaultDataSourceFactory(this,
                            Util.getUserAgent(this, "Video"));
            player_view.setPlayer(player);

            String videoUrl = "http://amiros.alwaysdata.net/video.mp4";
            MediaSource videeSource = new ExtractorMediaSource.Factory(dataSrouceFactory)
                    .createMediaSource(Uri.parse(videoUrl));

            //Resize Video
            player_view.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL);
            player.setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);


            player.setPlayWhenReady(true);
            player.prepare(videeSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }


    }
}
