package com.example.stylish.presentation.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.stylish.data.remote.dto.you_might_also_like.DataYouMightAlsoLike
import com.example.stylish.graphs.RootGraph

@Composable
fun YouMightAlsoLikeRow(
    data: List<DataYouMightAlsoLike>,
    navController: NavController
) {
    val lazyRowState = rememberLazyListState()
    Divider(modifier = Modifier.padding(horizontal = 20.dp))
    Spacer(modifier = Modifier.height(32.dp))
    Text(
        modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp),
        text = "You might also like",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        state = lazyRowState,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .height(200.dp)
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
                            contentDescription = "you might also like this image",
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
                            text = item.brandName?: "(Error)",
                            style = TextStyle(color = Color.White, fontSize = 15.sp),
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 2.dp, end = 6.dp),
                        text = item.price?.current?.text?: "(Error)",
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
    Spacer(modifier = Modifier.height(16.dp))
}