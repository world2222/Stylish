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

    val items = listOf(
        FashionItem(name = ItemNames.Shirt.name),
        FashionItem(name = ItemNames.Jacket.name),
        FashionItem(name = ItemNames.Pants.name)
    )

    private fun findItem(itemName: String): FashionItem? {
        return items.find { it.name == itemName }
    }

    fun getInitialColor(itemName: String): Color? {
        return findItem(itemName)?.initialColor?.value
    }

    fun setInitialColor(itemName: String, color: Color) {
        findItem(itemName)?.setInitialColor(color)
    }

    fun getColor(itemName: String): Color? {
        return findItem(itemName)?.color?.value
    }

    fun setColor(itemName: String, hexCode: String) {
        findItem(itemName)?.setColor(Color(android.graphics.Color.parseColor("#$hexCode")))
    }

    fun getIsOpen(itemName: String): Boolean? {
        return findItem(itemName)?.isOpen?.value
    }

    fun openDialog(itemName: String) {
        findItem(itemName)?.setOpen(true)
    }

    fun closeDialog(itemName: String) {
        findItem(itemName)?.setOpen(false)
    }
}

data class FashionItem(
    val name: String,

    private val _isOpen: MutableState<Boolean> = mutableStateOf(false),
    val isOpen: State<Boolean> = _isOpen,

    private val _color: MutableState<Color> = mutableStateOf<Color>(Color.White),
    val color: State<Color> = _color,

    private val _initialColor: MutableState<Color> = mutableStateOf<Color>(Color.White),
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

sealed class ItemNames(val name: String) {
    data object Shirt : ItemNames(name = "Shirt")
    data object Jacket : ItemNames(name = "Jacket")
    data object Pants : ItemNames(name = "Pants")
}