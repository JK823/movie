package com.bw.movie.bean.myBean;

/**
 * date:2020/4/18
 * author:王成虎(13671)
 * time:15:14
 * day:18
 * month:四月
 * function:注册
 */
public class RegionBean {

    private String status;
    private String message;
    private String email;
    private String pwd;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
