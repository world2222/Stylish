package com.example.stylish.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.stylish.presentation.search.category.SearchCategoryScreen
import com.example.stylish.presentation.search.main.SearchMainScreen
import com.example.stylish.presentation.search.products.ProductsScreen

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
        composable(
            route = SearchDetailScreen.ProductsScreen.route + "/{categoryId}",
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("categoryId")?.let {
                ProductsScreen(
                    paddingValues = paddingValues,
                    categoryId = it
                )
            }
        }
    }
}

sealed class SearchDetailScreen(val route: String) {
    data object SearchMainScreen : SearchDetailScreen(route = "SearchMain")
    data object SearchCategoryScreen : SearchDetailScreen(route = "SearchCategory")
    data object ProductsScreen : SearchDetailScreen(route = "Products")
}