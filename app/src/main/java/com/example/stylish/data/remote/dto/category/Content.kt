package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Content(
    @SerialName("title")
    val title: String? = null,
    @SerialName("subTitle")
    val subTitle: String? = null,
    @SerialName("webLargeImageUrl")
    val webLargeImageUrl: String? = null,
    @SerialName("mobileImageUrl")
    val mobileImageUrl: String? = null
)