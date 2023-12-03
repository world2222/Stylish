package com.example.stylish.presentation.detail.component

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.stylish.data.remote.dto.detail.Data

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(
    scrollState: ScrollState,
    data: Data
) {

    val height = remember { mutableIntStateOf(0) }
    val imageList = data.media?.images?.map { it.url }?: listOf()
    val price = data.price

    val pagerState = rememberPagerState(
        pageCount = { imageList.size }
    )

    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(314f / 400f),
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
            text = data.name?: "",
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
        extraInfoDetail = data.description?: "",
        scrollState = scrollState,
        height = height
    )
    ExpandableRow(
        extraInfo = "Brand",
        extraInfoDetail = data.brand?.description ?: "",
        scrollState = scrollState,
        height = height
    )
    ExpandableRow(
        extraInfo = "Size & Fit",
        extraInfoDetail = data.info?.sizeAndFit?: "",
        scrollState = scrollState,
        height = height
    )
    ExpandableRow(
        extraInfo = "Look After Me",
        extraInfoDetail = data.info?.careInfo?: "",
        scrollState = scrollState,
        height = height
    )
    ExpandableRow(
        extraInfo = "About me",
        extraInfoDetail = data.info?.aboutMe?: "",
        scrollState = scrollState,
        height = height
    )
    Spacer(modifier = Modifier.height(6.dp))
}

