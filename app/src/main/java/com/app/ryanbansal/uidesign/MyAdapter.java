package com.app.ryanbansal.uidesign;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by RyanBansal on 7/23/17.
 */

//public class MyAdapter extends FragmentStatePagerAdapter {
//
//    final Tab[] tabs = Tab.values();
//    final CharSequence[] titles = new CharSequence[tabs.length];
//
//    public MyAdapter(FragmentManager fm) {
//        super(fm);
//        for (int i=0;i<3;i++) {
//            titles[i] = tabs[i].toString();
//        }
//    }
//
//    public enum Tab {
//        TAB1, TAB2, TAB3;
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        TabFragment fragment = new TabFragment();
//        fragment.setPosition(position+1);
//        return fragment;
//    }
//
//    @Override
//    public int getCount() {
//        return 3;
//    }
//
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return titles[position];
//    }
//}
