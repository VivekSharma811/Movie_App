package com.feature.movie.data.remote.model

data class MovieListResponse(
    val page: Int,
    val results: List<MovieDTO>,
    val total_pages: Int,
    val total_results: Int
)