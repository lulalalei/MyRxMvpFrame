package com.demo.myrxmvpframe.beans;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.demo.myrxmvpframe.bases.MyApplication;
import com.demo.myrxmvpframe.utils.SystemUtils;


/**
 * 作者：zzr
 * 创建日期：2017/9/6
 * 描述：获取头信息的帮助类
 */

public class HeaderHelper {

    public static String getHeaderInfo() {
        MyApplication.mHeaderBean.setDeviceName("10");
        if (TextUtils.isEmpty(MyApplication.mHeaderBean.getDeviceNo())) {
            MyApplication.mHeaderBean.setDeviceNo(SystemUtils.getUUId());
        }
        String headerStr = JSON.toJSONString(MyApplication.mHeaderBean);
        return headerStr;
    }
}
