package com.example.lorensmith.exodus;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;


/**
 * Created by lorensmith on 4/9/17.
 */

public class VideoPlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
    public static final String API_KEY = "AIzaSyDX7nOWhTEeT13ENsOLOs2O3V6_jx0Yb6o";
    private static final int RECOVERY_REQUEST = 1;
    YouTubePlayerView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = (YouTubePlayerView) findViewById(R.id.videoView);
        videoView.initialize(API_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean check) {
        if(!check){
            youTubePlayer.cueVideo("t-8YsulfxVI");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }
    protected Provider getYouTubePlayerProvider() {
        return videoView;
    }
}
