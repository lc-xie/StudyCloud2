package com.example.stephen.studycloud2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.stephen.studycloud2.R;
import com.example.stephen.studycloud2.bean.Strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stephen on 17-4-17.
 */

public class StudyStrategySimpleAdapter extends SimpleAdapter {

    private Strategy strategy=new Strategy();
    int resource;
    Context context;

   public StudyStrategySimpleAdapter(Context context,List<HashMap<String,Object>>list,int resource,
                                     String[] from,int[] to){
       super(context,list,resource,from,to);
       this.resource=resource;
       this.context=context;
   }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=LayoutInflater.from(context).inflate(R.layout.list_item_study_strategy,parent,false);
        TextView title=(TextView)view.findViewById(R.id.study_strategy_title);
        TextView readTimes=(TextView)view.findViewById(R.id.study_strategy_read_times);

        title.setText(strategy.getTitle());
        readTimes.setText(String.valueOf(strategy.getReadtimes()));
        return view;
    }
}
