package com.packt.moviesshowcase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

public class MovieActivity extends Activity {

    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        final Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("movie")) {
            movie = (Movie) extras.getSerializable("movie");
            new MyAsyncTask(movie).execute();
        }
        MovieView movieView = findViewById(R.id.movieview);
        movieView.setName(movie.getName());
        movieView.setPosterResource(movie.getPoster());
    }


    public static void launchMovieActivity(Context context, Movie movie) {
        final Intent intent = new Intent(context, MovieActivity.class);
        intent.putExtra("movie", movie);
        context.startActivity(intent);
    }


    static class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        private Movie movie;

        MyAsyncTask(Movie movie) {
            this.movie = movie;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            saveToDb(movie);
            return null;
        }

        private void saveToDb(Movie movie) {
            //save to db
        }
    }
}
