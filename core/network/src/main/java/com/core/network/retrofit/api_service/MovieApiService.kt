package com.core.network.retrofit.api_service

import com.core.network.model.movie.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("3/search/movie")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): MovieListResponse
}