package com.example.stylish.presentation.create

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stylish.R
import com.example.stylish.model.create.ItemNames
import com.example.stylish.presentation.create.component.ColorPicker
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
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(viewModel.getColor(ItemNames.Shirt.name) ?: Color.White)
                    .clickable { viewModel.openDialog(ItemNames.Shirt.name) },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(45.dp))
                Image(
                    painter = painterResource(id = R.drawable.sweater),
                    contentDescription = "shirt"
                )
            }

        }

        Box(modifier = Modifier
            .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(viewModel.getColor(ItemNames.Pants.name) ?: Color.White)
                    .clickable { viewModel.openDialog(ItemNames.Pants.name) },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pants),
                    contentDescription = "shirt"
                )
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