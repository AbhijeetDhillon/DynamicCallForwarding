package com.blueskyapps.getmycall;


import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Info {

    public String getInfo() {
        String information;
        SimpleDateFormat sdf = new SimpleDateFormat("$" + "yyyyMMdd-HHmm", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        information = sdf.format(new Date());
        Log.d("INFORMATION", "getInfo: " + information);
        return information;
    }

    public String getDate(){
        String currentDate;
        SimpleDateFormat sdfCurrentDate = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        sdfCurrentDate.setTimeZone(TimeZone.getTimeZone("GMT"));
        currentDate = sdfCurrentDate.format(new Date());
        return currentDate;
    }

    public Boolean checkInfo(String time) {
        long difference, min = 99;
        time = time.substring(0, 2) + ":" + time.substring(2, 4);

        Log.d("KARMA", "checkInfo: -->" + time);

        String pattern = "HH:mm";

        Log.d("KARMA", "checkInfo: " + time);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ENGLISH);
        SimpleDateFormat sdfSecondary = new SimpleDateFormat(pattern, Locale.ENGLISH);
        Date timeGenerated = null;

        try {
            timeGenerated = sdfSecondary.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            String buf = sdf.format(new Date());
            Log.d("KARMA", "checkInfo:-->>>> " + buf);
            Date timeNow = sdfSecondary.parse(buf);

            Log.d("KARMA", "checkInfo: Message Expiry Checker\nGenerated Time: " + timeGenerated + "\nTime Now: " + timeNow);


            //  Log.d("KARMA", "checkInfo: Time Difference: "+difference);
            //if()

            difference = (timeNow.getTime() - timeGenerated.getTime()) / 1000;
            long hours = difference % (24 * 3600) / 3600; // Calculating Hours
            long minute = difference % 3600 / 60; // Calculating minutes if there is any minutes difference
            min = minute + (hours * 60);

            Log.d("KARMA", "Message Time Difference " + min);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return min <= 3;
    }

}


