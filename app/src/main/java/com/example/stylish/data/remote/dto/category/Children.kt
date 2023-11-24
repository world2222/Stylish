package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Children(
    @SerialName("id")
    val id: String? = null,
    @SerialName("content")
    val content: Content? = null,
    @SerialName("link")
    val link: Link? = null,
    @SerialName("children")
    val children: List<Children>? = null
)