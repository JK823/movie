package com.bw.movie.seatselection.bean;

import java.io.Serializable;
import java.util.List;

public class CinemaScheduleListBean implements Serializable {
    private String message;
    private String cinemaId;
    private String status;
    private List<Result> result;

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public List<Result> getResult() {
        return result;
    }

    public class Result implements Serializable{
        private int movieId;
        private String name;
        private String director;
        private String imageUrl;
        private double score;
        private String starring;
        private String trailerUrl;

        public String getTrailerUrl() {
            return trailerUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public String getName() {
            return name;
        }

        public String getDirector() {
            return director;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public double getScore() {
            return score;
        }

        public String getStarring() {
            return starring;
        }
    }
}
