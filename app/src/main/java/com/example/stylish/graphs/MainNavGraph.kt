package com.example.stylish.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stylish.presentation.create.CreateScreen
import com.example.stylish.presentation.wishlist.WishListScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        route = RootGraph.MainScreen.route,
        startDestination = MainGraph.HomeScreen.route
    ) {
        homeNavGraph(
            navController = navController,
            paddingValues = paddingValues
        )
        composable(route = MainGraph.CreateScreen.route) {
            CreateScreen(paddingValues = paddingValues)
        }
        searchNavGraph(
            navController = navController,
            paddingValues = paddingValues
        )
        composable(route = MainGraph.MyPageScreen.route) {
            WishListScreen(
                navController = navController,
                paddingValues = paddingValues
            )
        }
    }
}

sealed class MainGraph(val route: String) {
    data object HomeScreen: MainGraph(route = "HomeScreen")
    data object CreateScreen: MainGraph(route = "CreateScreen")
    data object SearchScreen: MainGraph(route = "SearchScreen")
    data object MyPageScreen: MainGraph(route = "MyPageScreen")
}