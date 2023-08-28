package com.feature.movie_details.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.feature.movie_details.presentation.ui.screens.MovieDetailsRoute

const val ID = "id"
const val moveDetailsNavRoute = "movie_details/{$ID}"

fun NavController.navigateToMoveDetails(id: String) {
    this.navigate(
        moveDetailsNavRoute.replace(
            oldValue = "{$ID}",
            newValue = id
        )
    )
}

fun NavGraphBuilder.movieDetailsNavGraph() {
    composable(
        route = moveDetailsNavRoute,
        arguments = listOf(
            navArgument(ID) {
                type = NavType.StringType
            }
        )
    ) {
        MovieDetailsRoute()
    }
}
