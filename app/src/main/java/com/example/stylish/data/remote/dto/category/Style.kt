package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.Serializable

@Serializable
data class Style (
    val webLargeStyleType: EStyleType? = null,
    val mobileStyleType: EStyleType? = null
)
