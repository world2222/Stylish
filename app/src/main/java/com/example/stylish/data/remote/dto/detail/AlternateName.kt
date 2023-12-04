package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlternateName(
    @SerialName("locale")
    val locale: String,
    @SerialName("title")
    val title: String
)