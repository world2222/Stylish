package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("url")
    val url: String,
    @SerialName("type")
    val type: String,
    @SerialName("colourWayId")
    val colourWayId: Long? = null,
    @SerialName("colourCode")
    val colourCode: String,
    @SerialName("colour")
    val colour: String,
    @SerialName("isPrimary")
    val isPrimary: Boolean
)