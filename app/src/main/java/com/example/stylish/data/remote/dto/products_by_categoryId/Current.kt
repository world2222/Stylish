package com.example.stylish.data.remote.dto.products_by_categoryId


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Current(
    @SerialName("value")
    val value: Double,
    @SerialName("text")
    val text: String
)