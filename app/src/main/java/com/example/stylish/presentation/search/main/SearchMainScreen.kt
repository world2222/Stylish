package com.example.stylish.presentation.search.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.stylish.presentation.search.main.component.BeforeSearchScreen
import com.example.stylish.presentation.search.main.component.Conditions
import com.example.stylish.presentation.search.main.component.SearchBarM3
import com.example.stylish.presentation.search.products.byTerm.ProductsByTermScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchMainScreen(
    paddingValues: PaddingValues,
    navController: NavHostController,
    viewModel: SearchMainViewModel = hiltViewModel()
) {
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        SearchBarM3()

        if (viewModel.getQuery().isEmpty()) {
            Conditions()
            BeforeSearchScreen(paddingValues = paddingValues, navController = navController)
        } else {
            ProductsByTermScreen(
                paddingValues = paddingValues,
                term = viewModel.getQuery(),
                sortType = viewModel.sortType.value,
                minPrice = viewModel.minPrice.value,
                maxPrice = viewModel.maxPrice.value,
                navController = navController
            )
        }
    }
}
