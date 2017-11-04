package com.nilsjohnson.hellotheremoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";
    // dog buttons
    Button btnPlayBarkOne;
    Button btnPlayDogVideo;
    Button btnPlayBarkTwo;

    // cat buttons
    Button btnPlayMeowOne;
    Button btnPlayCatVideo;
    Button btnPlayMeowTwo;

    // images
    ImageView imageDogThumbnail;
    ImageView imageCatThumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Actions
        class PlaySoundHandler implements View.OnClickListener
        {
            @Override
            public void onClick(View v)
            {
                Log.d(TAG, "Play Sound Handler Fired!");
                Intent intent = PlaySoundActivity.newIntent(MainActivity.this);
                intent.putExtra("VideoId", R.raw.cat_video);
                startActivity(intent);
            }
        }

        class PlayVideoHandler implements View.OnClickListener
        {
            @Override
            public void onClick(View v)
            {
                Log.d(TAG, "Play Video Handler Fired!");
                Intent intent = PlayVideoActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        }

        btnPlayBarkOne = (Button) findViewById(R.id.btnPlayBarkSound1);
        btnPlayBarkOne.setOnClickListener(new PlaySoundHandler());

        btnPlayDogVideo = (Button) findViewById(R.id.btnPlayDogVideo);
        btnPlayDogVideo.setOnClickListener(new PlayVideoHandler());
    }
}
