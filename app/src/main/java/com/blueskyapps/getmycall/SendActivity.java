package com.blueskyapps.getmycall;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SendActivity extends AppCompatActivity implements View.OnClickListener {

    Button sendSms;
    TextInputEditText targetNo, diversionNo, targetPassword;
    TextView diversion;
    String mode, TAG = "KARMA";
    TextInputLayout textInputLayoutDN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        mode = getIntent().getStringExtra("mode");
        Log.d(TAG, "onCreate:------------------------ " + mode);

        targetNo = findViewById(R.id.targetPhNo);
        diversionNo = findViewById(R.id.targetDiversionNo);
        targetPassword = findViewById(R.id.targetPassword);
        sendSms = findViewById(R.id.buttonSendSms);
        diversion = findViewById(R.id.textDiversionNumber);
        textInputLayoutDN = findViewById(R.id.textInputLayoutDN);

        if (mode.equals("cancel")) {
            textInputLayoutDN.setVisibility(View.GONE);
            diversion.setVisibility(View.GONE);
        }

        sendSms.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String target, diversion, password;

        target = targetNo.getText().toString();
        password = targetPassword.getText().toString();


        if (mode.equals("send")) {
            diversion = diversionNo.getText().toString();
        } else {
            diversion = "0123456789";
        }

        Info info = new Info();
        String time = info.getInfo();

        if (!target.equals("") && !diversion.equals("") && !password.equals("")) {
            String messageFormat = diversion + "$" + password + "" + time;
            AES aes = new AES();
            String encryptMsg = "";
            try {
                encryptMsg = aes.encrypt(messageFormat);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SendSMS sendSMS = new SendSMS();
            sendSMS.send(target, encryptMsg, SendActivity.this);
            finish();
        }

        Toast.makeText(this, "Target No:" + target + "\nDiversion No:" + diversion + "\nPassword: " + password, Toast.LENGTH_SHORT).show();

        Log.d("KARMA", "onClick: \n Target No " + target + "\nDiversion No:" + diversion + "\nPassword:" + password);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (MainActivity.mInterstitialAd.isLoaded() && (AdSequence.globalVariable %2 ==0)) {

            MainActivity.mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        AdSequence.globalVariable ++ ;
    }
}
