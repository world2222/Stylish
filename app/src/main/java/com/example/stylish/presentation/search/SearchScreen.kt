package com.example.stylish.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stylish.domain.viewModel.SharedViewModel
import com.example.stylish.presentation.search.component.SearchBarM3

@Composable
fun SearchScreen(
    paddingValues: PaddingValues,
    sharedViewModel: SharedViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBarM3()
        val listState = rememberLazyListState()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            state = listState,
            contentPadding = PaddingValues(16.dp)
        ) {
            items(sharedViewModel.categoryWomen.value) { category ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    category.content?.title?.let { Text(text = it, style = LocalTextStyle.current.copy(fontSize = 32.sp)) }
                }
            }
        }
    }
}