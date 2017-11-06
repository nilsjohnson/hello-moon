package com.nilsjohnson.hellotheremoon;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by Nils on 11/1/2017.
 */

public class PlaySoundFragment extends Fragment
{
    public final static String TAG = "PlaySoundFragment";

    private final static String ARG_SOUND_RES_ID = "sound_resource_id";

    private int soundResId;

    // to fire action that plays sound
    Button btnPlaySound;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // inflate(layout resouce id, view's parent, tells layout inflater whether to add the inflated view to the views parent or not
        View view = inflater.inflate(R.layout.fragment_play_sound, container, false);

        soundResId = (int) getArguments().getSerializable(ARG_SOUND_RES_ID);

        btnPlaySound = (Button) view.findViewById(R.id.btn_play_sound);
        btnPlaySound.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
               Log.d(TAG, "Play Sound Clicked");
               playSound();
            }
        });

        return view;
    }

    private void playSound()
    {
        MediaPlayer sound = MediaPlayer.create(getActivity(), soundResId);
        sound.start();
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
