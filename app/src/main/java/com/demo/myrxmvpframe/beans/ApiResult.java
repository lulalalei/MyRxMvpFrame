package com.demo.myrxmvpframe.beans;


/**
 * 作者：ZhangZhanRui
 * 创建日期：2017/8/28
 * 描述：网络请求结果bean类
 */

public class ApiResult<T> {
    private String respCode;            //返回的code字段
    private String respMsg;             //返回的提示信息
    private T output;

    public T getOutput() {
        return output;
    }

    public void setOutput(T output) {
        this.output = output;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
}
