package com.example.stylish.ui.screens.create

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(

) : ViewModel() {

    val items = listOf(
        FashionItem(
            name = ItemNames.Shirt.name,
            isOpen = mutableStateOf(false),
            color = mutableStateOf(Color.White),
            initialColor = mutableStateOf(Color.White)
        ),
        FashionItem(
            name = ItemNames.Jacket.name,
            isOpen = mutableStateOf(false),
            color = mutableStateOf(Color.White),
            initialColor = mutableStateOf(Color.White)
        ),
        FashionItem(
            name = ItemNames.Pants.name,
            isOpen = mutableStateOf(false),
            color = mutableStateOf(Color.White),
            initialColor = mutableStateOf(Color.White)
        )
    )

    fun getInitialColor(itemName: String): Color {
        return items.find { it.name == itemName }!!.initialColor.value
    }

    fun setInitialColor(itemName: String, color: Color) {
        items.find { it.name == itemName }!!.initialColor.value = color
    }

    fun getColor(itemName: String): Color {
        return items.find { it.name == itemName }!!.color.value
    }

    fun setColor(itemName: String, hexCode: String) {
        items.find { it.name == itemName }!!.color.value =
            Color(android.graphics.Color.parseColor("#$hexCode"))
    }

    fun getIsOpen(itemName: String): Boolean {
        return items.find { it.name == itemName }!!.isOpen.value
    }

    fun openDialog(itemName: String) {
        items.find { it.name == itemName }!!.isOpen.value = true
    }

    fun closeDialog(itemName: String) {
        items.find { it.name == itemName }!!.isOpen.value = false
    }
}

data class FashionItem(
    val name: String,
    val isOpen: MutableState<Boolean>,
    val color: MutableState<Color>,
    val initialColor: MutableState<Color>
)

sealed class ItemNames(val name: String) {
    data object Shirt : ItemNames(name = "Shirt")
    data object Jacket : ItemNames(name = "Jacket")
    data object Pants : ItemNames(name = "Pants")
}