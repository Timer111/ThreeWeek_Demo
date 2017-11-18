package com.dell.threeweek_demo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dell.threeweek_demo.R;
import com.dell.threeweek_demo.activity.SecondActivity;
import com.dell.threeweek_demo.bean.MyBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2017/11/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener{

    private List<MyBean.DataBean> list = new ArrayList<>();
    private Context context;
    private OnItemClickListener mOnItemClickListener = null;

    public MyAdapter(List<MyBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.second_item,parent,false);
        view.setOnClickListener(this);
        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.cont.setText(list.get(position).getContent());
//        Uri uri =Uri.parse(list.get(position).getImage_url());
        holder.img.setImageURI(list.get(position).getImage_url());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView cont;
        private final SimpleDraweeView img;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            cont = itemView.findViewById(R.id.item_cont);
            img = itemView.findViewById(R.id.item_img);
        }
    }
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
