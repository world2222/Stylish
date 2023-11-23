package com.example.stylish.data.remote.dto.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Currency(val value: String) {
    @SerialName("USD") Usd("USD");
}

@Serializable
enum class ProductType(val value: String) {
    @SerialName("Product") Product("Product");
}