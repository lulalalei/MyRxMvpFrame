package com.demo.myrxmvpframe.m;

import android.app.Activity;

import com.demo.myrxmvpframe.beans.ApiResult;
import com.demo.myrxmvpframe.beans.HomeInfoBean;
import com.demo.myrxmvpframe.fragments.HomeFragment;
import com.demo.myrxmvpframe.net.ApiService;
import com.demo.myrxmvpframe.net.DefaultObserver;
import com.demo.myrxmvpframe.net.RequestNetHelper;
import com.demo.myrxmvpframe.v.HomeContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/10/27.
 */

public class HomeModel implements HomeContract.Model{

    private ApiService service;

    public HomeModel() {
        service= RequestNetHelper.getService();
    }

    @Override
    public void getHomeProduct(Activity activity, HomeFragment fragment, String userId, DefaultObserver defaultObserver) {
        service.getHomeProduct(userId)
                .compose(fragment.<ApiResult<HomeInfoBean>>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(defaultObserver);
    }

}
