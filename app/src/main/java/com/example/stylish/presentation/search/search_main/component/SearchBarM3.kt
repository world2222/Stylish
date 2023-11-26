package com.example.stylish.presentation.search.search_main.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stylish.presentation.search.search_main.SearchMainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarM3(
    viewModel: SearchMainViewModel = hiltViewModel()
) {
    SearchBar(
        query = viewModel.getQuery(),
        onQueryChange = { viewModel.setQuery(it) },
        onSearch = { },
        active = viewModel.isActive(),
        onActiveChange = { viewModel.toggleActive() },
        placeholder = { Text(text = "Search your style!") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        trailingIcon = {
            if (viewModel.isActive()) {
                IconButton(onClick = {
                    if (viewModel.getQuery().isNotEmpty())
                        viewModel.setQuery("")
                    else
                        viewModel.toggleActive()
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close"
                    )
                }
            }
        }
    ) {

    }
}