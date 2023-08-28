package com.feature.movie_details.domain.repo

import com.feature.movie_details.domain.model.MovieDetails

interface MovieDetailsRepository {

    suspend fun getMovieDetails(id: String): MovieDetails
}