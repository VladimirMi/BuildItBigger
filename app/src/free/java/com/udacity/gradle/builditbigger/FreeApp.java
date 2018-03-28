package com.udacity.gradle.builditbigger;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

/**
 * Created by Vladimir Mikhalev 25.03.2018.
 */

public class FreeApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MobileAds.initialize(this, getString(R.string.test_app_id));
    }
}
