package com.example.stylish.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.stylish.presentation.home.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    navigation(
        route = MainGraph.HomeScreen.route,
        startDestination =HomeDetailScreen.HomeScreen.route
    ) {
        composable(route = HomeDetailScreen.HomeScreen.route) {
            HomeScreen(paddingValues = paddingValues)
        }
    }
}

sealed class HomeDetailScreen(val route: String) {
    data object HomeScreen: HomeDetailScreen(route = "Home")
}