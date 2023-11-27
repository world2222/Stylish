package com.example.stylish.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stylish.R

@Composable
fun DetailScreen(
    itemId: String,
    viewModel: DetailViewModel = hiltViewModel()
) {
    viewModel.getItemDetail(itemId.toInt())

    DetailView(
        brandName = viewModel.itemDetail.value.brand?.name?: "",
        imageList = viewModel.itemDetail.value.media?.images?.map { it.url }?: listOf(),
        itemName = viewModel.itemDetail.value.name?: "",
        curPrice = viewModel.itemDetail.value.price?.current?.text?: "$0.00",
        prePrice = viewModel.itemDetail.value.price?.previous?.text?: "$0.00",
        about = viewModel.itemDetail.value.info?.aboutMe?: "",
        careInfo = viewModel.itemDetail.value.info?.careInfo?: ""
    )

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(
    brandName: String,
    imageList: List<String>,
    itemName: String,
    curPrice: String,
    prePrice: String,
    about: String,
    careInfo: String
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = brandName,
                        fontSize = 32.sp
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            val pagerState = rememberPagerState(
                pageCount = { imageList.size }
            )

            HorizontalPager(
                state = pagerState,
                beyondBoundsPageCount = imageList.size
            ) {
                Image(
                    painter = painterResource(id = R.drawable.donut),
                    contentDescription = "donut"
                )
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
                    .padding(top = 12.dp, start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = itemName,
                    fontSize = 25.sp
                )
                Row(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(
                        text = "Price : $curPrice",
                        fontSize = 20.sp
                    )
                    Text(
                        modifier = Modifier.padding(start = 16.dp, top = 4.dp),
                        text = "($prePrice)",
                        fontSize = 16.sp
                    )
                }
                Text(text = "About : $about", fontSize = 12.sp)
                Text(text = "Careful! : $careInfo", fontSize = 12.sp)
            }
        }
    }
}