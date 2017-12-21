package com.demo.myrxmvpframe.net;


import com.demo.myrxmvpframe.beans.ApiResult;
import com.demo.myrxmvpframe.beans.HomeInfoBean;
import com.demo.myrxmvpframe.beans.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/10/25.
 */

public interface ApiService {

    /*// 登录(已测)
    @FormUrlEncoded
    @POST("api.do?method=login&type=post")
    Call<ApiResult<LoginBean>> login(@Field("userName") String userName,
                                     @Field("loginType") String loginType,
                                     @Field("loginPwd") String loginPwd,
                                     @Field("smsCode") String smsCode,
                                     @Field("verifyCode") String verifyCode,
                                     @Field("referrerUserId") String referrerUserId,
                                     @Field("registrationId") String registrationId,
                                     @Field("header") String header);*/

    // 登录(已测)
    @FormUrlEncoded
    @POST("api.do?method=login&type=post")
    Observable<ApiResult<LoginBean>> login(@Field("userName") String userName,
                                           @Field("loginType") String loginType,
                                           @Field("loginPwd") String loginPwd,
                                           @Field("smsCode") String smsCode,
                                           @Field("verifyCode") String verifyCode,
                                           @Field("referrerUserId") String referrerUserId,
                                           @Field("registrationId") String registrationId,
                                           @Field("header") String header);

    // 获取首页借款信息(已测)
    @FormUrlEncoded
    @POST("api.do?method=getHomeProduct&type=post")
    Observable<ApiResult<HomeInfoBean>> getHomeProduct(@Field("userId") String userId);
}
