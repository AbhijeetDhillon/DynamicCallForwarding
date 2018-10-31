package com.blueskyapps.getmycall;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SetActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText getNumber;
    Button set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        getNumber = findViewById(R.id.getPhNo);
        set = findViewById(R.id.buttonSet);
        set.setOnClickListener(this);
        if (MainActivity.mInterstitialAd.isLoaded() && AdSequence.globalVariable %2 ==0) {

            MainActivity.mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        AdSequence.globalVariable ++ ;

    }

    @Override
    public void onClick(View v) {
        String diversionNo = getNumber.getText().toString();

        if (!diversionNo.equals("")) {
            Dialer dialer = new Dialer();
            dialer.SetCallForwarding(this, diversionNo);
            finish();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (MainActivity.mInterstitialAd.isLoaded() && AdSequence.globalVariable %2 ==0) {

            MainActivity.mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        AdSequence.globalVariable ++ ;
    }
}
