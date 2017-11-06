package com.nilsjohnson.hellotheremoon;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Nils on 11/1/2017.
 */

public class PlaySoundFragment extends Fragment
{
    public final static String TAG = "PlaySoundFragment";
    private final static String ARG_SOUND_RES_ID = "sound_resource_id";

    private int soundResId;

    private  MediaPlayer mediaPlayer;

    // to fire action that plays sound
    Button btnPlaySound;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        soundResId = (int) getArguments().getSerializable(ARG_SOUND_RES_ID);
        mediaPlayer = MediaPlayer.create(getActivity(), soundResId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // inflate(layout resouce id, view's parent, tells layout inflater whether to add the inflated view to the views parent or not
        View view = inflater.inflate(R.layout.fragment_play_sound, container, false);

        btnPlaySound = (Button) view.findViewById(R.id.btn_play_sound);

        btnPlaySound.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Log.d(TAG, "Play Sound Clicked");
                mediaPlayer.start();
            }
        });

        return view;
    }

    @Override
    public void onPause()
    {
        super.onPause();
        mediaPlayer.stop();
    }


    public static PlaySoundFragment newInstance(int soundResId)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_SOUND_RES_ID, soundResId);
        PlaySoundFragment frag = new PlaySoundFragment();
        frag.setArguments(args);
        return frag;
    }
}
