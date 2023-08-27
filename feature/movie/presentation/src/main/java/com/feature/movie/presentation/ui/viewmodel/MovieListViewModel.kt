package com.feature.movie.presentation.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.NetworkResponse
import com.feature.movie.domain.use_case.GetMovieListUseCase
import com.feature.movie.presentation.model.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _movieListState = mutableStateOf(MovieListState())
    val movieListState: State<MovieListState> = _movieListState

    private val _query = MutableStateFlow<String>("")
    val query: StateFlow<String> = _query

    fun setQuery(query: String) {
        _query.value = query
    }

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                getMovieList(it)
            }
        }
    }

    fun getMovieList(query: String) = viewModelScope.launch {
        getMovieListUseCase(query).onEach {
            when (it) {
                is NetworkResponse.Loading -> {
                    _movieListState.value = movieListState.value.copy(isLoading = true)
                }

                is NetworkResponse.Error -> {
                    _movieListState.value = movieListState.value.copy(error = it.message.toString())
                }

                is NetworkResponse.Success -> {
                    _movieListState.value = movieListState.value.copy(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}