package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Link (
    val linkType: LinkType? = null,
    val brandSectionAlias: String? = null,

    @SerialName("categoryId")
    val categoryID: Long? = null,

    @SerialName("webUrl")
    val webURL: String? = null,

    @SerialName("appUrl")
    val appURL: String? = null
)