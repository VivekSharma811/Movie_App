package com.feature.movie_details.domain.use_case

import com.core.common.NetworkResponse
import com.feature.movie_details.domain.model.MovieDetails
import com.feature.movie_details.domain.repo.MovieDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieDetailsRepository: MovieDetailsRepository
) {

    operator fun invoke(id: String) = flow<NetworkResponse<MovieDetails>> {
        emit(NetworkResponse.Loading())

        emit(NetworkResponse.Success(movieDetailsRepository.getMovieDetails(id)))
    }.catch {
        emit(NetworkResponse.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}