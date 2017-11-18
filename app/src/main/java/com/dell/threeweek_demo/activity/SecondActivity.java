package com.dell.threeweek_demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.dell.threeweek_demo.R;
import com.dell.threeweek_demo.adapter.ImageLoaderBanner;
import com.dell.threeweek_demo.adapter.MyAdapter;
import com.dell.threeweek_demo.api.API;
import com.dell.threeweek_demo.bean.MyBean;
import com.dell.threeweek_demo.presenter.Presenter;
import com.dell.threeweek_demo.view.Iview;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by DELL on 2017/11/18.
 */

public class SecondActivity extends AppCompatActivity implements Iview {
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<String> imgs = new ArrayList<>();
    private Banner banner;
    private List<MyBean.DataBean> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_main);
        ButterKnife.bind(this);
        banner = (Banner) findViewById(R.id.ban_ner);
        Presenter p = new Presenter(this);
        p.getUrl(API.URL);
        //轮播图
        showBanner();

    }

    @Override
    public void showMessage(final List<MyBean.DataBean> list) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        for (int i=0;i<list.size();i++){
            imgs.add(list.get(i).getImage_url());
        }
        banner.setImages(imgs);
        banner.start();
        MyAdapter adapter = new MyAdapter(list, SecondActivity.this);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String s = list.get(position).getVedio_url();
                Intent intent = new Intent(SecondActivity.this,PlayActivity.class);
                intent.putExtra("url",s);
                startActivity(intent);
            }
        });
    }

    //Banner
    private void showBanner() {
        //轮播图
        banner.setImageLoader(new ImageLoaderBanner());
//        imgs = new ArrayList<>();
//        imgs.add("http://pic77.nipic.com/file/20150911/21721561_155058651000_2.jpg");
//        imgs.add("http://pic32.nipic.com/20130817/9745430_101836881000_2.jpg");
//        imgs.add("http://pic15.nipic.com/20110630/6322714_105943746342_2.jpg");
//        imgs.add("http://pic48.nipic.com/file/20140916/2531170_195153248000_2.jpg");
//        imgs.add("http://img.taopic.com/uploads/allimg/140626/240469-1406261S24553.jpg");
//        banner.setImages(imgs);
//        banner.start();
    }
}
