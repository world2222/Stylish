package com.example.stylish.data.remote.dto.item


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class RecommendationsAnalytics (
    val personalisationStatus: Long,
    val numberOfItems: Long,
    val personalisationType: String,
    val items: JsonArray
)