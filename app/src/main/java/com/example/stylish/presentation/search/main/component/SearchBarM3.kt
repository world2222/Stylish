package com.example.stylish.presentation.search.main.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stylish.data.local.historyDatabase.History
import com.example.stylish.data.local.viewModel.HistoryViewModel
import com.example.stylish.presentation.search.main.SearchMainViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun SearchBarM3(
    viewModel: SearchMainViewModel = hiltViewModel(),
    dbViewModel: HistoryViewModel = hiltViewModel()
) {
    SearchBar(
        query = viewModel.query.value,
        onQueryChange = { viewModel.setQuery(it) },
        onSearch = {
            dbViewModel.addHistory(
                history = History(viewModel.query.value)
            )
            viewModel.toggleActive()
        },
        active = viewModel.active.value,
        onActiveChange = {
            viewModel.toggleActive()
        },
        placeholder = { Text(text = "Search your style!") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        trailingIcon = {
            if (viewModel.isActive()) {
                IconButton(onClick = {
                    if (viewModel.query.value.isEmpty())
                        viewModel.toggleActive()
                    else
                        viewModel.setQuery("")
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close"
                    )
                }
            }

            if (!viewModel.isActive() && viewModel.query.value.isNotEmpty()) {
                IconButton(onClick = {
                    viewModel.setQuery("")
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back to men and women"
                    )
                }
            }
        }
    ) {
        var openDialog by remember { mutableStateOf(false) }
        val histories by dbViewModel.historyList.observeAsState(initial = emptyList())
        var deletingHistory by remember { mutableStateOf(History(keyword = "")) }

        val listState = rememberLazyListState()

        // By using LaunchedEffect, you can prevent it renders LazyColumn before it gets data.
        LaunchedEffect(histories) {
            // By using if here, it waits until it gets data from the dbViewModel.
            if (histories.isNotEmpty()) {
                listState.animateScrollToItem(histories.size - 1)
            }
        }

        Conditions()

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            state = listState,
            reverseLayout = true
        ) {
            items(histories) { history ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .combinedClickable(
                            onClick = {
                                viewModel.setQuery(history.keyword)
                                viewModel.toggleActive()
                                histories
                                    .find { it.keyword == history.keyword }
                                    ?.let { dbViewModel.deleteHistory(it) }
                                dbViewModel.addHistory(History(history.keyword))
                            },
                            onLongClick = {
                                openDialog = true
                                deletingHistory = history
                            },
                        )
                        .padding(16.dp)
                ) {
                    Icon(
                        modifier = Modifier.padding(end = 16.dp),
                        imageVector = Icons.Default.History,
                        contentDescription = "History Icon"
                    )
                    Text(text = history.keyword)
                }
            }
        }
        if (openDialog) {
            AlertDialog(
                onDismissRequest = { openDialog = false },
                title = { Text(histories.find { it.id == deletingHistory.id }?.keyword?: "") },
                text = { Text("Remove from search history?") },
                confirmButton = {
                    TextButton(onClick = {
                        histories.find { it.id == deletingHistory.id }
                            ?.let { dbViewModel.deleteHistory(it) }
                        openDialog = false
                    }) {
                        Text("Remove".uppercase())
                    }
                },
                dismissButton = {
                    TextButton(onClick = { openDialog = false }) {
                        Text("Cancel".uppercase())
                    }
                },
            )
        }
    }
}