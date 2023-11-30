package com.example.stylish.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.stylish.data.remote.dto.detail.Brand
import com.example.stylish.data.remote.dto.detail.Price
import com.example.stylish.presentation.detail.component.ExpandableRow

@Composable
fun DetailScreen(
    itemId: Int,
    viewModel: DetailViewModel = hiltViewModel()
) {
    LaunchedEffect(itemId) {
        viewModel.getItemDetail(itemId)
    }

    Text(text = viewModel.itemDetail.value.id.toString())
    DetailView(
        brand = viewModel.itemDetail.value.brand,
        imageList = viewModel.itemDetail.value.media?.images?.map { it.url }?: listOf(),
        itemName = viewModel.itemDetail.value.name?: "",
        price = viewModel.itemDetail.value.price,
        description = viewModel.itemDetail.value.description?: "",
        sizeAndFit = viewModel.itemDetail.value.info?.sizeAndFit?: "",
        lookAfterMe = viewModel.itemDetail.value.info?.careInfo?: "",
        aboutMe = viewModel.itemDetail.value.info?.aboutMe?: "",
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(
    brand: Brand?,
    imageList: List<String>,
    itemName: String,
    price: Price?,
    description: String,
    sizeAndFit: String,
    lookAfterMe: String,
    aboutMe: String,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = brand?.name?: "Error: No brand name",
                        fontSize = 32.sp
                    )
                }
            )
        }
    ) {
        val scrollState = rememberScrollState()
        val height = remember { mutableIntStateOf(0) }

        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(scrollState)
        ) {
            val pagerState = rememberPagerState(
                pageCount = { imageList.size }
            )

            HorizontalPager(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(314f/400f),
                state = pagerState,
                beyondBoundsPageCount = imageList.size,
            ) {index ->
                val image = rememberAsyncImagePainter(model = "https://" + imageList[index])

                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = image,
                        contentDescription = "image",
                        modifier = Modifier.fillMaxSize()
                    )
                    if (image.state is AsyncImagePainter.State.Loading) {
                        CircularProgressIndicator(
                            Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
            Row(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color = if (pagerState.currentPage == iteration) Color.Gray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(3.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(8.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 20.dp)
            ) {
                Text(
                    text = itemName,
                    style = LocalTextStyle.current.copy(
                        fontSize = 24.sp,
                        lineHeight = 32.sp
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = price?.current?.text?: "$0.00 (Error: No price info)",
                        style = LocalTextStyle.current.copy(
                            fontSize = 22.sp
                        )
                    )
                    if (price?.current?.text != price?.previous?.text) {
                        Text(
                            modifier = Modifier
                                .padding(start = 12.dp, top = 0.dp),
                            text = price?.previous?.text?: "$0.00 (Error: No original price info)",
                            style = LocalTextStyle.current.copy(
                                fontSize = 16.sp,
                                color = Color.Gray,
                                textDecoration = TextDecoration.LineThrough
                            )
                        )
                    }
                }
            }
            ExpandableRow(
                extraInfo = "Product Details",
                extraInfoDetail = description,
                scrollState = scrollState,
                height = height
            )
            ExpandableRow(
                extraInfo = "Brand",
                extraInfoDetail = brand?.description ?: "",
                scrollState = scrollState,
                height = height
            )
            ExpandableRow(
                extraInfo = "Size & Fit",
                extraInfoDetail = sizeAndFit,
                scrollState = scrollState,
                height = height
            )
            ExpandableRow(
                extraInfo = "Look After Me",
                extraInfoDetail = lookAfterMe,
                scrollState = scrollState,
                height = height
            )
            ExpandableRow(
                extraInfo = "About me",
                extraInfoDetail = aboutMe,
                scrollState = scrollState,
                height = height
            )
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}

