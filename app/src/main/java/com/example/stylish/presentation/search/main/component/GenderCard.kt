package com.example.stylish.presentation.search.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stylish.graphs.SearchDetailScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderCard(
    gender: String,
    navController: NavController
) {
    Card(
        onClick = {
            navController.navigate(SearchDetailScreen.SearchCategoryScreen.route + "/${gender}")
        },
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(7f / 4f)
            .padding(horizontal = 38.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomStart
        ){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.radialGradient(
                            colors = listOf(Color(0xffededed), Color.Gray),
                            center = Offset(270f, 330f),
                            radius = 900f
                        )
                    )
            )
            Text(
                text = gender,
                modifier = Modifier.padding(start = 38.dp, bottom = 90.dp),
                style = LocalTextStyle.current.copy(
                    fontSize = 58.sp,
                    color = Color(0xff292929)
                )
            )
        }
    }
}