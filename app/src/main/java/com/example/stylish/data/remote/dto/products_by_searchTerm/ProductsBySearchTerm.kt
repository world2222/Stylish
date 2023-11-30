package com.example.stylish.data.remote.dto.products_by_searchTerm


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsBySearchTerm(
    @SerialName("status")
    val status: Boolean? = null,
    @SerialName("timestamp")
    val timestamp: Long? = null,
    @SerialName("data")
    val data: Data? = null
)