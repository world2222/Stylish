package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Current(
    @SerialName("value")
    val value: Float,
    @SerialName("text")
    val text: String,
    @SerialName("versionId")
    val versionId: String,
    @SerialName("conversionId")
    val conversionId: String
)