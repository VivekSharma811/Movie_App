package com.feature.movie_details.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.feature.movie_details.presentation.ui.screens.MovieDetailsRoute

fun NavGraphBuilder.movieDetailsNavGraph() {
    composable("movie_details") {
        MovieDetailsRoute()
    }
}
