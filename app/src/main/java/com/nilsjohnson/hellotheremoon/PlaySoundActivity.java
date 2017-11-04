package com.nilsjohnson.hellotheremoon;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by Nils on 11/1/2017.
 */

public class PlaySoundActivity extends SingleFragmentActivity
{
    public static Intent newIntent(Context packageContext)
    {
        Intent intent = new Intent(packageContext, PlaySoundActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment()
    {
        return new PlaySoundFragment();
    }
}
