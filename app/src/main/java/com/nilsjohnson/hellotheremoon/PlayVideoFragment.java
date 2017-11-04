package com.nilsjohnson.hellotheremoon;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

/**
 * Created by Nils on 11/2/2017.
 */

public class PlayVideoFragment extends Fragment
{
    public final static String TAG = "PlayVideoFragment";

    // to fire action that plays sound
    private Button btnPlayVideo;
    private VideoView videoView;

    private int videoId;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Log.d(TAG, "Creating 'PlayVideoFragment View");
        // inflate(layout resouce id, view's parent, tells layout inflater whether to add the inflated view to the views parent or not
        View view = inflater.inflate(R.layout.fragment_play_video, container, false);

        videoView = (VideoView) view.findViewById(R.id.videoView);


        MediaPlayer video = MediaPlayer.create(getActivity(), R.raw.cat_video);
        video.start();

        btnPlayVideo = (Button) view.findViewById(R.id.btn_play_video);

        btnPlayVideo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Log.d(TAG, "Play Video Clicked");
                String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.cat_video;
                Uri uri = Uri.parse(path);
                videoView.setVideoURI(uri);
                videoView.start();
            }
        });

        return view;
    }
}

