package com.feature.movie.data.repo

import com.core.network.movie.datasource.MovieDataSource
import com.feature.movie.data.mapper.toMovieList
import com.feature.movie.domain.model.Movie
import com.feature.movie.domain.repo.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource
) : MovieRepository {

    override suspend fun getMoviesList(query: String): List<Movie> {
        return movieDataSource.getMovieList(query).toMovieList()
    }
}