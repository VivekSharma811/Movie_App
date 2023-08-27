package com.feature.movie.data.remote

import com.feature.movie.data.remote.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDataSource {

    @GET("3/search/movie")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): MovieListResponse
}