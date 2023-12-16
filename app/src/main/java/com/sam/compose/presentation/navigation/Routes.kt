package com.sam.compose.presentation.navigation

sealed class Routes(val route: String) {
    data object IntroScreen : Routes(route = "Intro")
    data object HomeScreen : Routes(route = "Home")
    data object DetailScreen : Routes(route = "Detail")
}