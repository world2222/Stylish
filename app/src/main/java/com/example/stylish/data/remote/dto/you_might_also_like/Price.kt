package com.example.stylish.data.remote.dto.you_might_also_like


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Price(
    @SerialName("current")
    val current: Current,
    @SerialName("previous")
    val previous: Previous? = null,
    @SerialName("rrp")
    val rrp: JsonElement? = null,
    @SerialName("isMarkedDown")
    val isMarkedDown: Boolean,
    @SerialName("isOutletPrice")
    val isOutletPrice: Boolean,
    @SerialName("currency")
    val currency: String
)