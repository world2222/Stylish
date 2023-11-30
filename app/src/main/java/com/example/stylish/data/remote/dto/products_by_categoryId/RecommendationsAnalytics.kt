package com.example.stylish.data.remote.dto.products_by_categoryId


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class RecommendationsAnalytics(
    @SerialName("personalisationStatus")
    val personalisationStatus: Int,
    @SerialName("numberOfItems")
    val numberOfItems: Int,
    @SerialName("numberOfRecs")
    val numberOfRecs: Int,
    @SerialName("personalisationType")
    val personalisationType: String,
    @SerialName("experimentTrackerkey")
    val experimentTrackerkey: String,
    @SerialName("items")
    val items: JsonArray
)