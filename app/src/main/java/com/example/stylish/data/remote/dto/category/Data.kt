package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("Men")
    val men: Men,
    @SerialName("Women")
    val women: Women
)