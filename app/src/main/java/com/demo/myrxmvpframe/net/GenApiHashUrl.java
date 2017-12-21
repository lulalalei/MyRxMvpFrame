package com.demo.myrxmvpframe.net;

/**
 * 作者：ZhangZhanRui
 * 创建日期：2017/8/28
 * 描述：网络请求
 */

public class GenApiHashUrl {
    private static GenApiHashUrl INSTANCE = null;
    //public static final String apiUrl = "http://10.1.16.111:8088/kxd-api-server/";//内网测试环境
    public static final String apiUrl = "http://10.1.11.43:8080/api/";//徐徐测试环境
//    public static final String apiUrl = "http://10.1.16.126:8080/";//小乔测试环境
    //public static final String apiUrl = "https://hxj.51kaledai.com/api/";//线上

    public static final String md5_key = "abcdefgopsdsxcvxcvxcvxcvaxwerwe";

    public static GenApiHashUrl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GenApiHashUrl();
        }
        return INSTANCE;
    }

    private GenApiHashUrl() {
    }
}
