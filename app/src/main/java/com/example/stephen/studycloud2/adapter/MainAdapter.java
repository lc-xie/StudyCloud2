package com.example.stephen.studycloud2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by stephen on 17-4-7.
 */

public class MainAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public MainAdapter(FragmentManager fm, List<Fragment> mList){
        super(fm);
        this.list=mList;
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
