package com.example.stylish.ui.screens.create

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(

) : ViewModel() {
    private val _isOpen = mutableStateOf(false)
    val isOpen: State<Boolean> = _isOpen    // This value will be used in CreateScreen.

    private val _shirtColor = mutableStateOf(Color.White)
    val shirtColor: State<Color> = _shirtColor

    private val _jacketColor = mutableStateOf(Color.White)
    val jacketColor: State<Color> = _jacketColor

    private val _pantsColor = mutableStateOf(Color.White)
    val pantsColor: State<Color> = _pantsColor

    var initialColor = mutableStateOf(Color.White)

    val items = listOf(
        FashionItem(
            name = "Shirt",
            color = mutableStateOf(Color.White),
            initialColor = mutableStateOf(Color.White)
        ),
        FashionItem(
            name = "Jacket",
            color = mutableStateOf(Color.White),
            initialColor = mutableStateOf(Color.White)
        ),
        FashionItem(
            name = "Pants",
            color = mutableStateOf(Color.White),
            initialColor = mutableStateOf(Color.White)
        )
    )

    fun setColor(itemName: String, hexCode: String) {
        items.find { it.name == itemName }?.color?.value =
            Color(android.graphics.Color.parseColor("#$hexCode"))
    }


    fun openDialog() {
        _isOpen.value = true
    }

    fun closeDialog() {
        _isOpen.value = false
    }

    fun setShirtColor(hexCode: String) {
        _shirtColor.value = Color(android.graphics.Color.parseColor("#$hexCode"))
    }

    fun setJacketColor(hexCode: String) {
        _jacketColor.value = Color(android.graphics.Color.parseColor("#$hexCode"))
    }

    fun setPantsColor(hexCode: String) {
        _pantsColor.value = Color(android.graphics.Color.parseColor("#$hexCode"))
    }
}

data class FashionItem(
    val name: String,
    val color: MutableState<Color>,
    var initialColor: MutableState<Color>
)