package com.example.stylish.presentation.search.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.stylish.domain.viewModel.SharedViewModel
import com.example.stylish.graphs.SearchDetailScreen
import com.example.stylish.presentation.search.main.component.AfterSearchScreen
import com.example.stylish.presentation.search.main.component.BeforeSearchScreen
import com.example.stylish.presentation.search.main.component.SearchBarM3
import com.example.stylish.presentation.search.products.byTerm.ProductsByTermScreen

@OptIn(ExperimentalMaterial3Api::class)
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
        Spacer(modifier = Modifier.height(8.dp))
        SearchBarM3()

        if (!viewModel.isActive() && viewModel.getQuery().isNotEmpty()) {
            ProductsByTermScreen(
                paddingValues = paddingValues,
                term = viewModel.getQuery(),
                minPrice = "0",
                maxPrice = "0",
                navController = navController
            )
        } else {
            BeforeSearchScreen(paddingValues = paddingValues, navController = navController)
        }
    }
}

