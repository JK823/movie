package com.bw.movie.bean.yyBean;

import java.io.Serializable;
import java.util.ArrayList;

public class DateListBean implements Serializable {
    private String status;
    private String message;
    private ArrayList<String> result;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<String> getResult() {
        return result;
    }
}
