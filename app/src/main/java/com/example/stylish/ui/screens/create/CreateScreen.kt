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
                .background(viewModel.items[0].color.value),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            FilledTonalButton(
                onClick = { viewModel.openDialog() }
            ) {
                Text(text = "Color")
            }
        }
        Row(
            modifier = Modifier.fillMaxSize()
                .background(Color.Gray)
        ) {
            FilledTonalButton(
                onClick = { viewModel.openDialog() }
            ) {
                Text(text = "Color")
            }
        }
    }

    if (viewModel.isOpen.value) {
        val controller = rememberColorPickerController()
        AlertDialog(
            onDismissRequest = {
                viewModel.closeDialog()
                viewModel.initialColor.value = viewModel.shirtColor.value
            }
        ) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                ColorPicker(controller = controller)
            }
        }
    }
}