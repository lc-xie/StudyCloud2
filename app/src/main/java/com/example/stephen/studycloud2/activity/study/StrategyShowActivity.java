package com.example.stephen.studycloud2.activity.study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stephen.studycloud2.R;
import com.example.stephen.studycloud2.bean.Strategy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StrategyShowActivity extends AppCompatActivity {

    private TextView topTitle,title,author,time,content,readTimes;
    private ImageView back;
    private String data;
    private Strategy aStrategy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_show);
        init();


        Intent intent=getIntent();
        String data=intent.getStringExtra("mark");

        sendRequestWithOkHttp();

        initStrategy();

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

    public void initStrategy(){
        title=(TextView)findViewById(R.id.strategy_layout_1_title);
        author=(TextView)findViewById(R.id.strategy_layout_2_author);
        time=(TextView)findViewById(R.id.strategy_layout_2_time);
        content=(TextView)findViewById(R.id.strategy_layout_3_content);
        readTimes=(TextView)findViewById(R.id.strategy_layout_2_read_times);

        title.setText(aStrategy.getTitle());
        author.setText("author: "+aStrategy.getAuthor());
        time.setText(aStrategy.getWritedTime().toString());
        readTimes.setText(aStrategy.getReadtimes());
        content.setText(aStrategy.getContent());
    }

    private void sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection =null;
                BufferedReader reader=null;
                try{
                    URL url=new URL("http://guolin.tech/api/china");
                    connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(10000);
                    connection.setReadTimeout(10000);
                    InputStream in =connection.getInputStream();
                    reader=new BufferedReader(new InputStreamReader(in));
                    StringBuilder response=new StringBuilder();
                    String line;
                    while ((line=reader.readLine())!=null){
                        response.append(line);
                    }
                    getStrategy(response.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(reader!=null){
                        try{
                            reader.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    private void getStrategy(String response){
        Gson gson=new Gson();
        List<Strategy>strategyList=new ArrayList<>();
        strategyList=gson.fromJson(response,new TypeToken<List<Strategy>>(){}.getType());
        for(Strategy strategy:strategyList){
            Log.d("StudyPager2","name:"+strategy.getTitle());
            if (strategy.getTitle()==data){
                aStrategy=strategy;
            }
        }
    }
}
