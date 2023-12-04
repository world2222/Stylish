package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    @SerialName("averageOverallRating")
    val averageOverallRating: Double,
    @SerialName("averageOverallStarRating")
    val averageOverallStarRating: Double,
    @SerialName("totalReviewCount")
    val totalReviewCount: Int
)