package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Info(
    @SerialName("aboutMe")
    val aboutMe: String,
    @SerialName("sizeAndFit")
    val sizeAndFit: JsonElement? = null,
    @SerialName("careInfo")
    val careInfo: String
)