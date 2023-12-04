package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class Media(
    @SerialName("images")
    val images: List<Image>,
    @SerialName("catwalk")
    val catwalk: List<Catwalk>,
    @SerialName("spinset")
    val spinset: JsonArray,
    @SerialName("swatchSprite")
    val swatchSprite: JsonArray
)