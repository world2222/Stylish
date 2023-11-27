package com.example.stylish.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.stylish.presentation.home.component.ItemInfo
import com.example.stylish.ui.theme.DancingScript

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Stylish",
                        fontFamily = DancingScript,
                        fontSize = 35.sp,
                        fontStyle = FontStyle.Italic,
                    )
                }
            )
        }
    ) { topPadding ->

        val listState = rememberLazyListState()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(topPadding),
            state = listState
        ) {
            items(viewModel.newIn.value) {
                ItemInfo(
                    navController = navController,
                    brandName = it.brandName,
                    itemId = it.id,
                    itemName = it.name,
                    imageUrl = "https://${it.imageUrl}",
                    price = it.price.current.text
                )
            }
        }
    }
}