package com.example.stylish.presentation.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.lifecycle.ViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.stylish.graphs.MainGraph
import com.example.stylish.model.main.BottomNavigationItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : ViewModel() {
    // Navigation items
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = MainGraph.HomeScreen.route
        ),
        BottomNavigationItem(
            title = "Create",
            selectedIcon = Icons.Filled.Create,
            unselectedIcon = Icons.Outlined.Create,
            route = MainGraph.CreateScreen.route
        ),
        BottomNavigationItem(
            title = "Search",
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search,
            route = MainGraph.SearchScreen.route
        ),
        BottomNavigationItem(
            title = "My Page",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            route = MainGraph.MyPageScreen.route
        )
        // more here...
    )

    // Function to handle navigation
    fun navigate(navController: NavHostController, route: String) {
        navController.navigate(route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}