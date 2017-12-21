package com.demo.myrxmvpframe.m;

import android.app.Activity;

import com.demo.myrxmvpframe.beans.ApiResult;
import com.demo.myrxmvpframe.beans.LoginBean;
import com.demo.myrxmvpframe.fragments.MineFragment;
import com.demo.myrxmvpframe.net.ApiService;
import com.demo.myrxmvpframe.net.DefaultObserver;
import com.demo.myrxmvpframe.net.RequestNetHelper;
import com.demo.myrxmvpframe.v.MineContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/10/27.
 */

public class MineModel implements MineContract.Model{

    private ApiService service;

    public MineModel() {
        service= RequestNetHelper.getService();
    }

    @Override
    public void login(Activity context, MineFragment fragment, String mobile, String pwd, String header, DefaultObserver defaultObserver) {
        service.login(mobile, "1", pwd,
                "", "", "", "", header)
                .compose(fragment.<ApiResult<LoginBean>>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(defaultObserver);
    }
}
