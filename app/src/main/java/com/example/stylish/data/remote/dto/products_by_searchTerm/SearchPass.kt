package com.example.stylish.data.remote.dto.products_by_searchTerm


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchPass(
    @SerialName("name")
    val name: String,
    @SerialName("numberOfResults")
    val numberOfResults: Int
)