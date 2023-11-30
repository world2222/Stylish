package com.example.stylish.data.remote.dto.products_by_categoryId


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class AdvertisementsAnalytics(
    @SerialName("status")
    val status: Int,
    @SerialName("customerOptIn")
    val customerOptIn: Boolean,
    @SerialName("numberOfItemsFromPartner")
    val numberOfItemsFromPartner: Int,
    @SerialName("items")
    val items: JsonArray,
    @SerialName("itemsFromPartner")
    val itemsFromPartner: JsonArray,
    @SerialName("placementBeacons")
    val placementBeacons: PlacementBeacons
)