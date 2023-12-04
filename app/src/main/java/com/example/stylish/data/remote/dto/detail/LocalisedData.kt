package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocalisedData(
    @SerialName("locale")
    val locale: String,
    @SerialName("title")
    val title: String,
    @SerialName("pdpUrl")
    val pdpUrl: String
)