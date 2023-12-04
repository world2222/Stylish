package com.example.stylish.data.remote.dto.products_by_searchTerm


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class Data(
    @SerialName("searchTerm")
    val searchTerm: String,
    @SerialName("categoryName")
    val categoryName: String? = null,
    @SerialName("itemCount")
    val itemCount: Int,
    @SerialName("redirectUrl")
    val redirectUrl: String,
    @SerialName("products")
    val products: List<Product>,
    @SerialName("facets")
    val facets: List<Facet>,
    @SerialName("diagnostics")
    val diagnostics: Diagnostics,
    @SerialName("searchPassMeta")
    val searchPassMeta: SearchPassMeta,
    @SerialName("queryId")
    val queryId: Int? = null,
    @SerialName("discoverSearchProductTypes")
    val discoverSearchProductTypes: JsonArray,
    @SerialName("campaigns")
    val campaigns: Campaigns
)