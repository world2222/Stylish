package com.example.stylish.model.create

sealed class ItemNames(val name: String) {
    data object Shirt : ItemNames(name = "Shirt")
    data object Jacket : ItemNames(name = "Jacket")
    data object Pants : ItemNames(name = "Pants")
}
