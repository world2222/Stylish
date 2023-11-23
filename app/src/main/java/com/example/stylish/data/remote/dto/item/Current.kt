package com.example.stylish.data.remote.dto.item


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Current (
    val value: Double? = null,
    val text: String
)