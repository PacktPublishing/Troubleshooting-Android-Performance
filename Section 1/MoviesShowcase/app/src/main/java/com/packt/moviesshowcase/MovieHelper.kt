package com.packt.moviesshowcase

class MovieHelper {

    companion object {

        fun getComedyMovies(movies: List<Movie>): List<Movie> {
            val comedyMovie = arrayListOf<Movie>()
            movies.forEach {
                if (it.genre == Genre.COMEDY) {
                    comedyMovie.add(it)
                }
            }
            return comedyMovie
        }


    }

}
