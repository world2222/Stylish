package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlpId(
    @SerialName("id")
    val id: Int,
    @SerialName("type")
    val type: String
)