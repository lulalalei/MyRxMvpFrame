package com.demo.myrxmvpframe.net;

/**
 * Created by Administrator on 2017/10/25.
 */

public class RequestNetHelper {

    public static ApiService getService()
    {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        return service;
    }
}
