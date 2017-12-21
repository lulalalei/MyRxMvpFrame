package com.demo.myrxmvpframe.beans;

/**
 * 作者：zzr
 * 创建日期：2017/9/8
 * 描述：首页基本信息bean
 */

public class HomeInfoBean {
    /**
     * maxDailyRate : 9
     * maxDuration :
     * maxDurationDay : 14
     * maxDurationType : 1
     * status : -30
     * totalAmount : 4000
     */

    private String maxDailyRate;
    private String maxDuration;
    private String maxDurationDay;
    private int maxDurationType;
    private int status;
    private String totalAmount;

    public String getMaxDailyRate() {
        return maxDailyRate;
    }

    public void setMaxDailyRate(String maxDailyRate) {
        this.maxDailyRate = maxDailyRate;
    }

    public String getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(String maxDuration) {
        this.maxDuration = maxDuration;
    }

    public String getMaxDurationDay() {
        return maxDurationDay;
    }

    public void setMaxDurationDay(String maxDurationDay) {
        this.maxDurationDay = maxDurationDay;
    }

    public int getMaxDurationType() {
        return maxDurationType;
    }

    public void setMaxDurationType(int maxDurationType) {
        this.maxDurationType = maxDurationType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
