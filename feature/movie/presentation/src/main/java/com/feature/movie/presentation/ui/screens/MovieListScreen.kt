package com.feature.movie.presentation.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun MovieListRoute(
    modifier: Modifier = Modifier
) {
    MovieListScreen(modifier)
}

@Composable
internal fun MovieListScreen(
    modifier: Modifier = Modifier
) {
    Text("Hi!, do you see me?")
}