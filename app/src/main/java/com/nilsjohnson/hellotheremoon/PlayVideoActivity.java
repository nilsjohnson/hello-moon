package com.nilsjohnson.hellotheremoon;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by Nils on 11/2/2017.
 */

public class PlayVideoActivity extends SingleFragmentActivity
{

    public static Intent newIntent(Context packageContext)
    {
        Intent intent = new Intent(packageContext, PlayVideoActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment()
    {
        return new PlayVideoFragment();
    }
}
