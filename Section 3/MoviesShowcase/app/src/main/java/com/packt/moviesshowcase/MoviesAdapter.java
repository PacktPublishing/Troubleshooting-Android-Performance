package com.packt.moviesshowcase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private Context context;
    private List<Movie> movies;

    public MoviesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int pos) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_movie, parent, false);

        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder moviesViewHolder, final int pos) {
        final Movie movie = movies.get(pos);
        moviesViewHolder.name.setText(movie.getName());

//        moviesViewHolder.poster.setImageResource(movie.getPoster());

//        moviesViewHolder.poster.setImageBitmap(
//                Util.decodeSampledBitmapFromResource(context.getResources(), movie.getPoster(), 230, 180));


        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_foreground);

        Glide
            .with(context)
            .setDefaultRequestOptions(requestOptions)
            .load(movie.getPoster())
            .into(moviesViewHolder.poster);

        moviesViewHolder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieActivity.launchMovieActivity(context, movie);
            }
        });
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }


    class MoviesViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView poster;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            poster = itemView.findViewById(R.id.poster);
        }
    }
}
