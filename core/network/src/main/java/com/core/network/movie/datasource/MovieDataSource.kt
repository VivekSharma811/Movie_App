package com.core.network.movie.datasource

import com.core.network.movie.dto.MovieListResponse

interface MovieDataSource {

    suspend fun getMovieList(query: String): MovieListResponse
}