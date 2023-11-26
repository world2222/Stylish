package com.example.stylish.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.stylish.presentation.search.search_category.SearchCategoryScreen
import com.example.stylish.presentation.search.search_main.SearchMainScreen

fun NavGraphBuilder.searchNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    navigation(
        route = MainGraph.SearchScreen.route,
        startDestination = SearchDetailScreen.SearchMainScreen.route
    ) {
        composable(route = SearchDetailScreen.SearchMainScreen.route) {
            SearchMainScreen(
                paddingValues = paddingValues,
                navController = navController,
            )
        }
        composable(
            route = SearchDetailScreen.SearchCategoryScreen.route + "/{gender}",
            arguments = listOf(navArgument("gender") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("gender")?.let {
                SearchCategoryScreen(
                    navController = navController,
                    paddingValues = paddingValues,
                    gender = it,
                )
            }
        }
    }
}

sealed class SearchDetailScreen(val route: String) {
    data object SearchMainScreen : SearchDetailScreen(route = "SearchMain")
    data object SearchCategoryScreen : SearchDetailScreen(route = "SearchCategory")
}