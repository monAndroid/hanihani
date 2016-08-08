package com.moonhani.hanihani.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.moonhani.hanihani.fragment.PtFragment01;
import com.moonhani.hanihani.fragment.PtFragment02;
import com.moonhani.hanihani.fragment.PtFragment03;

public class PtPagerAdapter extends FragmentStatePagerAdapter  {
    public static int int_items = 3;

    public PtPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)  {
        switch (position){
            case 0 : return new PtFragment01();
            case 1 : return new PtFragment02();
            case 2 : return new PtFragment03();
        }
        return null;
    }

    @Override
    public int getCount() {
        return int_items;
    }

    /**
     * This method returns the title of the tab according to the position.
     */

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0 :
                return "대기";
            case 1 :
                return "치료";
            case 2 :
                return "완료";
        }
        return null;
    }
}
