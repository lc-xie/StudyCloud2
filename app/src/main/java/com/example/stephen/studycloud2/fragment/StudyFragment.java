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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stephen.studycloud2.R;
import com.example.stephen.studycloud2.adapter.StudyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephen on 17-4-7.
 */

public class StudyFragment extends Fragment{

    private ViewPager viewPagerStudy;
    private List<Fragment> studyFragmentList;
    private StudyAdapter studyAdapter;
    private TextView pager1,pager2;
    private ImageView cursorInStudy;

    private int bmpWInStudy = 0; // 游标宽度
    private int offsetInStudy = 0;// // 动画图片偏移量
    private int currIndexInStudy = 0;// 当前页卡编号

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_study,container,false);
        init();

        this.cursorInStudy=(ImageView)view.findViewById(R.id.cursor_study);
        this.bmpWInStudy = BitmapFactory.decodeResource(getResources(), R.drawable.a)
                .getWidth();// 获取图片宽度
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 获取分辨率宽度
        this.offsetInStudy = (screenW /2 - bmpWInStudy) / 2;// 计算偏移量

        Matrix matrix = new Matrix();
        matrix.postTranslate(offsetInStudy, 0);
        cursorInStudy.setImageMatrix(matrix);

        pager1=(TextView)view.findViewById(R.id.pager1);
        pager2=(TextView)view.findViewById(R.id.pager2);

        pager1.setOnClickListener(new MyOnClickListener1(0));
        pager2.setOnClickListener(new MyOnClickListener1(1));

        studyFragmentList=new ArrayList<Fragment>();
        studyFragmentList.add(new StudyPager1Fragment());
        studyFragmentList.add(new StudyPager2Fragment());

        FragmentManager fragmentManager=getChildFragmentManager();
        studyAdapter=new StudyAdapter(fragmentManager,studyFragmentList);

        viewPagerStudy.setAdapter(studyAdapter);
        viewPagerStudy.setOnPageChangeListener(new MyPageChangeListener());
        viewPagerStudy.setCurrentItem(0);


        return view;
    }

    private class MyOnClickListener1 implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener1(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            viewPagerStudy.setCurrentItem(index);
        }
    }


    //页面改变监听器
    public class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        int one = offsetInStudy * 2 + bmpWInStudy;// 页卡偏移量

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            if (arg0 == 1) {
                animation = new TranslateAnimation(0, one, 0, 0);
            }else if(arg0==0){
                animation = new TranslateAnimation(one, 0, 0, 0);
            }
            currIndexInStudy = arg0;
            animation.setFillAfter(true);// True:图片停在动画结束位置
            animation.setDuration(300);
            cursorInStudy.startAnimation(animation);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }


    private void init(){
        cursorInStudy=(ImageView)view.findViewById(R.id.cursor_study);
        viewPagerStudy=(ViewPager)view.findViewById(R.id.viewpager_study);
        pager1=(TextView)view.findViewById(R.id.pager1);
        pager2=(TextView)view.findViewById(R.id.pager2);
    }

}
