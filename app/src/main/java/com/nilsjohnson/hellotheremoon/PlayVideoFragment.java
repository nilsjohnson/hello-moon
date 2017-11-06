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

    private Button btnPlayVideo;
    private VideoView videoView;

    private static final String ARG_VIDEO_RES_ID = "video_res_id";
    private int videoResId;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        videoResId = (int) getArguments().getSerializable(ARG_VIDEO_RES_ID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Log.d(TAG, "Creating 'PlayVideoFragment View");
        View view = inflater.inflate(R.layout.fragment_play_video, container, false);
        videoView = (VideoView) view.findViewById(R.id.videoView);

        btnPlayVideo = (Button) view.findViewById(R.id.btn_play_video);
        btnPlayVideo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Log.d(TAG, "Play Video Clicked");
                String path = "android.resource://" + getActivity().getPackageName() + "/" + videoResId;
                Uri uri = Uri.parse(path);
                videoView.setVideoURI(uri);
                videoView.start();
            }
        });

        return view;
    }

    @Override
    public void onPause()
    {
        super.onPause();
        videoView.pause();

    }

    public static PlayVideoFragment newInstance(int videoResId)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_VIDEO_RES_ID, videoResId);
        PlayVideoFragment frag = new PlayVideoFragment();
        frag.setArguments(args);
        return frag;
    }
}

