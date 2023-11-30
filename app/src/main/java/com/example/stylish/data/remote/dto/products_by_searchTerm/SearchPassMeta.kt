package com.example.stylish.data.remote.dto.products_by_searchTerm


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class SearchPassMeta(
    @SerialName("isPartial")
    val isPartial: Boolean,
    @SerialName("isSpellcheck")
    val isSpellcheck: Boolean,
    @SerialName("searchPass")
    val searchPass: List<SearchPass>,
    @SerialName("alternateSearchTerms")
    val alternateSearchTerms: JsonArray
)