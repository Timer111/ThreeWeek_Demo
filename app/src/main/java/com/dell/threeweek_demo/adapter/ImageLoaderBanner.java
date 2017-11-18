package com.dell.threeweek_demo.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by DELL on 2017/10/12.
 */

public class ImageLoaderBanner extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Glide.with(context).load((String)path).into(imageView);
    }
}
