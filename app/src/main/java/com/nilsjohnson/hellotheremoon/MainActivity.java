package com.nilsjohnson.hellotheremoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


/*

Create an app similar to HelloMoon, that has
    two related images with two related/associated audio files, and one related video file.

On the primary page, the user should be able to:
    -choose which they want to play, and then the correct one should play.

You should have small images for the primary page, larger ones for the ‘playing’ page.

Your app should be localized to two other languages (understanding that the audio or video will  not be translated).

Your app should be able to rotate without issue.

 */

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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Actions
        class PlaySoundHandler implements View.OnClickListener
        {
            private int soundResId;
            private int imgResId;
            public PlaySoundHandler(int soundResId, int imgResId)
            {
                this.soundResId = soundResId;
                this.imgResId = imgResId;
            }
            @Override
            public void onClick(View v)
            {
                Intent intent = PlayMediaActivity.getNewIntent(MainActivity.this, imgResId, soundResId, MediaType.AUDIO);
                startActivity(intent);
            }
        }

        class PlayVideoHandler implements View.OnClickListener
        {
            private int vidResId;
            private int imgResId;
            public PlayVideoHandler(int vidResId, int imgResId)
            {
                this.vidResId = vidResId;
                this.imgResId = imgResId;
            }
            @Override
            public void onClick(View v)
            {
                Log.d(TAG, "Play Video Handler Fired!");
                Intent intent = PlayMediaActivity.getNewIntent(MainActivity.this, imgResId, vidResId, MediaType.VIDEO);
                startActivity(intent);
            }
        }

        // set buttons and actions dog media
        btnPlayBarkOne = (Button) findViewById(R.id.btnPlayBarkSound1);
        btnPlayBarkOne.setOnClickListener(new PlaySoundHandler(R.raw.dog_bark, R.drawable.dog));

        btnPlayDogVideo = (Button) findViewById(R.id.btnPlayDogVideo);
        btnPlayDogVideo.setOnClickListener(new PlayVideoHandler(R.raw.dog_video, R.drawable.dog));

        btnPlayBarkTwo = (Button) findViewById(R.id.btnPlayBarkSound2);
        btnPlayBarkTwo.setOnClickListener(new PlaySoundHandler(R.raw.dog_bark_2, R.drawable.dog));

        // set buttons and actions for cat media
        btnPlayMeowOne = (Button) findViewById(R.id.btnPlayMeowSound1);
        btnPlayMeowOne.setOnClickListener(new PlaySoundHandler(R.raw.cat_meow, R.drawable.cat));

        btnPlayCatVideo = (Button) findViewById(R.id.btnPlayCatVideo);
        btnPlayCatVideo.setOnClickListener(new PlayVideoHandler(R.raw.cat_video, R.drawable.cat));

        btnPlayMeowTwo = (Button) findViewById(R.id.btnPlayMeowSound2);
        btnPlayMeowTwo.setOnClickListener(new PlaySoundHandler(R.raw.cat_meow_2, R.drawable.cat));
    }
}
