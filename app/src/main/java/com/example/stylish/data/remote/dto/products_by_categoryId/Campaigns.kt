package com.example.stylish.data.remote.dto.products_by_categoryId


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class Campaigns(
    @SerialName("imageTiles")
    val imageTiles: JsonArray,
    @SerialName("promoBanners")
    val promoBanners: JsonArray,
    @SerialName("sponsoredProducts")
    val sponsoredProducts: JsonArray
)