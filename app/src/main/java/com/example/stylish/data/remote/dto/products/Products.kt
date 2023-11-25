package com.example.stylish.data.remote.dto.products


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Products(
    @SerialName("status")
    val status: Boolean? = null,
    @SerialName("timestamp")
    val timestamp: Long? = null,
    @SerialName("data")
    val data: Data? = null
)