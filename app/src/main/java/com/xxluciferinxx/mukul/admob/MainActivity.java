package com.xxluciferinxx.mukul.admob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class MainActivity extends AppCompatActivity {

    AdView adview;
    Button but1,but2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-5629116281807493~7279508232");

        final AdRequest adRequest = new AdRequest.Builder().build();

        adview = findViewById(R.id.adView);
        adview.loadAd(adRequest);


        final InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-5629116281807493/9815006380");
        interstitialAd.loadAd(adRequest);

        final RewardedVideoAd rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);

        rewardedVideoAd.loadAd("ca-app-pub-5629116281807493/4382059766",adRequest);

        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interstitialAd.loadAd(adRequest);
                if (interstitialAd.isLoaded()){
                    interstitialAd.show();
                }
                interstitialAd.loadAd(adRequest);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rewardedVideoAd.isLoaded()){
                    rewardedVideoAd.show();
                }
                rewardedVideoAd.loadAd("ca-app-pub-5629116281807493/4382059766",adRequest);
            }
        });
    }
}
