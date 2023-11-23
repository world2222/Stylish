package com.example.stylish.data.remote.dto.item


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Product (
    val id: Long,
    val name: String,
    val price: Price,
    val colour: String,

    @SerialName("colourWayId")
    val colourWayID: Long,

    val brandName: String,
    val hasVariantColours: Boolean,
    val hasMultiplePrices: Boolean,

    @SerialName("groupId")
    val groupID: JsonElement? = null,

    val productCode: Long,
    val productType: ProductType? = null,
    val url: String,

    @SerialName("imageUrl")
    val imageURL: String,
)