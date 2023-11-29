package com.example.stylish.common

object HttpRoutes {
    private const val BASE_URL = "https://asos10.p.rapidapi.com/api/v1"

    const val CATEGORY = "$BASE_URL/getCategories"

    const val PRODUCT_LIST_START = "$BASE_URL/getProductList?categoryId="
    const val PRODUCT_LIST_END = "&currency=USD&country=US&store=US&languageShort=en&sizeSchema=US&limit=10000&offset=0"

    const val PRODUCT_DETAIL_START = "$BASE_URL/getProductDetails?productId="
    const val PRODUCT_DETAIL_END = "&currency=USD&store=US&language=en-US&sizeSchema=US"
}