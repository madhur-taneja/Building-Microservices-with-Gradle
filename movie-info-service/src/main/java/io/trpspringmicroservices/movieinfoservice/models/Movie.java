package io.trpspringmicroservices.movieinfoservice.models;

public class Movie {

    private String movieID;
    private String name;

    public Movie(String movieID, String name) {
        this.movieID = movieID;
        this.name = name;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
