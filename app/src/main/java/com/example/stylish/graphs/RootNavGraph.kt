package com.example.stylish.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.stylish.presentation.detail.DetailScreen
import com.example.stylish.presentation.main.MainScreen
import com.example.stylish.presentation.search.products.ProductsScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = RootGraph.LoginScreen.route,
        startDestination = RootGraph.MainScreen.route,
    ) {
        composable(route = RootGraph.MainScreen.route) {
            MainScreen()
        }
    }
}

sealed class RootGraph(val route: String) {
    data object LoginScreen: RootGraph(route = "LoginScreen")
    data object MainScreen: RootGraph(route = "MainScreen")
}