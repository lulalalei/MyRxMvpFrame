package com.demo.myrxmvpframe.bases;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import com.demo.myrxmvpframe.beans.HeaderBean;


/**
 * 作者：ZhangZhanRui
 * 创建日期：2017/8/28
 * 描述：application 类
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    public static Context context;
    public static HeaderBean mHeaderBean;

    public static MyApplication getInstance() {
        return instance;
    }

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();

        if (mHeaderBean == null) {
            mHeaderBean = new HeaderBean();
        }
        /**
         * 解决Android7.0 FileUriExposedException问题
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }

        /*Logger.init(CommonConstants.MY_LOGGER_TAG)
                .logLevel(LogLevel.NONE);           //上线后关闭log,改为NULL*/

//        JPushInterface.setDebugMode(false);    // 设置开启日志,发布时请关闭日志
//        JPushInterface.init(this);            // 初始化 JPush
    }
}
