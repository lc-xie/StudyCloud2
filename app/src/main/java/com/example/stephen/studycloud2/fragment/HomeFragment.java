package com.example.stephen.studycloud2.fragment;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stephen.studycloud2.R;
import com.example.stephen.studycloud2.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephen on 17-4-7.
 */

public class HomeFragment extends Fragment {

    private HomeAdapter homeAdapter;
    private ViewPager viewPagerHome;
    private List<Fragment> homeFragmentList;

    private TextView material,strategy;
    private ImageView cursorInHome;

    private int bmpWInHome = 0; // 游标宽度
    private int offsetInHome = 0;// // 动画图片偏移量
    private int currIndexInHome = 0;// 当前页卡编号

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home,container,false);
        init();

        this.bmpWInHome = BitmapFactory.decodeResource(getResources(), R.drawable.a)
                .getWidth();// 获取图片宽度
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 获取分辨率宽度
        this.offsetInHome = (screenW /2 - bmpWInHome) / 2;// 计算偏移量

        Matrix matrix = new Matrix();
        matrix.postTranslate(offsetInHome, 0);
        cursorInHome.setImageMatrix(matrix);

        material.setOnClickListener(new MyOnClickListener1(0));
        strategy.setOnClickListener(new MyOnClickListener1(1));
        homeFragmentList=new ArrayList<Fragment>();
        homeFragmentList.add(new HomeMaterialFragment());
        homeFragmentList.add(new HomeStrategyFragment());

        FragmentManager fragmentManager=getChildFragmentManager();
        homeAdapter=new HomeAdapter(fragmentManager,homeFragmentList);

        viewPagerHome.setAdapter(homeAdapter);
        viewPagerHome.setOnPageChangeListener(new MyPageChangeListener());
        viewPagerHome.setCurrentItem(0);


        return view;
    }

    private class MyOnClickListener1 implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener1(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            viewPagerHome.setCurrentItem(index);
        }
    }


    //页面改变监听器
    public class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        int one = offsetInHome * 2 + bmpWInHome;// 页卡偏移量

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            if (arg0 == 1) {
                animation = new TranslateAnimation(0, one, 0, 0);
            }else if(arg0==0){
                animation = new TranslateAnimation(one, 0, 0, 0);
            }
            currIndexInHome = arg0;
            animation.setFillAfter(true);// True:图片停在动画结束位置
            animation.setDuration(300);
            cursorInHome.startAnimation(animation);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }


    private void init(){
        cursorInHome=(ImageView)view.findViewById(R.id.cursor_home);
        viewPagerHome=(ViewPager)view.findViewById(R.id.viewpager_home);
        material=(TextView)view.findViewById(R.id.material);
        strategy=(TextView)view.findViewById(R.id.strategy);
    }
}
