package com.example.stylish.data.remote.dto.item


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FacetValue (
    val count: Long,
    val id: String,
    val name: String,
    val isSelected: Boolean
)