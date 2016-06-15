package com.example.aashimagarg.flixter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        //1. Get the actual movies
        ArrayList<Movie> movies = Movie.getFakeMovies();

        //2. Get the ListView to populate
        //findViewById returns View - so, cast to ListView
        ListView lvMovies = (ListView) findViewById(R.id.lvMovies);

        //3. Create an ArrayAdapter
        //ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movies);
        MoviesAdapter adapter = new MoviesAdapter(this, movies);

        //4. Associate the array adapter with the ListView
        if (lvMovies != null) {
            lvMovies.setAdapter(adapter);
        }
        
    }

}
