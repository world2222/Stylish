package com.example.stylish.data.remote.dto.products


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Rrp(
    @SerialName("value")
    val value: JsonElement? = null,
    @SerialName("text")
    val text: String
)