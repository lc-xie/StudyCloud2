package com.example.stephen.studycloud2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.stephen.studycloud2.adapter.MainAdapter;
import com.example.stephen.studycloud2.fragment.HomeFragment;
import com.example.stephen.studycloud2.fragment.PersonalFragment;
import com.example.stephen.studycloud2.fragment.ShopFragment;
import com.example.stephen.studycloud2.fragment.StudyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainAdapter mainAdapter;
    private List<Fragment> fragmentList;
    private ViewPager viewPager;

    private ImageView home,study,shop,personal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        fragmentList.add(new HomeFragment());
        fragmentList.add(new StudyFragment());
        fragmentList.add(new ShopFragment());
        fragmentList.add(new PersonalFragment());

        FragmentManager fragmentManager=getSupportFragmentManager();
        mainAdapter=new MainAdapter(fragmentManager,fragmentList);

        viewPager.setAdapter(mainAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new MyPageChangeListener());


    }

    private void init(){
        viewPager=(ViewPager)findViewById(R.id.viewpager_main);

        home=(ImageView)findViewById(R.id.main_home);
        study=(ImageView)findViewById(R.id.main_study);
        shop=(ImageView)findViewById(R.id.main_shop);
        personal=(ImageView)findViewById(R.id.main_personal);

        home.setOnClickListener(new MyOnClickedListener());
        study.setOnClickListener(new MyOnClickedListener());
        shop.setOnClickListener(new MyOnClickedListener());
        personal.setOnClickListener(new MyOnClickedListener());

        fragmentList=new ArrayList<Fragment>();
    }
    private class MyOnClickedListener implements View.OnClickListener{
       /* private int index = 0;

        public MyOnClickedListener(int i) {
            index = i;
        }*/

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.main_home:
                    resetImage();
                    viewPager.setCurrentItem(0);
                    home.setImageResource(R.drawable.home_pressed);
                    break;
                case R.id.main_study:
                    resetImage();
                    viewPager.setCurrentItem(1);
                    study.setImageResource(R.drawable.study_pressed);
                    break;
                case R.id.main_shop:
                    resetImage();
                    viewPager.setCurrentItem(2);
                    shop.setImageResource(R.drawable.shop_pressed);
                    break;
                case R.id.main_personal:
                    resetImage();
                    viewPager.setCurrentItem(3);
                    personal.setImageResource(R.drawable.personal_pressed);
                    break;
            }
        }
    }

    //页面改变监听器
    public class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
            pageChange();
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

    }

    public void pageChange(){
        int page=viewPager.getCurrentItem();
        switch (page){
            case 0:
                resetImage();
                home.setImageResource(R.drawable.home_pressed);
                break;
            case 1:
                resetImage();
                study.setImageResource(R.drawable.study_pressed);
                break;
            case 2:
                resetImage();
                shop.setImageResource(R.drawable.shop_pressed);
                break;
            case 3:
                resetImage();
                personal.setImageResource(R.drawable.personal_pressed);
                break;
        }
    }

    private void resetImage(){
        home.setImageResource(R.drawable.home);
        study.setImageResource(R.drawable.study);
        shop.setImageResource(R.drawable.shop);
        personal.setImageResource(R.drawable.personal);
    }

}
