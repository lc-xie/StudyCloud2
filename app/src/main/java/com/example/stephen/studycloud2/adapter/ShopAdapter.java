package com.example.stephen.studycloud2.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stephen.studycloud2.R;
import com.example.stephen.studycloud2.activity.study.StrategyShowActivity;
import com.example.stephen.studycloud2.bean.ExamPaper;
import com.example.stephen.studycloud2.fragment.ShopFragment;

import java.util.List;

/**
 * Created by stephen on 17-5-17.
 */

public class ShopAdapter extends ArrayAdapter<ExamPaper> {
    private int resourceId;
    private int ammount=0;
    boolean ifSelected=false;

    public ShopAdapter(Context context, int textResourceId, List objects){
        super(context,textResourceId,objects);
        resourceId=textResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ExamPaper examPaper=getItem(position);

        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        TextView title=(TextView)view.findViewById(R.id.title_paper);
        TextView price=(TextView)view.findViewById(R.id.price_paper);
        final TextView ammountofPaper=(TextView)view.findViewById(R.id.ammount_paper);
        final ImageView ifSelectedPaper=(ImageView)view.findViewById(R.id.exam_paper_select);
        ImageView subjectofPaper=(ImageView)view.findViewById(R.id.subject_paper);
        ImageView decreasePaper=(ImageView)view.findViewById(R.id.decrease_paper);
        ImageView addPaper=(ImageView)view.findViewById(R.id.add_paper);
        title.setText(examPaper.getTitle());
        price.setText(String.valueOf(examPaper.getPrice()));
        ifSelectedPaper.setImageResource(R.drawable.not_selected_paper);
        ammountofPaper.setText("0");


        ifSelectedPaper.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                if(ifSelected==false){
                    ifSelectedPaper.setImageResource(R.drawable.selected_paper);
                    ifSelected=true;
                }else {
                    ifSelectedPaper.setImageResource(R.drawable.not_selected_paper);
                    ifSelected=false;
                }
           }
       });

        decreasePaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ammount=ammount-1;
                ammountofPaper.setText(String.valueOf(ammount));
                Log.d("shopAdapter:","decrease,ammount="+ammount);
            }
        });

        addPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ammount=ammount+1;
                ammountofPaper.setText(String.valueOf(ammount));
                Log.d("ShopAdapter:","add,ammount="+ammount);
            }
        });

        return view;
    }
}
