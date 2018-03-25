package com.udacity.gradle.builditbigger;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

/**
 * Created by Vladimir Mikhalev 25.03.2018.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
    }
}
