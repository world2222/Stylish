package com.example.stylish.presentation.search.main.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.stylish.domain.viewModel.SharedViewModel

@Composable
fun BeforeSearchScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: SharedViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getMenWomenImage()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Men & Women category cards
        if (viewModel.menWomenImage.value.isNotEmpty()) {
            GenderCard(gender = "Men", navController = navController, imageUrl = viewModel.menWomenImage.value[0])
            Spacer(modifier = Modifier.height(50.dp))
            GenderCard(gender = "Women", navController = navController, imageUrl = viewModel.menWomenImage.value[1])
        }
    }
}