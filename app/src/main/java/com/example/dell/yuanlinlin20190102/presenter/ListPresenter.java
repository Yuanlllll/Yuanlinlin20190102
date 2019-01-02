package com.example.dell.yuanlinlin20190102.presenter;

import com.example.dell.yuanlinlin20190102.MainActivity;
import com.example.dell.yuanlinlin20190102.api.Api;
import com.example.dell.yuanlinlin20190102.model.ListModel;

public class ListPresenter implements  IPresenter,ListModel.ModelList
{
    MainActivity mview;
    private final ListModel listModel;

    public ListPresenter(MainActivity mview) {
        this.mview = mview;
        listModel = new ListModel(this);
    }

    @Override
    public void getPdata()
    {
        listModel.getMdata(Api.show);

    }

    @Override
    public void getSuccess(String data) {
        mview.getVdata(data);
    }

    @Override
    public void getFail()
    {
        mview.getVdata("加载失败");

    }
}
