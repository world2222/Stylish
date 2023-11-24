package com.example.stylish.data.remote.dto.products


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FacetValue(
    @SerialName("count")
    val count: Int,
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("isSelected")
    val isSelected: Boolean
)