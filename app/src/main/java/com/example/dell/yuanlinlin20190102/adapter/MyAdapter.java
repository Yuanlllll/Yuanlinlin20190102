package com.example.dell.yuanlinlin20190102.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.yuanlinlin20190102.R;
import com.example.dell.yuanlinlin20190102.bean.HomeBean;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private HomeBean homeBean;

    public MyAdapter(Context context, HomeBean homeBean) {
        this.context = context;
        this.homeBean = homeBean;
    }

    @Override
    public int getCount() {
        return homeBean.getData().getMiaosha().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return homeBean.getData().getMiaosha().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if (convertView==null)
        {
            convertView=View.inflate(context, R.layout.ss_layout,null);
            holder=new ViewHolder();
            holder.img=convertView.findViewById(R.id.img);
            //holder.text_price=convertView.findViewById(R.id.text_price);
            holder.text_title=convertView.findViewById(R.id.text_title);
            convertView.setTag(holder);

        }
        else
        {
           holder= (ViewHolder) convertView.getTag();
        }
        holder.text_title.setText(homeBean.getData().getMiaosha().getList().get(0).getSubhead());
        //holder.text_price.setText(homeBean.getData().getMiaosha().getList().get(0).getPrice()+"");
        ImageLoader.getInstance().displayImage(homeBean.getData().getMiaosha().getList().get(0).getImages(),holder.img);
        return convertView;
    }
    class ViewHolder
    {
        private ImageView img;
        private TextView text_title,text_price;
    }
}
