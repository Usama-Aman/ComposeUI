package com.sam.compose.presentation.navigation

sealed class Routes(val route: String) {
    data object IntroScreen : Routes(route = "intro_screen")
    data object HomeNavigation : Routes(route = "home_navigation")
    data object HomeScreen : Routes(route = "home_screen")
    data object DetailScreen : Routes(route = "detail_screen")
}