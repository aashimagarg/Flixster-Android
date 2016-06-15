package com.example.aashimagarg.flixter;

import java.util.ArrayList;

/**
 * Created by aashimagarg on 6/15/16.
 */
public class Movie {

    public String title;
    public String posterUrl;
    public int rating;

    //CMD+N shortcut to generate constructor
    public Movie(String title, String posterUrl, int rating) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.rating = rating;
    }

    public static ArrayList<Movie> getFakeMovies(){
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i < 60; i++) {
            movies.add(new Movie("The Social Network", "", 75));
            movies.add(new Movie("The Internship", "", 50));
            movies.add(new Movie("The Lion King", "", 100));
        }
        return movies;

    }

    @Override
    public String toString() {
        return title + " - " + rating;
    }

}
