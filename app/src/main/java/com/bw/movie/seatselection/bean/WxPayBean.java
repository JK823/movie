package com.bw.movie.seatselection.bean;

import java.io.Serializable;

public class WxPayBean implements Serializable {
    private String status;
    private String message;
    private String orderId;
    private String imageUrl;
    private String prepayId;
    private String partnerId;
    private String nonceStr;
    private String timeStamp;
    private String sign;
    private String appId;
    private String packageValue;

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getSign() {
        return sign;
    }

    public String getAppId() {
        return appId;
    }

    public String getPackageValue() {
        return packageValue;
    }
}
