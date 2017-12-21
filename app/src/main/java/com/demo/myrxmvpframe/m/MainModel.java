package com.demo.myrxmvpframe.m;


import com.demo.myrxmvpframe.activities.MainActivity;
import com.demo.myrxmvpframe.beans.ApiResult;
import com.demo.myrxmvpframe.beans.LoginBean;
import com.demo.myrxmvpframe.net.ApiService;
import com.demo.myrxmvpframe.net.DefaultObserver;
import com.demo.myrxmvpframe.net.RequestNetHelper;
import com.demo.myrxmvpframe.v.MainContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/10/26.
 */

public class MainModel implements MainContract.Model{

    private ApiService service;

    public MainModel() {
        service= RequestNetHelper.getService();
    }

    @Override
    public void login(MainActivity activity, String mobile, String pwd, String header, DefaultObserver defaultObserver) {
        service.login(mobile, "1", pwd,
                "", "", "", "", header)
                .compose(activity.<ApiResult<LoginBean>>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(defaultObserver);

    }

}
