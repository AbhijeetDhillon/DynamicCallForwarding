package com.blueskyapps.getmycall;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {

    TextInputEditText etPasswordOld, etPassword1, etPassword2;
    Button btnSetPassword;
    String TAG = "KARMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        //this.setFinishOnTouchOutside(false);

        /*//Action bar back button
        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }catch (Exception e){
            Log.d("KARMA","Back button setting failed");
        }
        //----------------------*/

        etPasswordOld = findViewById(R.id.inputOldPass);
        etPassword1 = findViewById(R.id.inputNewPass);
        etPassword2 = findViewById(R.id.inputNewRePass);
        btnSetPassword = findViewById(R.id.buttonSetPassword);

        btnSetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPassword();
            }
        });

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) !=
                PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, 1);
        }




    }

    private void setPassword() {
        SharedPreferences sharedPreferences = getSharedPreferences("mini_db", MODE_PRIVATE);
        String pass1, pass2, passOld;
        passOld = etPasswordOld.getText().toString();
        pass1 = etPassword1.getText().toString();
        pass2 = etPassword2.getText().toString();

        if (!pass1.equals("") && pass1.equals(pass2)) {
            if (passOld.equals(sharedPreferences.getString("password", "abc123"))) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("password", pass1);
                editor.apply();
                Toast.makeText(this, "Password Created Successfully", Toast.LENGTH_SHORT).show();
                //display_ad
                if (MainActivity.mInterstitialAd.isLoaded() && AdSequence.globalVariable %2 ==0) {

                    MainActivity.mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                AdSequence.globalVariable ++ ;
                finish();
            } else {
                Toast.makeText(this, "Wrong Password!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Password doesn't matched! ", Toast.LENGTH_SHORT).show();
        }

        Log.d(TAG, "setPassword: " + pass1 + pass2 + passOld);
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
