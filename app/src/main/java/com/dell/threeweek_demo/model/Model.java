package com.dell.threeweek_demo.model;

import com.dell.threeweek_demo.api.API;
import com.dell.threeweek_demo.api.ApiService;
import com.dell.threeweek_demo.bean.MyBean;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2017/11/18.
 */

public class Model implements Imodel {

    OnFinished onFinished;

    public  interface OnFinished{
        void onFinishListener(List<MyBean.DataBean> list);
    }

    public void setOnFinished(OnFinished onFinished) {
        this.onFinished = onFinished;
    }

    @Override
    public void RequestScuuess(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Observable<MyBean> bean = apiService.getData();
        bean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        List<MyBean.DataBean> list = myBean.getData();
                        onFinished.onFinishListener(list);
                    }
                });

    }
}
