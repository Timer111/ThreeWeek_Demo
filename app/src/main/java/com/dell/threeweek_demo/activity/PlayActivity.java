package com.dell.threeweek_demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.dell.threeweek_demo.R;
import com.dell.threeweek_demo.activity.common.PlayerManager;

/**
 * Created by DELL on 2017/11/18.
 */

public class PlayActivity extends AppCompatActivity implements PlayerManager.PlayerStateListener{

    private String url;
    private PlayerManager player;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.play_main);

        Intent intent  = getIntent();
        url = intent.getStringExtra("url");
        if(url != null){
            initPlayer();
        }
    }

    private void initPlayer() {

        //初始化播放器
        player = new PlayerManager(this);
        player.setFullScreenOnly(true);
        player.setScaleType(PlayerManager.SCALETYPE_FILLPARENT);
        player.playInFullScreen(true);
        player.setPlayerStateListener(this);
        player.play(url);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(player.gestureDetector.onTouchEvent(event)){
            return  true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.stop();
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onPlay() {

    }
}
