package com.example.stephen.studycloud2.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.stephen.studycloud2.MainActivity;
import com.example.stephen.studycloud2.R;
import com.example.stephen.studycloud2.adapter.StudyStrategyAdapter;
import com.example.stephen.studycloud2.adapter.StudyStrategySimpleAdapter;
import com.example.stephen.studycloud2.bean.Strategy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by stephen on 17-4-8.
 */

public class StudyPager2Fragment extends Fragment {
    View view;
    private List<Strategy>strategyList=new ArrayList<>();
    private StudyStrategyAdapter studyStrategyAdapter;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_study_pager_2,container,false);
        listView=(ListView)view.findViewById(R.id.strategy_saw_study_list_view);

        sendRequestWithOkHttp();//send request;initialize strategyList.

       studyStrategyAdapter=new StudyStrategyAdapter(getContext(),
                R.layout.list_item_study_strategy,strategyList);
        listView=(ListView)view.findViewById(R.id.strategy_saw_study_list_view);
        listView.setAdapter(studyStrategyAdapter);

        return view;
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
                    parseJSONWithJsonObject(response.toString());
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

    private void parseJSONWithJsonObject(String str){
        try{
            JSONArray jsonArray=new JSONArray(str);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String title=jsonObject.optString("name");
                int readTimes=jsonObject.optInt("id");

                Strategy strategy=new Strategy();
                strategy.setTitle(title);
                strategy.setReadtimes(readTimes);
                strategyList.add(strategy);
                Log.d("StudyPager2","name : "+strategy.getTitle());
                Log.d("StudyPager2","read times : "+String.valueOf(strategy.getReadtimes()));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void parseJSONWithGson(String string){
        Gson gson=new Gson();
        strategyList=gson.fromJson(string,new TypeToken<List<Strategy>>(){}.getType());
        for(Strategy strategy:strategyList){
            Log.d("StudyPager2","name:"+strategy.getTitle());
        }
    }
}
