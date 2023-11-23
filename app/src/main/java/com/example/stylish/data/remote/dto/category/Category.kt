package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.Serializable

@Serializable
data class Category (
    val navigation: List<Brand>? = null,
    val brands: List<Brand>? = null,
    val footer: List<Brand>? = null
)