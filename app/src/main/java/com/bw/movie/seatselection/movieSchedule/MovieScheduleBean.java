package com.bw.movie.seatselection.movieSchedule;

import java.util.List;

public class MovieScheduleBean {
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
        private int id;
        private int hallId;
        private String screeningHall;
        private String beginTime;
        private String endTime;
        private double fare;

        public int getId() {
            return id;
        }

        public int getHallId() {
            return hallId;
        }

        public String getScreeningHall() {
            return screeningHall;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public double getFare() {
            return fare;
        }
    }
}
