package com.core.network.retrofit.datasource

import com.core.network.datasource.MovieDataSource
import com.core.network.model.movie.MovieListResponse
import com.core.network.retrofit.api_service.MovieApiService
import javax.inject.Inject

class MovieDataSourceRetrofit @Inject constructor(
    private val movieApiService: MovieApiService,
    private val apiKey: String
) : MovieDataSource {
    override suspend fun getMovieList(query: String): MovieListResponse {
        return movieApiService.getMovieList(apiKey, query)
    }
}