package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Children(
    @SerialName("categoryId")
    val categoryId: Any,
    @SerialName("children")
    val children: List<ChildrenX>,
    @SerialName("title")
    val title: String
)