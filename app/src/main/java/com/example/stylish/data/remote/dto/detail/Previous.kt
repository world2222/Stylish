package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Previous(
    @SerialName("value")
    val value: Int,
    @SerialName("text")
    val text: String,
    @SerialName("versionId")
    val versionId: String,
    @SerialName("conversionId")
    val conversionId: String
)