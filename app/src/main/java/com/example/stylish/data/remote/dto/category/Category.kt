package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    @SerialName("status")
    val status: Boolean? = null,
    @SerialName("timestamp")
    val timestamp: Long? = null,
    @SerialName("data")
    val data: Data? = null
)