package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Content (
    val title: String,
    val subTitle: String? = null,

    @SerialName("webLargeImageUrl")
    val webLargeImageURL: String? = null,

    @SerialName("mobileImageUrl")
    val mobileImageURL: String? = null
)