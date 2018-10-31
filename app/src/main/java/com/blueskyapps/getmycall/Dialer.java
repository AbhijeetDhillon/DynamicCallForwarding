package com.blueskyapps.getmycall;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

public class Dialer {

    public void SetCallForwarding(Context context,String number) {
        Toast.makeText(context, "Call Forwarding initiated", Toast.LENGTH_LONG).show();
        String code = "**21*" + number + "#";
        Intent intentCallForward = new Intent(Intent.ACTION_CALL); // ACTION_CALL
        Uri uri2 = Uri.fromParts("tel", code, "#");
        intentCallForward.setData(uri2);
        intentCallForward.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        context.startActivity(intentCallForward);
        Toast.makeText(context, "Call forwarding set successfully", Toast.LENGTH_LONG).show();
    }

    public void RemoveCallForwarding(Context context) {
        String code = "#21#";
        Intent intentCallForward = new Intent(Intent.ACTION_CALL); // ACTION_CALL
        Uri uri2 = Uri.fromParts("tel", code, "#");
        intentCallForward.setData(uri2);
        intentCallForward.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        context.startActivity(intentCallForward);
    }
}
