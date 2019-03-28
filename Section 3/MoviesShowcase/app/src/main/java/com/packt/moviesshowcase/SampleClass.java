package com.packt.moviesshowcase;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SampleClass {


    public static boolean isMovieInList(List<Movie> movies, Movie movie) {

        boolean areTheyEqual = false;

        Comparator<Movie> comparator = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                String name1 = o1.getName();
                String name2 = o2.getName();

                return (name1.equals(name2) ? 0 : 1);
            }
        };

        for (int i = 0; i < movies.size(); i++) {
            Movie movie1 = movies.get(i);
            areTheyEqual = Objects.compare(movie1, movie, comparator) == 0;
        }

        return areTheyEqual;
    }

}
