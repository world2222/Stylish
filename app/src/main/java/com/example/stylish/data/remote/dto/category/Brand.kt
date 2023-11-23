package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.Serializable

@Serializable
data class Brand (
    val id: String,
    val alias: String? = null,
    val type: Type,
    val channelExclusions: List<ChannelExclusion>,
    val webLargePriority: Long,
    val content: Content,
    val display: Display? = null,
    val style: Style,
    val link: Link? = null,
    val children: List<Brand>
)