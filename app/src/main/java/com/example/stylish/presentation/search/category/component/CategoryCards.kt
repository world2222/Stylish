package com.example.stylish.presentation.search.category.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.stylish.domain.viewModel.SharedViewModel
import com.example.stylish.graphs.SearchDetailScreen

@Composable
fun CategoryCards(
    paddingValues: PaddingValues,
    gender: String,
    navController: NavController,
    sharedViewModel: SharedViewModel = hiltViewModel()
) {
    val listState = rememberLazyGridState()

    val isLoaded = rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(key1 = gender) {
        if (!isLoaded.value) {
            sharedViewModel.getCategoryByGender(gender)
            isLoaded.value = true
        }
    }

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
                .padding(horizontal = 8.dp)
        ) {
            items(sharedViewModel.category.value) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .aspectRatio(1f)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable {
                            navController.navigate(SearchDetailScreen.ProductsByIdScreen.route + "/${item.link?.categoryId}")
                        },
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        val image = rememberAsyncImagePainter(model = item.content?.mobileImageUrl)

                        if (image.state is AsyncImagePainter.State.Loading) {
                            CircularProgressIndicator(
                                Modifier
                                    .align(Alignment.Center)
                            )
                        }
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = image,
                            contentDescription = "image",
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.3f)
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(Color.Transparent, Color.DarkGray)
                                    )
                                )
                        )
                        item.content?.title?.let { title ->
                            Text(
                                text = title,
                                style = TextStyle(color = Color.White, fontSize = 15.sp),
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}