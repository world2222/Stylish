package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("brands")
    val brands: List<Brand>? = null,
    @SerialName("navigation")
    val navigation: List<Navigation>? = null,
    @SerialName("footer")
    val footer: List<Footer>? = null
)