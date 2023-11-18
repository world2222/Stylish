package com.example.stylish.ui.screens.create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stylish.ui.screens.create.component.ColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateScreen(
    paddingValues: PaddingValues,
    viewModel: CreateViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(viewModel.getColor(ItemNames.Shirt.name) ?: Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            FilledTonalButton(
                onClick = { viewModel.openDialog(ItemNames.Shirt.name) }
            ) {
                Text(text = "Color")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(viewModel.getColor(ItemNames.Pants.name) ?: Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            FilledTonalButton(
                onClick = { viewModel.openDialog(ItemNames.Pants.name) }
            ) {
                Text(text = "Color")
            }
        }
    }

    viewModel.items.forEach {
        if (viewModel.getIsOpen(it.name) == true) {
            val controller = rememberColorPickerController()
            AlertDialog(
                onDismissRequest = {
                    viewModel.closeDialog(it.name)
                    viewModel.setInitialColor(it.name, viewModel.getColor(it.name) ?: Color.White)
                }
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ColorPicker(controller = controller, item = it)
                }
            }
        }
    }
}