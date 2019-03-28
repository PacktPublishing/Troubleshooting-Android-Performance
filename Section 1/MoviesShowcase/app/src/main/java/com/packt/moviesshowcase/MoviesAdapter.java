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

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private Context context;
    private List<Movie> movies;

    public MoviesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int pos) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_movie, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder moviesViewHolder, int pos) {
        final Movie movie = movies.get(pos);
        moviesViewHolder.name.setText(movie.getName());

//        moviesViewHolder.poster.setImageResource(movie.getPoster());

//        moviesViewHolder.poster.setImageBitmap(
//                Util.decodeSampledBitmapFromResource(context.getResources(), movie.getPoster(), 230, 180));

        Glide.with(context).load(movie.getPoster()).into(moviesViewHolder.poster);
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
