package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Price(
    @SerialName("currency")
    val currency: String,
    @SerialName("current")
    val current: List<String>,
    @SerialName("isMarkedDown")
    val isMarkedDown: Boolean,
    @SerialName("isOutletPrice")
    val isOutletPrice: Boolean,
    @SerialName("previous")
    val previous: List<String>,
    @SerialName("rrp")
    val rrp: List<String>
)