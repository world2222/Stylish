package com.example.stylish.ui.screens.create.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stylish.ui.screens.create.CreateViewModel
import com.github.skydoves.colorpicker.compose.AlphaSlider
import com.github.skydoves.colorpicker.compose.AlphaTile
import com.github.skydoves.colorpicker.compose.BrightnessSlider
import com.github.skydoves.colorpicker.compose.ColorPickerController
import com.github.skydoves.colorpicker.compose.HsvColorPicker

@Composable
fun ColorPicker(
    viewModel: CreateViewModel = hiltViewModel(),
    controller: ColorPickerController
) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            AlphaTile(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(6.dp)),
                controller = controller
            )
        }
        HsvColorPicker(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(10.dp),
            controller = controller,
            initialColor = viewModel.initialColor.value,
            onColorChanged = {
                // do something
                viewModel.setShirtColor(it.hexCode)
            }
        )
        AlphaSlider(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(10.dp),
            controller = controller
        )
        BrightnessSlider(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(10.dp),
            controller = controller
        )
    }
}