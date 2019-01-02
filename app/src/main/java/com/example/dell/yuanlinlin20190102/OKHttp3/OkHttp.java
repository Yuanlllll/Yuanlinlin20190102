package com.example.dell.yuanlinlin20190102.OKHttp3;

import android.telecom.Call;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttp
{
    public static void okget(String url, Callback call)
    {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).method("GET", null).build();
        httpClient.newCall(request).enqueue(call);

    }

}
