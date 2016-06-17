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

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by aashimagarg on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    private static class ViewHolder {
        TextView title;
        TextView overview;
        ImageView poster;
        ImageView rated;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movie = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        // Handles recycling of cells
        ViewHolder viewHolder;

        //maximize efficiency of load
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            // Lookup view for data population
            viewHolder.poster = (ImageView) convertView.findViewById(R.id.ivPoster);
            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.overview = (TextView) convertView.findViewById(R.id.tvOverview);
            viewHolder.rated = (ImageView) convertView.findViewById(R.id.ivRated);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //removes image so cells can recycle
        viewHolder.poster.setImageResource(0);

        // Populate the data into the template view using the data object
        viewHolder.title.setText(movie.title);
        viewHolder.overview.setText(movie.overview);
        String urlposter = movie.getPosterUrl();
        String urlbackdrop = movie.getBackdrop();

        //orientation based on image
        if(getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Picasso.with(getContext()).load(urlposter).transform(new RoundedCornersTransformation(10, 10)).into(viewHolder.poster);
        }
        if(getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Picasso.with(getContext()).load(urlbackdrop).transform(new RoundedCornersTransformation(10, 10)).into(viewHolder.poster);
        }

        //check top rated
        if (movie.getRating() > 5){
            viewHolder.rated.setVisibility(View.VISIBLE);
        } else {
            viewHolder.rated.setVisibility(View.INVISIBLE);
        }

        //debugging - will print number of positions that fit on screen at given point in time
        Log.d("MoviesAdapter", "Position: " + position);

        // Return the completed view to render on screen
        return convertView;
    }

}
