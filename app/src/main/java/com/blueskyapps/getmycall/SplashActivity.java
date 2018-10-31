package com.blueskyapps.getmycall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        View decorView = getWindow().getDecorView();

        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        final SharedPreferences sharedPreferences = getSharedPreferences("mini_db",MODE_PRIVATE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                if(sharedPreferences.getBoolean("firstTime",true)){
                    //Intent intent = new Intent(SplashActivity.this,PasswordActivity.class);
                    Intent intent = new Intent(SplashActivity.this,HelpActivity.class);
                    startActivity(intent);
                    Log.d("TAG", "run: "+sharedPreferences.getBoolean("firstTime",true));
                }else{
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        }, 1000);
    }
}
