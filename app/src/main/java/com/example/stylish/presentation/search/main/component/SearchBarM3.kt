package com.example.stylish.presentation.search.main.component

import android.text.method.LinkMovementMethod
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stylish.data.local.History
import com.example.stylish.data.local.viewModel.HistoryViewModel
import com.example.stylish.presentation.search.main.SearchMainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarM3(
    viewModel: SearchMainViewModel = hiltViewModel(),
    dbViewModel: HistoryViewModel = hiltViewModel()
) {
    SearchBar(
        query = viewModel.getQuery(),
        onQueryChange = { viewModel.setQuery(it) },
        onSearch = {
            dbViewModel.addHistory(
                history = History(viewModel.getQuery())
            )
            viewModel.toggleActive()
        },
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
        dbViewModel.getAllHistories()?.forEach {
            Row(modifier = Modifier.padding(16.dp)) {
                Icon(
                    modifier = Modifier.padding(end = 10.dp),
                    imageVector = Icons.Default.History,
                    contentDescription = "History Icon"
                )
                Text(text = it.keyword)
            }
        }
    }
}