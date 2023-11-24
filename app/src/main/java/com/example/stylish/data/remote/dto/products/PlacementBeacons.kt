package com.example.stylish.data.remote.dto.products


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class PlacementBeacons(
    @SerialName("onLoadBeacon")
    val onLoadBeacon: JsonElement? = null,
    @SerialName("onViewBeacon")
    val onViewBeacon: JsonElement? = null
)