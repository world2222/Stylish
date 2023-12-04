package com.example.stylish.data.remote.dto.products_by_categoryId


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Previous(
    @SerialName("value")
    val value: Float? = null,
    @SerialName("text")
    val text: String
)