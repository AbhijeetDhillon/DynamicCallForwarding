package com.blueskyapps.getmycall;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Help1Fragment();
            case 1:
                return new Help2Fragment();
            case 2:
                return new Help3Fragment();
            case 3:
                return new Help4Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}