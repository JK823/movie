package com.bw.movie.seatselection.bean;

import java.util.List;

public class Result {
    private int movieId;
    private String name;
    private String imageUrl;
    private String movieType;
    private String placeOrigin;
    private String duration;
    private String summary;
    private int whetherFollow;
    private double score;
    private long releaseTime;
    private int commentNum;
    private List<ShortFilmList> shortFilmList;
    private List<String> posterList;
    private List<MovieDirector> movieDirector;
    private List<MovieActor> movieActor;

    public int getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getMovieType() {
        return movieType;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public String getDuration() {
        return duration;
    }

    public String getSummary() {
        return summary;
    }

    public int getWhetherFollow() {
        return whetherFollow;
    }

    public double getScore() {
        return score;
    }

    public long getReleaseTime() {
        return releaseTime;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public List<MovieDirector> getMovieDirector() {
        return movieDirector;
    }

    public List<MovieActor> getMovieActor() {
        return movieActor;
    }

    public List<ShortFilmList> getShortFilmList() {
        return shortFilmList;
    }

    public List<String> getPosterList() {
        return posterList;
    }
}
