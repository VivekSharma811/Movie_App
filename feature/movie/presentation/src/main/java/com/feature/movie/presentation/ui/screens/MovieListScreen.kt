package com.feature.movie.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.feature.movie.presentation.model.MovieListState
import com.feature.movie.presentation.ui.viewmodel.MovieListViewModel

@Composable
internal fun MovieListRoute(
    modifier: Modifier = Modifier,
    viewModel: MovieListViewModel = hiltViewModel()
) {
    val state by viewModel.movieListState
    val query by viewModel.query.collectAsStateWithLifecycle()
    MovieListScreen(
        state,
        query,
        onQueryChanged = {
            viewModel.setQuery(it)
        },
        modifier
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
internal fun MovieListScreen(
    state: MovieListState,
    query: String,
    onQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = query,
                onValueChange = onQueryChanged,
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                placeholder = { Text(text = "Search Movie...") },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }
            )
        }
    ) {
        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        if (state.error.isNotBlank()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = state.error)
            }
        }

        state.data?.let {
            if (it.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "No data found")
                }
            } else {
                LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
                    items(it) {
                        Box(
                            modifier = Modifier
                                .height(200.dp)
                                .border(width = 1.dp, color = Color.White)
                        ) {
                            AsyncImage(
                                model = it.imageUrl,
                                contentDescription = null,
                                contentScale = ContentScale.Fit
                            )
                        }
                    }
                }
            }
        }
    }
}