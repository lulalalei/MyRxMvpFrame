package com.demo.myrxmvpframe.p;

import android.app.Activity;

import com.demo.myrxmvpframe.beans.ApiResult;
import com.demo.myrxmvpframe.beans.HomeInfoBean;
import com.demo.myrxmvpframe.fragments.HomeFragment;
import com.demo.myrxmvpframe.net.DefaultObserver;
import com.demo.myrxmvpframe.v.HomeContract;


/**
 * Created by Administrator on 2017/10/27.
 */

public class HomePresenter extends HomeContract.Presenter{

    @Override
    public void onAttached() {

    }

    @Override
    public void getHomeProduct(Activity activity, HomeFragment fragment, String userId) {

        mModel.getHomeProduct(activity, fragment, userId, new DefaultObserver<HomeContract.View,ApiResult<HomeInfoBean>>(activity,mView) {
            @Override
            public void onSuccess(ApiResult response) {
                mView.showMsg("获取用户消息成功");
            }

        });
    }
}
