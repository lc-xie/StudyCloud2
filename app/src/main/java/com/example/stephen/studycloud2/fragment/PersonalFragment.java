package com.example.stephen.studycloud2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.stephen.studycloud2.R;
import com.example.stephen.studycloud2.activity.personal.CustomerServicePersonalActivity;
import com.example.stephen.studycloud2.activity.personal.DouPersonalActivity;
import com.example.stephen.studycloud2.activity.personal.OrderPersoanlActivity;
import com.example.stephen.studycloud2.activity.personal.RetroactionPersonalActivity;
import com.example.stephen.studycloud2.activity.personal.StrategyPersonalActivity;
import com.example.stephen.studycloud2.activity.personal.XcodePersonalActivity;

/**
 * Created by stephen on 17-4-7.
 */

public class PersonalFragment extends Fragment {

    ImageView xuedou,order,xCode,strategy,retroaction,customerService;

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_personal,container,false);
        initImage();
        setOnClickedListenerOnPersonal();

        return view;
    }

    public void initImage(){
        xuedou=(ImageView)view.findViewById(R.id.goto_dou);
        order=(ImageView)view.findViewById(R.id.goto_order);
        xCode=(ImageView)view.findViewById(R.id.goto_x_code);
        strategy=(ImageView)view.findViewById(R.id.goto_strategy);
        retroaction=(ImageView)view.findViewById(R.id.goto_retroaction);
        customerService=(ImageView)view.findViewById(R.id.goto_customer_service);
    }

    private void setOnClickedListenerOnPersonal(){
        xuedou.setOnClickListener(new MyOnClickedListenerOnPersonal(R.id.goto_dou));
        order.setOnClickListener(new MyOnClickedListenerOnPersonal(R.id.goto_order));
        xCode.setOnClickListener(new MyOnClickedListenerOnPersonal(R.id.goto_x_code));
        strategy.setOnClickListener(new MyOnClickedListenerOnPersonal(R.id.goto_strategy));
        retroaction.setOnClickListener(new MyOnClickedListenerOnPersonal(R.id.goto_retroaction));
        customerService.setOnClickListener(new MyOnClickedListenerOnPersonal(R.id.goto_customer_service));
    }

    public class MyOnClickedListenerOnPersonal implements View.OnClickListener{

        private  int id=0;

        public MyOnClickedListenerOnPersonal(int i){
            this.id=i;
        }

        @Override
        public void onClick(View v) {
            switch (id){
                case R.id.goto_dou:
                    Intent intent1=new Intent(getContext(), DouPersonalActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.goto_order:
                    Intent intent2=new Intent(getContext(), OrderPersoanlActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.goto_x_code:
                    Intent intent3=new Intent(getContext(), XcodePersonalActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.goto_strategy:
                    Intent intent4=new Intent(getContext(), StrategyPersonalActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.goto_retroaction:
                    Intent intent5=new Intent(getContext(), RetroactionPersonalActivity.class);
                    startActivity(intent5);
                    break;
                case R.id.goto_customer_service:
                    Intent intent6=new Intent(getContext(), CustomerServicePersonalActivity.class);
                    startActivity(intent6);
                    break;
                default:
                    break;
            }
        }
    }

}
