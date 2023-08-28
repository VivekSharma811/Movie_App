package com.feature.movie_details.presentation.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.NetworkResponse
import com.feature.movie_details.domain.use_case.GetMovieDetailsUseCase
import com.feature.movie_details.presentation.model.MovieDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _movieDetailsState = mutableStateOf(MovieDetailsState())
    val movieDetailsState: State<MovieDetailsState> = _movieDetailsState

    init {
        savedStateHandle.getLiveData<String>("id").observeForever {
            it?.let {
                getMovieDetails(it)
            }
        }
    }

    fun getMovieDetails(id: String) {
        getMovieDetailsUseCase(id).onEach {
            when (it) {
                is NetworkResponse.Loading -> {
                    _movieDetailsState.value = movieDetailsState.value.copy(isLoading = true)
                }

                is NetworkResponse.Error -> {
                    _movieDetailsState.value = movieDetailsState.value.copy(
                        isLoading = false,
                        error = it.message.toString()
                    )
                }

                is NetworkResponse.Success -> {
                    _movieDetailsState.value = movieDetailsState.value.copy(
                        isLoading = false,
                        data = it.data
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}