package com.example.stephen.studycloud2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stephen.studycloud2.R;
import com.example.stephen.studycloud2.activity.study.StrategyShowActivity;
import com.example.stephen.studycloud2.bean.Strategy;

import java.util.List;

/**
 * Created by stephen on 17-4-16.
 */

public class StudyStrategyAdapter extends ArrayAdapter<Strategy> {
    private int resourceId;

    public StudyStrategyAdapter(Context context,int textResourceId,List objects){
        super(context,textResourceId,objects);
        resourceId=textResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Strategy strategy=getItem(position);

        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        LinearLayout linearReadTimes=(LinearLayout)view.findViewById(R.id.linear_read_times_strategy);
        LinearLayout linraeMore=(LinearLayout)view.findViewById(R.id.linear_see_detail_strategy);
        final TextView title=(TextView)view.findViewById(R.id.study_strategy_title);
        TextView readTimes=(TextView)view.findViewById(R.id.study_strategy_read_times);

        title.setText(strategy.getTitle());
        readTimes.setText(String.valueOf(strategy.getReadtimes()));

        linraeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=title.toString();
                Intent intent=new Intent(getContext(),StrategyShowActivity.class);
                intent.putExtra("mark",data);
                getContext().startActivity(intent);
            }
        });

        return view;
    }
}
