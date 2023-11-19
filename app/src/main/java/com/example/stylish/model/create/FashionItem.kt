package com.example.stylish.model.create

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class FashionItem(
    val name: String,

    private val _isOpen: MutableState<Boolean> = mutableStateOf(false),
    val isOpen: State<Boolean> = _isOpen,

    private val _color: MutableState<Color> = mutableStateOf(Color.White),
    val color: State<Color> = _color,

    private val _initialColor: MutableState<Color> = mutableStateOf(Color.White),
    val initialColor: State<Color> = _initialColor
) {
    fun setOpen(isOpen: Boolean) {
        _isOpen.value = isOpen
    }

    fun setColor(color: Color) {
        _color.value = color
    }

    fun setInitialColor(color: Color) {
        _initialColor.value = color
    }
}
