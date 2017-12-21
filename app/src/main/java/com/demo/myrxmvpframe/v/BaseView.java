package com.demo.myrxmvpframe.v;

/**
 * Created by Administrator on 2017/10/26.
 */

public interface BaseView {

    void showMsg(String msg);

    void initLoading();

    void showLoading();

    void dissmissLoading();

    void updateLoading();

}
