package com.example.stephen.studycloud2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by stephen on 17-4-8.
 */

public class StudyAdapter extends FragmentPagerAdapter {
    private List<Fragment>list;
    public StudyAdapter(FragmentManager fm,List<Fragment> list){
        super(fm);
        this.list=list;
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
