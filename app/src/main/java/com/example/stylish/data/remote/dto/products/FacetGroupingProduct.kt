package com.example.stylish.data.remote.dto.products


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FacetGroupingProduct(
    @SerialName("productId")
    val productId: Int
)