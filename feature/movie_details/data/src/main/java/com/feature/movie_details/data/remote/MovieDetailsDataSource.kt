package com.feature.movie_details.data.remote

import com.feature.movie_details.data.remote.model.MovieDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsDataSource {

    @GET("3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id:String,
        @Query("api_key") apiKey: String
    ) : MovieDetailsDTO
}