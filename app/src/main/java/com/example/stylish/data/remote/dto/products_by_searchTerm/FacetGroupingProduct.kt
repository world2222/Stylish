package com.example.stylish.data.remote.dto.products_by_searchTerm


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FacetGroupingProduct(
    @SerialName("productId")
    val productId: Int
)