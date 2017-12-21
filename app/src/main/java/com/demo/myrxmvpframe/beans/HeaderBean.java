package com.demo.myrxmvpframe.beans;

/**
 * 作者：zzr
 * 创建日期：2017/9/5
 * 描述：头信息类
 */

public class HeaderBean {

    /**
     * deviceName : 10
     * deviceNo : 2
     * deviceModel : phone
     * ip : 127.0.0.1
     * deviceMfrs : android
     * clientVersion : 4.1.1
     * longitude : 111.111
     * latitude : 222.222
     */

    private String deviceName;
    private String deviceNo;
    private String deviceModel;
    private String ip;
    private String deviceMfrs;
    private String clientVersion;
    private String longitude="";
    private String latitude="";
    private String imsi;
    private String imei;
    private String mac;
    private String osVer="";
    private String electricQuantity="";

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDeviceMfrs() {
        return deviceMfrs;
    }

    public void setDeviceMfrs(String deviceMfrs) {
        this.deviceMfrs = deviceMfrs;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getOsVer() {
        return osVer;
    }

    public void setOsVer(String osVer) {
        this.osVer = osVer;
    }

    public String getElectricQuantity() {
        return electricQuantity;
    }

    public void setElectricQuantity(String electricQuantity) {
        this.electricQuantity = electricQuantity;
    }
}
