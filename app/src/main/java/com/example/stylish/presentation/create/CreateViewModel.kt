package com.example.stylish.presentation.create

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.stylish.domain.model.create.FashionItem
import com.example.stylish.domain.model.create.ItemNames
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