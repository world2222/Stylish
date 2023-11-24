package com.example.stylish.data.remote.dto.products


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Product(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Price,
    @SerialName("colour")
    val colour: String,
    @SerialName("colourWayId")
    val colourWayId: Int,
    @SerialName("brandName")
    val brandName: String,
    @SerialName("hasVariantColours")
    val hasVariantColours: Boolean,
    @SerialName("hasMultiplePrices")
    val hasMultiplePrices: Boolean,
    @SerialName("groupId")
    val groupId: JsonElement? = null,
    @SerialName("productCode")
    val productCode: Int,
    @SerialName("productType")
    val productType: String,
    @SerialName("url")
    val url: String,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("additionalImageUrls")
    val additionalImageUrls: List<String>,
    @SerialName("videoUrl")
    val videoUrl: JsonElement? = null,
    @SerialName("showVideo")
    val showVideo: Boolean,
    @SerialName("isSellingFast")
    val isSellingFast: Boolean,
    @SerialName("sponsoredCampaignId")
    val sponsoredCampaignId: JsonElement? = null,
    @SerialName("facetGroupings")
    val facetGroupings: List<FacetGrouping>,
    @SerialName("advertisement")
    val advertisement: JsonElement? = null
)