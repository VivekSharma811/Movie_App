package com.feature.movie.domain.use_case

import com.core.common.NetworkResponse
import com.feature.movie.domain.model.Movie
import com.feature.movie.domain.repo.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    operator fun invoke(query: String) = flow<NetworkResponse<List<Movie>>> {
        emit(NetworkResponse.Loading())
        emit(NetworkResponse.Success(movieRepository.getMoviesList(query)))
    }.catch {
        emit(NetworkResponse.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}