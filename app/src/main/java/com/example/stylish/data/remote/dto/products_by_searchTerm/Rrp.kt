package com.example.stylish.data.remote.dto.products_by_searchTerm


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