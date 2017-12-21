package com.demo.myrxmvpframe.p;


import com.demo.myrxmvpframe.activities.MainActivity;
import com.demo.myrxmvpframe.beans.ApiResult;
import com.demo.myrxmvpframe.beans.LoginBean;
import com.demo.myrxmvpframe.net.DefaultObserver;
import com.demo.myrxmvpframe.v.MainContract;

/**
 * Created by Administrator on 2017/10/26.
 */

public class MainPresenter extends MainContract.Presenter{

    @Override
    public void login(MainActivity activity, String mobile, String pwd, String header) {

        mModel.login(activity,mobile,pwd,header,new DefaultObserver<MainContract.View,ApiResult<LoginBean>>(activity,mView) {

            @Override
            public void onSuccess(ApiResult<LoginBean> response) {
                LoginBean loginBean = response.getOutput();
                mView.showMsg("我登录成功啦");
            }
        });

    }

    @Override
    public void onAttached() {

    }
}
