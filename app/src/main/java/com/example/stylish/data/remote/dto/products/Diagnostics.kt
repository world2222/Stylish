package com.example.stylish.data.remote.dto.products


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Diagnostics(
    @SerialName("requestId")
    val requestId: String,
    @SerialName("processingTime")
    val processingTime: Int,
    @SerialName("queryTime")
    val queryTime: Int,
    @SerialName("recommendationsEnabled")
    val recommendationsEnabled: Boolean,
    @SerialName("recommendationsAnalytics")
    val recommendationsAnalytics: RecommendationsAnalytics,
    @SerialName("advertisementsEnabled")
    val advertisementsEnabled: Boolean,
    @SerialName("advertisementsAnalytics")
    val advertisementsAnalytics: AdvertisementsAnalytics
)