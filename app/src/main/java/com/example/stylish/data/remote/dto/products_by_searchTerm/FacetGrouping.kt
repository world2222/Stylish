package com.example.stylish.data.remote.dto.products_by_searchTerm


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FacetGrouping(
    @SerialName("products")
    val products: List<FacetGroupingProduct>,
    @SerialName("type")
    val type: String
)