package com.example.stylish.presentation.search.products.byTerm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.stylish.graphs.RootGraph
import com.example.stylish.presentation.search.main.component.SearchBarM3

@Composable
fun ProductsByTermScreen(
    paddingValues: PaddingValues,
    term: String,
    sortType: String,
    minPrice: String,
    maxPrice: String,
    viewModel: ProductsByTermViewModel = hiltViewModel(),
    navController: NavHostController
) {
    LaunchedEffect(
        key1 = term,
        key2 = sortType,
        block = {
            viewModel.getProductByItemTerm(
                term = term,
                sortType = sortType,
                minPrice = minPrice,
                maxPrice = maxPrice
            )
        }
    )

    LaunchedEffect(
        key1 = minPrice,
        key2 = maxPrice,
        block = {
            viewModel.getProductByItemTerm(
                term = term,
                sortType = sortType,
                minPrice = minPrice,
                maxPrice = maxPrice
            )
        }
    )

    val listState = rememberLazyGridState()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(140.dp),
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = paddingValues.calculateTopPadding() + 8.dp, start = 8.dp, end = 8.dp)
    ) {
        items(viewModel.productList.value) { item ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(320 / 400f)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        navController.navigate(RootGraph.ItemDetailScreen.route + "/${item.id}")
                    },
            ) {
                Box(
                    contentAlignment = Alignment.TopEnd
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        val image =
                            rememberAsyncImagePainter(model = "https://${item.imageUrl}")

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
                                .fillMaxHeight(0.18f)
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(Color.Transparent, Color.DarkGray)
                                    )
                                )
                        )
                        Text(
                            text = item.brandName,
                            style = TextStyle(color = Color.White, fontSize = 15.sp),
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 2.dp, end = 6.dp),
                        text = item.price.current.text,
                        style = LocalTextStyle.current.copy(
                            textAlign = TextAlign.End,
                            fontSize = 10.sp,
                            color = Color.DarkGray
                        )
                    )
                }
            }
        }
    }
}