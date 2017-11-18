package com.dell.threeweek_demo.presenter;

import com.dell.threeweek_demo.bean.MyBean;
import com.dell.threeweek_demo.model.Model;
import com.dell.threeweek_demo.view.Iview;

import java.util.List;

/**
 * Created by DELL on 2017/11/18.
 */

public class Presenter implements Model.OnFinished {

    Iview iview ;
    Model model;

    public Presenter(Iview iview) {
        this.iview = iview;
        model = new Model();
        model.setOnFinished(this);
    }

    public void getUrl(String url){
        model.RequestScuuess(url);
    }
    @Override
    public void onFinishListener(List<MyBean.DataBean> list) {
        iview.showMessage(list);
    }
}
