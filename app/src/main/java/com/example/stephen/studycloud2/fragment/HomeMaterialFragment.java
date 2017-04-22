package com.example.stephen.studycloud2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.stephen.studycloud2.R;
import com.example.stephen.studycloud2.activity.home.FinalExamMaterialActivity;
import com.example.stephen.studycloud2.activity.home.KaoyanExamMaterialActivity;
import com.example.stephen.studycloud2.activity.home.LevelExamMaterialActivity;
import com.example.stephen.studycloud2.activity.home.OtherMaterialActivity;
import com.example.stephen.studycloud2.activity.home.SeekMaterialActivity;
import com.example.stephen.studycloud2.activity.home.ShareYourMaterialActivity;
import com.example.stephen.studycloud2.activity.home.XuebaWorksMaterialActivity;

/**
 * Created by stephen on 17-4-8.
 */

public class HomeMaterialFragment extends Fragment {

    private LinearLayout finalExamMaterial, levelExamMaterial, kaoyanExamMaterial, xuebaWorksMaterial,
            otherMaterial;
    private Button shareYourMaterial, seekMaterial;

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home_material,container,false);
        initButton();
        initClickedEvent();
        return view;
    }

    //初始化图片和按键
    private void initButton(){
        finalExamMaterial=(LinearLayout) view.findViewById(R.id.activity_final_exam);
        levelExamMaterial=(LinearLayout)view.findViewById(R.id.activity_level_exam);
        kaoyanExamMaterial=(LinearLayout)view.findViewById(R.id.activity_kaoyan_exam);
        xuebaWorksMaterial=(LinearLayout)view.findViewById(R.id.activity_xueba_works);
        otherMaterial=(LinearLayout)view.findViewById(R.id.activity_other_material);
        shareYourMaterial=(Button) view.findViewById(R.id.activity_share_material);
        seekMaterial=(Button) view.findViewById(R.id.activity_seek_material);
    }

    //设置按键响应
    private void initClickedEvent(){
        finalExamMaterial.setOnClickListener(new MyOnClickedListenerOnMaterial(R.id.activity_final_exam));
        levelExamMaterial.setOnClickListener(new MyOnClickedListenerOnMaterial(R.id.activity_level_exam));
        kaoyanExamMaterial.setOnClickListener(new MyOnClickedListenerOnMaterial(R.id.activity_kaoyan_exam));
        xuebaWorksMaterial.setOnClickListener(new MyOnClickedListenerOnMaterial(R.id.activity_xueba_works));
        otherMaterial.setOnClickListener(new MyOnClickedListenerOnMaterial(R.id.activity_other_material));
        shareYourMaterial.setOnClickListener(new MyOnClickedListenerOnMaterial(R.id.activity_share_material));
        seekMaterial.setOnClickListener(new MyOnClickedListenerOnMaterial(R.id.activity_seek_material));
    }

    //自定义按键响应类
    public class MyOnClickedListenerOnMaterial implements View.OnClickListener{

        private  int id=0;

        public MyOnClickedListenerOnMaterial(int i){
            this.id=i;
        }

        @Override
        public void onClick(View v) {
            switch (id){
                case R.id.activity_final_exam:
                    Intent intent1=new Intent(getContext(), FinalExamMaterialActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.activity_level_exam:
                    Intent intent2=new Intent(getContext(), LevelExamMaterialActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.activity_kaoyan_exam:
                    Intent intent3=new Intent(getContext(), KaoyanExamMaterialActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.activity_xueba_works:
                    Intent intent4=new Intent(getContext(), XuebaWorksMaterialActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.activity_other_material:
                    Intent intent5=new Intent(getContext(), OtherMaterialActivity.class);
                    startActivity(intent5);
                    break;
                case R.id.activity_share_material:
                    Intent intent6=new Intent(getContext(), ShareYourMaterialActivity.class);
                    startActivity(intent6);
                    break;
                case R.id.activity_seek_material:
                    Intent intent7=new Intent(getContext(), SeekMaterialActivity.class);
                    startActivity(intent7);
                    break;
                default:
                    break;
            }
        }
    }

}
