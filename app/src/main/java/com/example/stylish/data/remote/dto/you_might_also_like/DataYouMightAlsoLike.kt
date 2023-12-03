package com.example.stylish.data.remote.dto.you_might_also_like


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataYouMightAlsoLike(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("brandName")
    val brandName: String? = null,
    @SerialName("hasMultipleColoursInStock")
    val hasMultipleColoursInStock: Boolean? = false,
    @SerialName("hasMultiplePricesInStock")
    val hasMultiplePricesInStock: Boolean? = false,
    @SerialName("productCode")
    val productCode: Int? = null,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("price")
    val price: Price? = null,
    @SerialName("colourWayId")
    val colourWayId: Int? = null,
)