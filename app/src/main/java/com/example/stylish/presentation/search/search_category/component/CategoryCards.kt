package com.example.stylish.presentation.search.search_category.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.stylish.domain.viewModel.SharedViewModel

@Composable
fun CategoryCards(
    paddingValues: PaddingValues,
    gender: String,
    navController: NavController,
    sharedViewModel: SharedViewModel = hiltViewModel()
) {
    val listState = rememberLazyGridState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(140.dp),
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(
                if (gender == "Men") sharedViewModel.categoryMen.value
                else sharedViewModel.categoryWomen.value
            ) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .aspectRatio(1f)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable {  },
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        val image = rememberAsyncImagePainter(model = item.content?.mobileImageUrl)

                        if (image.state is AsyncImagePainter.State.Loading) {
                            CircularProgressIndicator(Modifier
                                .align(Alignment.Center))
                        }
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = image,
                            contentDescription = "image",
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(Color.Transparent, Color.Black),
                                        startY = 320f
                                    )
                                )
                        )
                        item.content?.title?.let { title ->
                            Text(
                                text = title,
                                style = TextStyle(color = Color.White ,fontSize = 16.sp),
                                modifier = Modifier.padding(12.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}