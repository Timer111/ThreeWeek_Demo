package com.dell.threeweek_demo.api;

import com.dell.threeweek_demo.bean.MyBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by DELL on 2017/11/18.
 */

public interface ApiService {
    @GET("iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=vedio")
    Observable<MyBean> getData();
}
