package com.example.stylish.data.remote.dto.item


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class SearchPassMeta (
    val isPartial: Boolean,
    val isSpellcheck: Boolean,
    val searchPass: JsonArray,
    val alternateSearchTerms: JsonArray
)
