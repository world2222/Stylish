package com.example.stylish.data.remote.dto.detail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement

@Serializable
data class Data(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("alternateNames")
    val alternateNames: List<AlternateName>? = null,
    @SerialName("localisedData")
    val localisedData: List<LocalisedData>? = null,
    @SerialName("gender")
    val gender: String? = null,
    @SerialName("productCode")
    val productCode: String? = null,
    @SerialName("pdpLayout")
    val pdpLayout: String? = null,
    @SerialName("brand")
    val brand: Brand? = null,
    @SerialName("sizeGuide")
    val sizeGuide: JsonElement? = null,
    @SerialName("sizeGuideApiUrl")
    val sizeGuideApiUrl: JsonElement? = null,
    @SerialName("isNoSize")
    val isNoSize: Boolean? = null,
    @SerialName("isOneSize")
    val isOneSize: Boolean? = null,
    @SerialName("isInStock")
    val isInStock: Boolean? = null,
    @SerialName("countryOfManufacture")
    val countryOfManufacture: JsonElement? = null,
    @SerialName("hasVariantsWithProp65Risk")
    val hasVariantsWithProp65Risk: Boolean? = null,
    @SerialName("webCategories")
    val webCategories: JsonArray? = null,
    @SerialName("variants")
    val variants: List<Variant>? = null,
    @SerialName("media")
    val media: Media? = null,
    @SerialName("badges")
    val badges: JsonArray? = null,
    @SerialName("info")
    val info: Info? = null,
    @SerialName("associatedProductGroups")
    val associatedProductGroups: JsonArray? = null,
    @SerialName("shippingRestriction")
    val shippingRestriction: JsonElement? = null,
    @SerialName("price")
    val price: Price? = null,
    @SerialName("isDeadProduct")
    val isDeadProduct: Boolean? = null,
    @SerialName("rating")
    val rating: JsonElement? = null,
    @SerialName("productType")
    val productType: ProductType? = null,
    @SerialName("plpIds")
    val plpIds: List<PlpId>? = null
)