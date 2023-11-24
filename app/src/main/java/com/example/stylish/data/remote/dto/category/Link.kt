package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Link(
    @SerialName("linkType")
    val linkType: String? = null,
    @SerialName("categoryId")
    val categoryId: Int? = null
)