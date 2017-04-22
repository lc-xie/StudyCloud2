package com.example.stephen.studycloud2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by stephen on 17-4-8.
 */

public class HomeAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public HomeAdapter(FragmentManager fm,List<Fragment> object){
        super(fm);
        this.list=object;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
