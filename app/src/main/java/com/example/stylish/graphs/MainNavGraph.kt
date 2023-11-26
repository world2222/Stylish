package com.example.stylish.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stylish.presentation.create.CreateScreen
import com.example.stylish.presentation.home.HomeScreen
import com.example.stylish.presentation.mypage.MyPageScreen
import com.example.stylish.presentation.search.search_main.SearchMainScreen

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
        composable(route = MainGraph.HomeScreen.route) {
            HomeScreen(paddingValues = paddingValues)
        }
        composable(route = MainGraph.CreateScreen.route) {
            CreateScreen(paddingValues = paddingValues)
        }
        searchNavGraph(
            navController = navController,
            paddingValues = paddingValues
        )
        composable(route = MainGraph.MyPageScreen.route) {
            MyPageScreen(paddingValues = paddingValues)
        }
    }
}

sealed class MainGraph(val route: String) {
    data object HomeScreen: MainGraph(route = "HomeScreen")
    data object CreateScreen: MainGraph(route = "CreateScreen")
    data object SearchScreen: MainGraph(route = "SearchScreen")
    data object MyPageScreen: MainGraph(route = "MyPageScreen")
}