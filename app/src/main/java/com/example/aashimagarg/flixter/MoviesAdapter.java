package com.example.aashimagarg.flixter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by aashimagarg on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.item_movie, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movie = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        // Handles recycling of cells
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
        }

        // Lookup view for data population
        ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);

        // Populate the data into the template view using the data object
        tvTitle.setText(movie.title);

        String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
        Picasso.with(getContext()).load(imageUri).into(ivPoster);

        //debugging - will print number of positions that fit on screen at given point in time
        Log.d("MoviesAdapter", "Position: " + position);

        // Return the completed view to render on screen
        return convertView;
    }
}
