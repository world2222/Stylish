package com.example.stylish.data.remote.dto.products_by_searchTerm


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Facet(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("facetValues")
    val facetValues: List<FacetValue>,
    @SerialName("displayStyle")
    val displayStyle: String,
    @SerialName("facetType")
    val facetType: String,
    @SerialName("hasSelectedValues")
    val hasSelectedValues: Boolean
)