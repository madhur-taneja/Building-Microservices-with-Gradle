package io.trpspringmicroservices.ratingdataservice.models;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private int userId;
    private String name;
    private Rating[] movieRatings;

    public User() {
    }

    public User(int id, String name, Rating[] movieRatings) {
        userId = id;
        this.name = name;
        this.movieRatings = movieRatings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        userId = id;
    }

    public Rating[] getMovieRatings() {
        return movieRatings;
    }

    public void setMovieRatings(Rating[] movieRatings) {
        this.movieRatings = movieRatings;
    }

}
