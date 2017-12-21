package com.demo.myrxmvpframe.beans;

/**
 * 作者：zzr
 * 创建日期：2017/9/7
 * 描述：登录或注册成功返回的bean
 */

public class LoginBean {

    /**
     * domainId :
     * sessionId : 609fc750033fad7b15289d140118e0d7
     */

    private String mobile;
    private String userId;
    private String sessionId;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
