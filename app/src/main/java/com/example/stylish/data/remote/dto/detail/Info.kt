package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Info(
    @SerialName("aboutMe")
    val aboutMe: String? = null,
    @SerialName("sizeAndFit")
    val sizeAndFit: String? = null,
    @SerialName("careInfo")
    val careInfo: String? = null
)