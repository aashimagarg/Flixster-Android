package com.example.aashimagarg.flixter;

import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    TextView tvTitle;
    TextView tvOverview;
    ImageView ivBackdrop;
    ImageView ivRating;
    TextView tvRating;
    TextView tvDate;


    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //custom action bar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_title);

        // Get access to our TextView
        TextView txt = (TextView) findViewById(R.id.myTitle);
        // Create the TypeFace from the TTF asset
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        // Assign the typeface to the view
        txt.setTypeface(font);

        //instantiate
        tvTitle = (TextView) findViewById(R.id.tvTitle2);
        String title = getIntent().getStringExtra("title");
        tvTitle.setText(title);

        tvOverview = (TextView) findViewById(R.id.tvOverview2);
        String overview = getIntent().getStringExtra("overview");
        tvOverview.setText(overview);

        ivBackdrop = (ImageView) findViewById(R.id.ivBackdrop2);
        String backdropUrl = getIntent().getStringExtra("poster");
        Picasso.with(this).load(backdropUrl).into(ivBackdrop);

        tvRating = (TextView) findViewById(R.id.tvDate2);
        double rating = getIntent().getDoubleExtra("rating", 0);
        tvRating.setText(((int) (rating * 10)) + "%");

        tvDate = (TextView) findViewById(R.id.tvRating2);
        String date = getIntent().getStringExtra("date");
        String month = date.substring(5, 7);
        String day = date.substring(8);
        String year = date.substring(0, 4);
        tvDate.setText(month + "/" + day + "/" + year);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Details Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.aashimagarg.flixter/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Details Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.aashimagarg.flixter/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
