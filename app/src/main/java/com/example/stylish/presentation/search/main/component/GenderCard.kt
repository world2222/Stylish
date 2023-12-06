package com.example.stylish.presentation.search.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.stylish.graphs.SearchDetailScreen
import com.example.stylish.ui.theme.DancingScript

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderCard(
    gender: String,
    navController: NavController,
    imageUrl: String
) {
    val image = rememberAsyncImagePainter(model = imageUrl)

    Card(
        onClick = {
            navController.navigate(SearchDetailScreen.SearchCategoryScreen.route + "/${gender}")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 38.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(400f / 133f),
            contentAlignment = Alignment.TopStart
        ){

            Image(
                painter = image,
                contentDescription = "bar image",
                modifier = Modifier.fillMaxSize()
            )
            if (image.state is AsyncImagePainter.State.Loading) {
                CircularProgressIndicator(
                    Modifier.align(Alignment.Center)
                )
            }

            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = gender,
                style = LocalTextStyle.current.copy(
                    fontFamily = DancingScript,
                    fontSize = 58.sp,
                    color = Color.DarkGray,
                    fontStyle = FontStyle.Italic
                )
            )
        }
    }
}