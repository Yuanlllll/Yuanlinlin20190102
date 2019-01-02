package com.example.dell.yuanlinlin20190102.model;

import com.example.dell.yuanlinlin20190102.OKHttp3.OkHttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ListModel implements IModel {
    ModelList modelList;

    public ListModel(ModelList modelList) {
        this.modelList = modelList;
    }

    //网络请求数据
    @Override
    public void getMdata(String url)
    {
        OkHttp.okget(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                modelList.getFail();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                modelList.getSuccess(response.body().string());

            }
        });


    }
    public interface ModelList
    {
        void getSuccess(String data);
        void getFail();
    }
}
