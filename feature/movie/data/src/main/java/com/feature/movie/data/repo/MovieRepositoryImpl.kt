package com.feature.movie.data.repo

import com.feature.movie.data.mapper.toMovieList
import com.feature.movie.data.remote.MovieDataSource
import com.feature.movie.domain.model.Movie
import com.feature.movie.domain.repo.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val apiKey: String
) : MovieRepository {

    override suspend fun getMoviesList(query: String): List<Movie> {
        return movieDataSource.getMovieList(apiKey, query).toMovieList()
    }
}