package com.example.dell.yuanlinlin20190102;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.dell.yuanlinlin20190102.adapter.MyAdapter;
import com.example.dell.yuanlinlin20190102.bean.HomeBean;
import com.example.dell.yuanlinlin20190102.presenter.ListPresenter;
import com.example.dell.yuanlinlin20190102.view.IView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements IView
{

    private GridView grid_view;
    private HomeBean homeBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        grid_view = findViewById(R.id.grid_view);

        //初始化presenter
        ListPresenter listPresenter = new ListPresenter(this);
        listPresenter.getPdata();

    }

    @Override
    public void getVdata(String data)
    {
        Gson gson=new Gson();
        homeBean = gson.fromJson(data, HomeBean.class);
        new Thread()
        {
            @Override
            public void run() {
                super.run();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //创建设置适配器
                        MyAdapter adapter=new MyAdapter(MainActivity.this,homeBean);
                        grid_view.setAdapter(adapter);

                    }
                });
            }
        }.start();




    }
}
