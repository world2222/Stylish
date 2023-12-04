package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Brand(
    @SerialName("brandId")
    val brandId: Int,
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String? = null
)