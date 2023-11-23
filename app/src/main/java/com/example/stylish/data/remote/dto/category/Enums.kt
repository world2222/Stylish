package com.example.stylish.data.remote.dto.category

// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json     = Json { allowStructuredMapKeys = true }
// val category = json.parse(Category.serializer(), jsonString)

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
enum class ChannelExclusion(val value: String) {
    @SerialName("apps") Apps("apps"),
    @SerialName("webLarge") WebLarge("webLarge"),
    @SerialName("webSmall") WebSmall("webSmall");
}

@Serializable
enum class MobileDisplayLayout(val value: String) {
    @SerialName("carousel") Carousel("carousel"),
    @SerialName("list") MobileDisplayLayoutList("list");
}

@Serializable
enum class MobileTemplateName(val value: String) {
    @SerialName("circleImageList") CircleImageList("circleImageList"),
    @SerialName("circleImageRight") CircleImageRight("circleImageRight"),
    @SerialName("") Empty(""),
    @SerialName("homepageLinks") HomepageLinks("homepageLinks"),
    @SerialName("imageBackground") ImageBackground("imageBackground"),
    @SerialName("imageCardsWithDescription") ImageCardsWithDescription("imageCardsWithDescription"),
    @SerialName("imageTileWithTitle") ImageTileWithTitle("imageTileWithTitle");
}

@Serializable
enum class WebLargeTemplateName(val value: String) {
    @SerialName("circleImageListLarge") CircleImageListLarge("circleImageListLarge"),
    @SerialName("") Empty(""),
    @SerialName("fullMarketingImage") FullMarketingImage("fullMarketingImage"),
    @SerialName("gridCircleImageLarge") GridCircleImageLarge("gridCircleImageLarge"),
    @SerialName("halfMarketingImage") HalfMarketingImage("halfMarketingImage"),
    @SerialName("imageCardsWithDescriptionLarge") ImageCardsWithDescriptionLarge("imageCardsWithDescriptionLarge"),
    @SerialName("textList") TextList("textList"),
    @SerialName("thirdMarketingImage") ThirdMarketingImage("thirdMarketingImage");
}

@Serializable
enum class LinkType(val value: String) {
    @SerialName("aToZBrands") AToZBrands("aToZBrands"),
    @SerialName("category") Category("category"),
    @SerialName("external") External("external"),
    @SerialName("internal") Internal("internal");
}

@Serializable
enum class EStyleType(val value: String) {
    @SerialName("dark") Dark("dark"),
    @SerialName("light") Light("light"),
    @SerialName("noTitle") NoTitle("noTitle"),
    @SerialName("premium") Premium("premium"),
    @SerialName("sale") Sale("sale");
}

@Serializable
enum class Type(val value: String) {
    @SerialName("aToZBrands") AToZBrands("aToZBrands"),
    @SerialName("container") Container("container"),
    @SerialName("link") Link("link");
}
