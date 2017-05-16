package com.example.stephen.studycloud2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.stephen.studycloud2.R;
import com.example.stephen.studycloud2.adapter.StudyStrategyAdapter;
import com.example.stephen.studycloud2.bean.ExamPaper;
import com.example.stephen.studycloud2.bean.Strategy;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephen on 17-4-7.
 */

public class ShopFragment extends Fragment {
    View view;
    private List<ExamPaper> paperList=new ArrayList<>();
    private ListView listView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_shop,container,false);

        sendRequestWithOkHttp();

        return view;
    }

    private void sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection =null;
                BufferedReader reader=null;
                try{
                    URL url=new URL("http://10.0.2.2/examPaper.json");
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
                String title=jsonObject.optString("title");
                int price=jsonObject.optInt("price");
                String subject=jsonObject.getString("subject");

                ExamPaper examPaper=new ExamPaper();
                examPaper.setTitle(title);
                examPaper.setPrice(price);
                examPaper.setSubject(subject);


                paperList.add(examPaper);

                Log.d("StudyPager2","name : "+examPaper.getTitle());
                Log.d("StudyPager2","read times : "+String.valueOf(examPaper.getPrice()));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
