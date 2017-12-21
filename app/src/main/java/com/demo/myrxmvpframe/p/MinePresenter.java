package com.demo.myrxmvpframe.p;

import android.app.Activity;

import com.demo.myrxmvpframe.beans.ApiResult;
import com.demo.myrxmvpframe.beans.LoginBean;
import com.demo.myrxmvpframe.fragments.MineFragment;
import com.demo.myrxmvpframe.net.DefaultObserver;
import com.demo.myrxmvpframe.v.MineContract;


/**
 * Created by Administrator on 2017/10/27.
 */

public class MinePresenter extends MineContract.Presenter{

    @Override
    public void login(Activity context, MineFragment fragment, String mobile, String pwd, String header) {
        mModel.login(context,fragment,mobile,pwd,header,
                new DefaultObserver<MineContract.View,ApiResult<LoginBean>>(context,mView) {

            @Override
            public void onSuccess(ApiResult<LoginBean> response) {
                LoginBean loginBean = response.getOutput();
                mView.updateUserInfo(loginBean);
                mView.showMsg("我登录成功啦");
            }

        });
    }

    @Override
    public void onAttached() {

    }
}
