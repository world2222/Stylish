package com.example.stylish.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.stylish.presentation.detail.DetailScreen
import com.example.stylish.presentation.home.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    navigation(
        route = MainGraph.HomeScreen.route,
        startDestination =HomeDetailScreen.HomeMainScreen.route
    ) {
        composable(route = HomeDetailScreen.HomeMainScreen.route) {
            HomeScreen(
                navController = navController,
                paddingValues = paddingValues
            )
        }
        composable(
            route = HomeDetailScreen.ItemDetailScreen.route + "/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("itemId")?.let {
                DetailScreen(
                    itemId = it,
                    paddingValues = paddingValues
                )
            }
        }
    }
}

sealed class HomeDetailScreen(val route: String) {
    data object HomeMainScreen: HomeDetailScreen(route = "HomeMainScreen")

    data object ItemDetailScreen: HomeDetailScreen(route = "ItemDetailScreen")
}