package com.feature.movie.data.mapper

import com.feature.movie.data.remote.model.MovieListResponse
import com.feature.movie.domain.model.Movie

const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"

fun MovieListResponse.toMovieList(): List<Movie> {
    return this.results.map {
        Movie(
            imageUrl = IMAGE_URL.plus(it.posterPath),
            id = it.id.toString()
        )
    }
}