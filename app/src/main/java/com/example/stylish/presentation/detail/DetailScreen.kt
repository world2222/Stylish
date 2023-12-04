package com.example.stylish.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.stylish.data.local.viewModel.WishlistViewModel
import com.example.stylish.data.local.wishlistDatabase.Wishitem
import com.example.stylish.presentation.detail.component.DetailView
import com.example.stylish.presentation.detail.component.YouMightAlsoLikeRow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    itemId: Int,
    navController: NavHostController,
    viewModel: DetailViewModel = hiltViewModel(),
    dbViewModel: WishlistViewModel = hiltViewModel()
) {
    LaunchedEffect(itemId) {
        viewModel.getDetails(itemId)
    }

    // Observe wishList directly to handle LiveData changes
    val wishList by dbViewModel.wishList.observeAsState(initial = emptyList())

    // Observe wishList to update isBookmarked
    var isBookmarked by remember(wishList) {
        mutableStateOf(wishList.any { it.itemId == itemId })
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = viewModel.itemDetail.value.brand?.name ?: "",
                        fontSize = 32.sp
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            if (isBookmarked) {
                                wishList.find { it.itemId == itemId }?.let { dbViewModel.deleteWishItem(it) }
                            } else {
                                dbViewModel.addWishItem(
                                    Wishitem(
                                        itemId = itemId,
                                        brandName = viewModel.itemDetail.value.brand?.name ?: "",
                                        price = viewModel.itemDetail.value.price?.current?.text ?: "",
                                        imageUrl = viewModel.itemDetail.value.media?.images?.get(0)?.url ?: ""
                                    )
                                )
                            }
                            isBookmarked = !isBookmarked
                        }
                    ) {
                        Icon(
                            imageVector = if (isBookmarked) {
                                Icons.Default.Bookmark
                            } else {
                                Icons.Default.BookmarkBorder
                            },
                            contentDescription = "Bookmark"
                        )
                    }
                }
            )
        }
    ) {
        val scrollState = rememberLazyListState()

        LazyColumn(
            modifier = Modifier.padding(it),
            state = scrollState
        ) {
            item {
                DetailView(
                    scrollState = scrollState,
                    data = viewModel.itemDetail.value,
                )
                YouMightAlsoLikeRow(
                    navController = navController,
                    data = viewModel.youMightAlsoLike.value
                )
            }
        }
    }
}