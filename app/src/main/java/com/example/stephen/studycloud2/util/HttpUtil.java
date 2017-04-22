package com.example.stephen.studycloud2.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by stephen on 17-4-16.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
