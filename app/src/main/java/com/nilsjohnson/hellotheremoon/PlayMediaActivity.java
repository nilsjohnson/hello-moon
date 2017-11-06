package com.nilsjohnson.hellotheremoon;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by Nils on 11/1/2017.
 */

public class PlayMediaActivity extends AppCompatActivity
{
    private static final String TAG = "PlayMediaActivity";

    // extras
    private static final String EXTRA_MEDIA_RESOURCE_ID = "com.nilsjohnson.hellotheremoon.mediaResourceId";
    private int mediaResourceId;

    private static final String EXTRA_MEDIA_TYPE = "com.nilsjohnson.hellotheremoon.mediaType";
    private MediaType mediaType;

    private static final String EXTRA_IMG_RESOURCE_ID = "com.nilsjohnson.hellotheremoon.imgResId";
    private int imgResId;

    // to hold the image corresponding to the media
    private ImageView ivMediaImage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_media_activity);

        imgResId = getIntent().getIntExtra(EXTRA_IMG_RESOURCE_ID, 0);
        mediaResourceId = getIntent().getIntExtra(EXTRA_MEDIA_RESOURCE_ID, 0);
        mediaType = (MediaType) getIntent().getSerializableExtra(EXTRA_MEDIA_TYPE);

        ivMediaImage = (ImageView) findViewById(R.id.ivMediaImage);
        ivMediaImage.setImageResource(imgResId);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null)
        {
            switch(mediaType)
            {
                case AUDIO:
                    fragment = PlaySoundFragment.newInstance(mediaResourceId);
                    break;
                case VIDEO:
                    fragment = PlayVideoFragment.newInstance(mediaResourceId);
                    break;
                default:
                    Log.d(TAG, "Unknown MediaType Passed from MainActivity to PlayMediaActivity");
            }

            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    public static Intent getNewIntent(Context packageContext, int imgResId, int mediaResId, MediaType media)
    {
        Intent intent = new Intent(packageContext, PlayMediaActivity.class);
        intent.putExtra(EXTRA_IMG_RESOURCE_ID, imgResId);
        intent.putExtra(EXTRA_MEDIA_RESOURCE_ID, mediaResId);
        intent.putExtra(EXTRA_MEDIA_TYPE, media);
        return intent;
    }


    /*
     public static Intent getNewIntent(Context packageContext, int hintResId)
    {
        Intent intent = new Intent(packageContext, HintActivity.class);
        intent.putExtra(EXTRA_HINT_STR_RES_ID, hintResId);
       return intent;
    }

     */


}
