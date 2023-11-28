package com.example.stylish.presentation.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.stylish.graphs.MainNavGraph
import com.example.stylish.graphs.RootGraph
import com.example.stylish.presentation.main.component.AddItem

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = hiltViewModel()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarVisible =
        currentDestination?.route?.contains(RootGraph.ItemDetailScreen.route) == false


    Scaffold(
        bottomBar = {
            AnimatedVisibility(visible = bottomBarVisible) {
                NavigationBar {
                    viewModel.items.forEach { screen ->
                        AddItem(
                            screen = screen,
                            currentDestination = currentDestination,
                            navController = navController,
                            navigate = viewModel::navigate
                        )
                    }
                }
            }
        },
    ) {
        MainNavGraph(
            navController = navController,
            paddingValues = it
        )
    }
}