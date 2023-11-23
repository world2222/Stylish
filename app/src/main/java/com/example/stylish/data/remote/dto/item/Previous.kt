package com.example.stylish.data.remote.dto.item


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Previous(
    @SerialName("value")
    val value: Int?,
    @SerialName("text")
    val text: String?
)