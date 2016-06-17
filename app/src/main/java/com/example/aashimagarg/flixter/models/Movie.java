package com.example.aashimagarg.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by aashimagarg on 6/15/16.
 */
public class Movie {

    public String title;
    public String posterUrl;
    public String overview;
    public String backdrop;
    public int rating;

    //CMD+N shortcut to generate constructor
    public Movie(JSONObject jsonObject) throws JSONException {
        this.title = jsonObject.getString("original_title");
        this.posterUrl = jsonObject.getString("poster_path");
        this.overview = jsonObject.getString("overview");
        this.backdrop = jsonObject.getString("backdrop_path");
        this.rating = jsonObject.getInt("vote_average");
    }


    public static ArrayList<Movie> fromJSONArray(JSONArray array) throws JSONException {
        ArrayList<Movie> results = new ArrayList<>();

        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return results;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterUrl() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterUrl);
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdrop() {
        return String.format("http://image.tmdb.org/t/p/w780/%s", backdrop);
    }

    public int getRating() {
        return rating;
    }

}
