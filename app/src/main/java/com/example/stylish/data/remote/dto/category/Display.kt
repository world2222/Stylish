package com.example.stylish.data.remote.dto.category


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Display (
    @SerialName("webLargeTemplateId")
    val webLargeTemplateID: Long,

    val webLargeTemplateName: WebLargeTemplateName,
    val webLargeColumnSpan: Long,

    @SerialName("mobileTemplateId")
    val mobileTemplateID: Long,

    val mobileTemplateName: MobileTemplateName,
    val mobileDisplayLayout: MobileDisplayLayout
)