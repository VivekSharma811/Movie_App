package com.feature.movie.presentation.model

import com.feature.movie.domain.model.Movie

data class MovieListState(
    val isLoading: Boolean = false,
    val data: List<Movie>? = null,
    val error: String = ""
)
