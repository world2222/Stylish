package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Variant(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("sizeId")
    val sizeId: Int,
    @SerialName("brandSize")
    val brandSize: String,
    @SerialName("sizeDescription")
    val sizeDescription: String,
    @SerialName("displaySizeText")
    val displaySizeText: String,
    @SerialName("sizeOrder")
    val sizeOrder: Int,
    @SerialName("sku")
    val sku: String,
    @SerialName("isLowInStock")
    val isLowInStock: Boolean,
    @SerialName("isInStock")
    val isInStock: Boolean,
    @SerialName("isAvailable")
    val isAvailable: Boolean,
    @SerialName("colourWayId")
    val colourWayId: Int,
    @SerialName("colourCode")
    val colourCode: JsonElement? = null,
    @SerialName("colour")
    val colour: String,
    @SerialName("price")
    val price: Price,
    @SerialName("isPrimary")
    val isPrimary: Boolean,
    @SerialName("isProp65Risk")
    val isProp65Risk: Boolean,
    @SerialName("ean")
    val ean: String,
    @SerialName("seller")
    val seller: JsonElement? = null
)