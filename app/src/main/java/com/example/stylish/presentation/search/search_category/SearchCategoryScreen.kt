package com.example.stylish.presentation.search.search_category

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.stylish.presentation.search.search_category.component.CategoryCards
import com.example.stylish.ui.theme.DancingScript

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchCategoryScreen(
    navController: NavHostController,
    paddingValues: PaddingValues,
    gender: String
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(start = 10.dp, bottom = 8.dp),
                        text = gender,
                        fontFamily = DancingScript,
                        fontSize = 35.sp,
                        fontStyle = FontStyle.Italic,
                    )
                }
            )
        }
    ) {
        CategoryCards(
            paddingValues = it,
            gender = gender,
            navController = navController
        )
    }
}