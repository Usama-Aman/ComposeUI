package com.sam.compose.presentation.home_navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sam.compose.R
import com.sam.compose.presentation.detail.DetailScreen
import com.sam.compose.presentation.detail.components.DetailSection
import com.sam.compose.presentation.home.HomeScreen
import com.sam.compose.presentation.home.places
import com.sam.compose.presentation.home_navigation.components.BottomNavigation
import com.sam.compose.presentation.navigation.Routes

@Composable
fun HomeNavigator() {

    val bottomBarItems = remember {
        listOf(
            R.drawable.ic_home,
            R.drawable.ic_ticket
        )
    }

    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value

    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    selectedItem = remember(key1 = backStackState) {
        when (backStackState?.destination?.route) {
            Routes.HomeScreen.route -> 0
            Routes.DetailScreen.route -> 1
            else -> 0
        }
    }

    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route == Routes.HomeScreen.route
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible)
                BottomNavigation(
                    items = bottomBarItems,
                    selectedIndex = selectedItem,
                    onItemSelected = {
                        when (it) {
                            0 -> navigateToTab(navController = navController, Routes.HomeScreen.route)
                            1 -> navigateToTab(navController = navController, Routes.DetailScreen.route)
                        }
                    }
                )
        }
    ) {
        val bottomBarPadding = it.calculateBottomPadding()

        NavHost(
            navController = navController,
            startDestination = Routes.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomBarPadding)
        ) {

            composable(route = Routes.HomeScreen.route) {
                HomeScreen {
                    navController.navigate(Routes.DetailScreen.route)
                }
            }

            composable(Routes.DetailScreen.route) {
                DetailScreen(place = places[0]) {
                    navController.navigateUp()
                }
            }
        }
    }


}

fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route = route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(route = homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}