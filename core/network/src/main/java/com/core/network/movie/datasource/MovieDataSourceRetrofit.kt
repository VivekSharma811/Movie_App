package com.core.network.movie.datasource

import com.core.network.movie.dto.MovieListResponse
import com.core.network.retrofit.MovieApiService
import javax.inject.Inject

class MovieDataSourceRetrofit @Inject constructor(
    private val movieApiService: MovieApiService,
    private val apiKey: String
) : MovieDataSource {
    override suspend fun getMovieList(query: String): MovieListResponse {
        return movieApiService.getMovieList(apiKey, query)
    }
}