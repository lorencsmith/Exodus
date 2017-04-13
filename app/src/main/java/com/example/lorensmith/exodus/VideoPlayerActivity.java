package com.example.lorensmith.exodus;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by lorensmith on 4/9/17.
 */

public class VideoPlayerActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r6---sn-vgqsens7.googlevideo.com/Cj0LENy73wIaNAlSxV_pshjvtxMYDSANFC3azO5YMOCoAUIASARg76vVu6eHn95YigELNWNwU3prT0RkbUEM/B4D4B5065A6155256245AA13DFB887BC105CAEC3.972D8E497EB9622207699BF292E0DCCA55EE7206/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
}
