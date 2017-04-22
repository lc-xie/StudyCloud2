package com.example.stephen.studycloud2.activity.study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stephen.studycloud2.R;

import org.w3c.dom.Text;

public class StrategyShowActivity extends AppCompatActivity {

    private TextView topTitle;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_show);
        init();

        Intent intent=getIntent();
        String data=intent.getStringExtra("mark");
        Log.d("StrategyShowActivity",data);
    }

    public void init(){
        topTitle=(TextView)findViewById(R.id.tiitle_top1);
        topTitle.setText("校内攻略");
        back=(ImageView)findViewById(R.id.back_material_top);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
