package com.example.stylish.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import java.util.Locale

@Composable
fun ItemInfo(
    brandName: String,
    itemName: String,
    imageUrl: String,
    price: String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = brandName,
            style = LocalTextStyle.current.copy(
                fontSize = 24.sp
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

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
                .aspectRatio(314f/400f)
        ) {
            Image(
                painter = image,
                contentDescription = "image",
                modifier = Modifier.fillMaxSize()
            )
            if (image.state is AsyncImagePainter.State.Loading) {
                CircularProgressIndicator(Modifier
                    .align(Alignment.Center))
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = price,
            textAlign = TextAlign.End,
            style = LocalTextStyle.current.copy(
                fontSize = 20.sp
            )
        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}