package com.example.dell.yuanlinlin20190102.myapp;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MyApp extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);
    }
}
