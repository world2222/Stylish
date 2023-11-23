package com.example.stylish.data.remote.dto.item


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Price (
    val current: Current,
    val previous: Current,
    val rrp: Current,
    val isMarkedDown: Boolean,
    val isOutletPrice: Boolean,
    val currency: Currency
)