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
            route = RootGraph.ItemDetailScreen.route + "/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("itemId")?.let {
                DetailScreen(itemId = it)
            }
        }
    }
}

sealed class HomeDetailScreen(val route: String) {
    data object HomeMainScreen: HomeDetailScreen(route = "HomeMainScreen")
}