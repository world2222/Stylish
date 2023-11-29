package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Catwalk(
    @SerialName("url")
    val url: String? = null,
    @SerialName("colourWayId")
    val colourWayId: Int? = null,
    @SerialName("colourCode")
    val colourCode: String? = null
)