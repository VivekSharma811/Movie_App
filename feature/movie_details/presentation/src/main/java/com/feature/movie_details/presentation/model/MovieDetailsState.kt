package com.feature.movie_details.presentation.model

import com.feature.movie_details.domain.model.MovieDetails

data class MovieDetailsState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: MovieDetails? = null
)
