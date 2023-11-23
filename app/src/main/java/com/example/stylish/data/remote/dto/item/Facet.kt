package com.example.stylish.data.remote.dto.item


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Facet (
    val id: String,
    val name: String,
    val facetValues: List<FacetValue>,
    val displayStyle: String,
    val facetType: String,
    val hasSelectedValues: Boolean
)