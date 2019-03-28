package com.packt.moviesshowcase

import java.io.Serializable

data class Movie(val id: Int, val name: String, val poster: String, val genre: Genre) : Serializable