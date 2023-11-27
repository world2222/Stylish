package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductType(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)