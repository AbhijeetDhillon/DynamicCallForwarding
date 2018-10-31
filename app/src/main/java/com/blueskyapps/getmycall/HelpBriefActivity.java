package com.blueskyapps.getmycall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HelpBriefActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_brief);
        this.setFinishOnTouchOutside(true);
    }
}
