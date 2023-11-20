package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClothDetail(
    @SerialName("additionalImageUrls")
    val additionalImageUrls: List<String>,
    @SerialName("advertisement")
    val advertisement: String? = null,
    @SerialName("brandName")
    val brandName: String,
    @SerialName("colour")
    val colour: String,
    @SerialName("colourWayId")
    val colourWayId: Int,
    @SerialName("facetGroupings")
    val facetGroupings: List<String> ?= null,
    @SerialName("groupId")
    val groupId: Int? = null,
    @SerialName("hasMultiplePrices")
    val hasMultiplePrices: Boolean,
    @SerialName("hasVariantColours")
    val hasVariantColours: Boolean,
    @SerialName("id")
    val id: Int,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("isSellingFast")
    val isSellingFast: Boolean,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Price,
    @SerialName("productCode")
    val productCode: Int,
    @SerialName("productType")
    val productType: String,
    @SerialName("showVideo")
    val showVideo: Boolean,
    @SerialName("sponsoredCampaignId")
    val sponsoredCampaignId: Int? = null,
    @SerialName("url")
    val url: String,
    @SerialName("videoUrl")
    val videoUrl: String? = null
)