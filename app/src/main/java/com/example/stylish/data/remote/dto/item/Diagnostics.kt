package com.example.stylish.data.remote.dto.item


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Diagnostics (
    @SerialName("requestId")
    val requestID: String,

    val processingTime: Long,
    val queryTime: Long,
    val recommendationsEnabled: Boolean,
    val recommendationsAnalytics: RecommendationsAnalytics
)