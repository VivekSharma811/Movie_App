package com.feature.movie_details.data.mapper

import com.feature.movie_details.data.remote.model.MovieDetailsDTO
import com.feature.movie_details.domain.model.MovieDetails

const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"

fun MovieDetailsDTO.toMovieDetails(): MovieDetails {
    return MovieDetails(
        title = originalTitle,
        desc = overview,
        imageUrl = IMAGE_URL.plus(posterPath)
    )
}