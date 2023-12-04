package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Price(
    @SerialName("current")
    val current: Current,
    @SerialName("previous")
    val previous: Previous,
    @SerialName("rrp")
    val rrp: Rrp,
    @SerialName("xrp")
    val xrp: Xrp,
    @SerialName("currency")
    val currency: String,
    @SerialName("isMarkedDown")
    val isMarkedDown: Boolean,
    @SerialName("isOutletPrice")
    val isOutletPrice: Boolean,
    @SerialName("startDateTime")
    val startDateTime: String,
    @SerialName("previousEndDate")
    val previousEndDate: JsonElement? = null,
    @SerialName("lowestPriceInLast30DaysValue")
    val lowestPriceInLast30DaysValue: JsonElement? = null,
    @SerialName("lowestPriceInLast30DaysText")
    val lowestPriceInLast30DaysText: JsonElement? = null,
    @SerialName("lowestPriceInLast30DaysEndDate")
    val lowestPriceInLast30DaysEndDate: JsonElement? = null,
    @SerialName("lowestPriceInLast30DaysPercentage")
    val lowestPriceInLast30DaysPercentage: JsonElement? = null,
    @SerialName("wasPriceStartDate")
    val wasPriceStartDate: JsonElement? = null
)