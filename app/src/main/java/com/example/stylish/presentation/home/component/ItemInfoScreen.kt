package com.example.stylish.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.stylish.data.local.viewModel.WishlistViewModel
import com.example.stylish.data.local.wishlistDatabase.Wishitem
import com.example.stylish.graphs.HomeDetailScreen
import com.example.stylish.graphs.RootGraph
import java.util.Locale

@Composable
fun ItemInfoScreen(
    navController: NavController,
    brandName: String,
    itemId: Int,
    itemName: String,
    imageUrl: String,
    price: String,
    dbViewModel: WishlistViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Observe wishList directly to handle LiveData changes
        val wishList by dbViewModel.wishList.observeAsState(initial = emptyList())

        // Observe wishList to update isBookmarked
        var isBookmarked by remember(wishList) {
            mutableStateOf(wishList.any { it.itemId == itemId })
        }

        Text(
            modifier = Modifier.padding(16.dp),
            text = brandName,
            style = LocalTextStyle.current.copy(
                fontSize = 24.sp
            )
        )

        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = itemName.replace(brandName, "").replace(brandName.uppercase(), "").trim()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        val image = rememberAsyncImagePainter(model = imageUrl)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(314f / 400f)
        ) {
            Image(
                painter = image,
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { navController.navigate(RootGraph.ItemDetailScreen.route + "/${itemId}") }
            )
            if (image.state is AsyncImagePainter.State.Loading) {
                CircularProgressIndicator(Modifier
                    .align(Alignment.Center))
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = price,
                style = LocalTextStyle.current.copy(
                    fontSize = 20.sp
                )
            )
            IconButton(
                onClick = {
                    if (isBookmarked) {
                        wishList.find { it.itemId == itemId }
                            ?.let { dbViewModel.deleteWishItem(it) }
                    } else {
                        dbViewModel.addWishItem(
                            Wishitem(
                                itemId = itemId,
                                brandName = brandName,
                                price = price,
                                imageUrl = imageUrl
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

        Spacer(modifier = Modifier.height(30.dp))
    }
}