package com.packt.moviesshowcase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MovieActivity extends Activity {

    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        final Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("movie")) {
            movie = (Movie) extras.getSerializable("movie");
            new MyAsyncTask().execute(movie, movie, movie);
        }
        MovieView movieView = findViewById(R.id.movieview);
        movieView.setName(movie.getName());

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_foreground);

        Glide
            .with(this)
            .setDefaultRequestOptions(requestOptions)
            .load(movie.getPoster())
            .into(movieView.getPosterView());
//        movieView.setPosterResource(movie.getPoster());


//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //do something in the background
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        //do this on UI thread
//                    }
//                });
//            }
//        });
//        thread.start();
    }


    public static void launchMovieActivity(Context context, Movie movie) {
        final Intent intent = new Intent(context, MovieActivity.class);
        intent.putExtra("movie", movie);
        context.startActivity(intent);
    }


    static class MyAsyncTask extends AsyncTask<Movie, Integer, Boolean> {

//        private Movie movie;
//
//        MyAsyncTask(Movie movie) {
//            this.movie = movie;
//        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected Boolean doInBackground(Movie... movies) {
            if (movies.length > 0) {
                for (int i = 0; i < movies.length; i++) {
                    publishProgress(i);
                    saveToDb(movies[i]);
                }
            }
//            saveToDb(movies[0]);
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            super.onPostExecute(aVoid);
            //update the progress bar
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
        }

        private void saveToDb(Movie movie) {
            //save to db
        }
    }
}
