package com.udacity.gradle.builditbigger;

import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Vladimir Mikhalev 28.03.2018.
 */

public class FreeMainActivity extends MainActivity {

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.test_interstitial_ad_unit_id));


        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                FreeMainActivity.super.tellJoke();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        interstitialAd.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public void tellJoke() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            super.tellJoke();
        }
    }
}
