package com.example.stylish.data.remote.dto.products


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Previous(
    @SerialName("value")
    val value: Int? = null,
    @SerialName("text")
    val text: String
)