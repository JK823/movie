package com.bw.movie.seatselection.bean;

import java.util.List;

public class SeatInfoBean {
    private String status;
    private String message;
    private List<Result> result;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<Result> getResult() {
        return result;
    }

    public class Result{
        private int row;
        private int seat;
        private int status;

        public int getRow() {
            return row;
        }

        public int getSeat() {
            return seat;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }
    }
}
