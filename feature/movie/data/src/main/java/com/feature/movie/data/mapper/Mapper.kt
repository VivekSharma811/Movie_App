package com.feature.movie.data.mapper

import com.feature.movie.data.remote.model.MovieListResponse
import com.feature.movie.domain.model.Movie

fun MovieListResponse.toMovieList(): List<Movie> {
    return this.results.map { Movie(it.posterPath) }
}