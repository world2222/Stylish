package com.example.stylish.ui.screens.create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            .background(viewModel.shirtColor.value),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FilledTonalButton(
            onClick = { viewModel.openDialog() }
        ) {
            Text(text = "Color")
        }
    }

    if (viewModel.isOpen.value) {
        val controller = rememberColorPickerController()
        AlertDialog(
            onDismissRequest = { viewModel.closeDialog() }
        ) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                ColorPicker(controller = controller)
            }
        }
        println("Out of the alertdialog")
    }
}