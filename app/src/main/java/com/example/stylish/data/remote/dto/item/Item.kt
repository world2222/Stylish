package com.example.stylish.data.remote.dto.item


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement

@Serializable
data class Item (
    val searchTerm: String? = null,
    val categoryName: String? = null,
    val itemCount: Long? = null,

    @SerialName("redirectUrl")
    val redirectURL: String? = null,

    val products: List<Product>? = null,
    val facets: List<Facet>? = null,
    val diagnostics: Diagnostics? = null,
    val searchPassMeta: SearchPassMeta? = null,

    @SerialName("queryId")
    val queryID: JsonElement? = null,

    val discoverSearchProductTypes: JsonArray? = null
)