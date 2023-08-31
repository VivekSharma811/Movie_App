package com.core.network.datasource

import com.core.network.model.movie.MovieListResponse

interface MovieDataSource {

    suspend fun getMovieList(query: String): MovieListResponse
}