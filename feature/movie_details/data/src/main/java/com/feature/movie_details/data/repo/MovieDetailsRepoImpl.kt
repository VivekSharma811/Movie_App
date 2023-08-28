package com.feature.movie_details.data.repo

import com.feature.movie_details.data.mapper.toMovieDetails
import com.feature.movie_details.data.remote.MovieDetailsDataSource
import com.feature.movie_details.domain.model.MovieDetails
import com.feature.movie_details.domain.repo.MovieDetailsRepository
import javax.inject.Inject

class MovieDetailsRepoImpl @Inject constructor(
    private val movieDetailsDataSource: MovieDetailsDataSource,
    private val apiKey: String
) : MovieDetailsRepository {

    override suspend fun getMovieDetails(id: String): MovieDetails {
        return movieDetailsDataSource.getMovieDetails(id, apiKey).toMovieDetails()
    }
}