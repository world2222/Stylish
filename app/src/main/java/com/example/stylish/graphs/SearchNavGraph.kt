package com.example.stylish.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.stylish.presentation.detail.DetailScreen
import com.example.stylish.presentation.search.category.SearchCategoryScreen
import com.example.stylish.presentation.search.main.SearchMainScreen
import com.example.stylish.presentation.search.products.byId.ProductsByIdScreen

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
            route = SearchDetailScreen.ProductsByIdScreen.route + "/{categoryId}",
            arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("categoryId")?.let {
                ProductsByIdScreen(
                    navController = navController,
                    paddingValues = paddingValues,
                    categoryId = it
                )
            }
        }
        composable(
            route = RootGraph.ItemDetailScreen.route + "/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("itemId")?.let {
                DetailScreen(
                    itemId = it,
                    navController = navController
                )
            }
        }
    }
}

sealed class SearchDetailScreen(val route: String) {
    data object SearchMainScreen : SearchDetailScreen(route = "SearchMainScreen")
    data object SearchCategoryScreen : SearchDetailScreen(route = "SearchCategoryScreen")
    data object ProductsByIdScreen : SearchDetailScreen(route = "ProductsByIdScreen")
}