package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Women(
    @SerialName("categoryId")
    val categoryId: Any,
    @SerialName("children")
    val children: List<Children>,
    @SerialName("title")
    val title: String
)