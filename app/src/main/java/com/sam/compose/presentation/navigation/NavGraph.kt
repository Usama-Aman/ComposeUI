package com.sam.compose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sam.compose.presentation.detail.DetailScreen
import com.sam.compose.presentation.home.HomeScreen
import com.sam.compose.presentation.home.places
import com.sam.compose.presentation.intro.IntroScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.IntroScreen.route) {
        composable(route = Routes.IntroScreen.route) {
            IntroScreen {
                navController.popBackStack()
                navController.navigate(Routes.HomeScreen.route)
            }
        }
        composable(route = Routes.HomeScreen.route) {
            HomeScreen {
                navController.navigate(Routes.DetailScreen.route)
            }
        }
        composable(route = Routes.DetailScreen.route) {
            DetailScreen(place = places[0]) {
                navController.navigateUp()
            }
        }
    }
}