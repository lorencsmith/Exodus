package com.example.lorensmith.exodus;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=RFinNxS5KN4");
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
