package com.feature.movie.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.feature.movie.presentation.ui.screens.MovieListRoute

fun NavGraphBuilder.movieNavGraph() {
    composable("movie_list") {
        MovieListRoute()
    }
}