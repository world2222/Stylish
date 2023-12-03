package com.example.stylish.data.remote.dto.you_might_also_like


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Current(
    @SerialName("value")
    val value: Double,
    @SerialName("text")
    val text: String,
    @SerialName("priceType")
    val priceType: String
)