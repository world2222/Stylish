package com.example.stylish.presentation.main.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.example.stylish.model.main.BottomNavigationItem

@Composable
fun RowScope.AddItem(
    screen: BottomNavigationItem,
    currentDestination: NavDestination?,
    navController: NavHostController,
    navigate: (NavHostController, String) -> Unit
) {
    NavigationBarItem(
        label = { Text(text = screen.title) },
        icon = {
            if (screen.route == currentDestination?.route) {
                Icon(
                    imageVector = screen.selectedIcon,
                    contentDescription = screen.title
                )
            } else {
                Icon(
                    imageVector = screen.unselectedIcon,
                    contentDescription = screen.title
                )
            }
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navigate(navController, screen.route)
        },
//        colors = NavigationBarItemDefaults.colors(
//
//            selectedIconColor = Color.Blue,
//            selectedTextColor = Color.Blue,
//            unselectedIconColor = Color.LightGray,
//            unselectedTextColor = Color.LightGray,
//            indicatorColor = Color.Red
//        )
    )
}