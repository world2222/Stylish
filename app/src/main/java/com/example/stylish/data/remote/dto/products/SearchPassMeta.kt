package com.example.stylish.data.remote.dto.products


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
    val searchPass: JsonArray,
    @SerialName("alternateSearchTerms")
    val alternateSearchTerms: JsonArray
)