package com.dell.threeweek_demo.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dell.threeweek_demo.R;
import com.dell.threeweek_demo.api.API;
import com.dell.threeweek_demo.bean.MyBean;
import com.dell.threeweek_demo.presenter.Presenter;
import com.dell.threeweek_demo.view.Iview;
import com.dell.threeweek_demo.view.MyCircleView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_color)
    Button btnColor;
    @Bind(R.id.btn_way)
    Button btnWay;
    @Bind(R.id.btn_mod)
    Button btnMod;
    @Bind(R.id.mycircle_view)
    MyCircleView mycircleView;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    private int currentSpeed = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn_color, R.id.btn_way, R.id.btn_mod})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_color:
                mycircleView.setColor(Color.BLUE);
                break;
            case R.id.btn_way:
                mycircleView.speed();
                break;
            case R.id.btn_mod:
                mycircleView.slowDown();
                break;
        }
    }


}
