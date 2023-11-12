package com.example.stylish.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stylish.ui.theme.DancingScript

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        topBar = {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp),
                text = "Stylish",
                style = LocalTextStyle.current.copy(
                    fontFamily = DancingScript,
                    fontSize = 35.sp,
                    fontStyle = FontStyle.Italic,
                )
            )
        }
    ) {
        val listState = rememberLazyListState()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            state = listState,
            contentPadding = PaddingValues(16.dp)
        ) {
            items(11) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = it.toString(), style = LocalTextStyle.current.copy(fontSize = 50.sp))
                }
            }
        }
    }
}