package com.bw.movie.seatselection.bean;

import java.io.Serializable;

public class BuyMovieTicketsBean implements Serializable {
    private String message;
    private String status;
    private String orderId;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }
}
