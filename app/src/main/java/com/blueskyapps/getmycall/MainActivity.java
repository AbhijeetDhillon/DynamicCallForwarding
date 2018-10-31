package com.blueskyapps.getmycall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView imgBtnPswrd, imgBtnHelp, imgBtnRCancel, imgBtnStop, imgBtnSend, imgBtnSet;
    SharedPreferences sharedPreferences;
    private AdView mAdView;
    public static InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-1909122143192244~4427028817");
        sharedPreferences = getSharedPreferences("mini_db", MODE_PRIVATE);
        //ad initialization
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        imgBtnPswrd = findViewById(R.id.imgBtnPswrd);
        imgBtnHelp = findViewById(R.id.imgBtnHelp);
        imgBtnRCancel = findViewById(R.id.imgBtnRCancel);
        imgBtnStop = findViewById(R.id.imgBtnStop);
        imgBtnSend = findViewById(R.id.imgBtnRSend);
        imgBtnSet = findViewById(R.id.imgBtnSet);

        imgBtnPswrd.setOnClickListener(this);
        imgBtnHelp.setOnClickListener(this);
        imgBtnRCancel.setOnClickListener(this);
        imgBtnStop.setOnClickListener(this);
        imgBtnSend.setOnClickListener(this);
        imgBtnSet.setOnClickListener(this);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBtnPswrd:
                Intent intentPassword = new Intent(MainActivity.this, PasswordActivity.class);
                startActivity(intentPassword);
                break;

            case R.id.imgBtnHelp:
                //Toast.makeText(this, "Link not updated", Toast.LENGTH_SHORT).show();
                Intent intentHelp = new Intent(MainActivity.this, Test1.class);
                startActivity(intentHelp);
                break;

            case R.id.imgBtnStop:
                Dialer dialer = new Dialer();
                dialer.RemoveCallForwarding(MainActivity.this);
                Toast.makeText(this, "Deactivating call forwarding", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imgBtnRCancel:
                Intent intentCancel = new Intent(MainActivity.this, SendActivity.class);
                intentCancel.putExtra("mode", "cancel");
                startActivity(intentCancel);
                break;

            case R.id.imgBtnRSend:
                Intent intentSend = new Intent(MainActivity.this, SendActivity.class);
                intentSend.putExtra("mode", "send");
                startActivity(intentSend);
                break;

            case R.id.imgBtnSet:
                Intent intentSet = new Intent(MainActivity.this, SetActivity.class);
                startActivity(intentSet);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.rateus:
                Toast.makeText(this, "Rate US", Toast.LENGTH_SHORT).show();
                break;

            case R.id.moreapps:
                Toast.makeText(this, "More Apps", Toast.LENGTH_SHORT).show();
                break;

            case R.id.about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }


}


