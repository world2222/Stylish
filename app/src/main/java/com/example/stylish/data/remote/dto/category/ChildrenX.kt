package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChildrenX(
    @SerialName("categoryId")
    val categoryId: Int ,
    @SerialName("title")
    val title: String
)