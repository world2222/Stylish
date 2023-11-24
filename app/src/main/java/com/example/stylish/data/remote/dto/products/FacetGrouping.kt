package com.example.stylish.data.remote.dto.products


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FacetGrouping(
    @SerialName("products")
    val products: List<FacetGroupingProduct>,
    @SerialName("type")
    val type: String
)