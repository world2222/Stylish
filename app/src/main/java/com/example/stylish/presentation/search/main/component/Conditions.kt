package com.example.stylish.presentation.search.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stylish.presentation.search.main.SearchMainViewModel
import com.example.stylish.presentation.search.main.SortType

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Conditions(
    viewModel: SearchMainViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        FlowRow(
            verticalArrangement = Arrangement.Bottom
        ) {
            // None
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = viewModel.sortType.value == SortType.None.type,
                    onClick = { viewModel.setSortType(SortType.None.type) }
                )
                Text(text = "None")
            }

            // Ascending order
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = viewModel.sortType.value == SortType.Asc.type,
                    onClick = { viewModel.setSortType(SortType.Asc.type) }
                )
                Text(text = "Ascending")
            }

            // Descending order
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = viewModel.sortType.value == SortType.Dsc.type,
                    onClick = { viewModel.setSortType(SortType.Dsc.type) }
                )
                Text(text = "Descending")
            }

            // Sort by recommended
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = viewModel.sortType.value == SortType.Rec.type,
                    onClick = { viewModel.setSortType(SortType.Rec.type) }
                )
                Text(text = "Recommended")
            }

            // Sort by freshness
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = viewModel.sortType.value == SortType.New.type,
                    onClick = { viewModel.setSortType(SortType.New.type) }
                )
                Text(text = "Freshness")
            }
        }


        val focusRequester = remember { FocusRequester() }
        Column(
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
        ) {
            Text(text = "Price Range($)")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    modifier = Modifier
                        .width(150.dp)
                        .focusRequester(focusRequester),
                    value = viewModel.minPrice.value,
                    onValueChange = {
                        if (it.isDigitsOnly()) {
                            viewModel.setMinPrice(it)
                        }
                    },
                    label = { Text(text = "Minimum") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true
                )

                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = "~",
                    fontSize = 25.sp
                )

                TextField(
                    modifier = Modifier.width(150.dp),
                    value = viewModel.maxPrice.value,
                    onValueChange = {
                        if (it.isDigitsOnly()) {
                            viewModel.setMaxPrice(it)
                        }
                    },
                    label = { Text(text = "Maximum") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        )
    }
}