package com.example.aashimagarg.flixter.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aashimagarg.flixter.R;
import com.example.aashimagarg.flixter.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by aashimagarg on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
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
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
        ivPoster.setImageResource(0);

        // Populate the data into the template view using the data object
        tvTitle.setText(movie.title);
        tvOverview.setText(movie.overview);
        String urlposter = movie.getPosterUrl();
        String urlbackdrop = movie.getBackdrop();

        if(getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Picasso.with(getContext()).load(urlposter).into(ivPoster);
        }
        if(getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Picasso.with(getContext()).load(urlbackdrop).into(ivPoster);
        }

            //debugging - will print number of positions that fit on screen at given point in time
        Log.d("MoviesAdapter", "Position: " + position);

        // Return the completed view to render on screen
        return convertView;
    }

}
