package com.example.stylish.data.remote.dto.products_by_searchTerm


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Price(
    @SerialName("current")
    val current: Current,
    @SerialName("previous")
    val previous: Previous,
    @SerialName("rrp")
    val rrp: Rrp,
    @SerialName("isMarkedDown")
    val isMarkedDown: Boolean,
    @SerialName("isOutletPrice")
    val isOutletPrice: Boolean,
    @SerialName("currency")
    val currency: String
)