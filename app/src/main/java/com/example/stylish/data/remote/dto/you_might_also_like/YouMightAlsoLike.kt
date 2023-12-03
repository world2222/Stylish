package com.example.stylish.data.remote.dto.you_might_also_like


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class YouMightAlsoLike(
    @SerialName("status")
    val status: Boolean? = null,
    @SerialName("timestamp")
    val timestamp: Long? = null,
    @SerialName("data")
    val `data`: List<DataYouMightAlsoLike>? = listOf()
)