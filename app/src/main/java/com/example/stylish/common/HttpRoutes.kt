package com.example.stylish.common

object HttpRoutes {
    private const val BASE_URL = "https://asos10.p.rapidapi.com/api/v1"

    const val CATEGORY = "$BASE_URL/getCategories"

    const val PRODUCT_LIST_ID_START = "$BASE_URL/getProductList?categoryId="
    const val PRODUCT_LIST_ID_END = "&currency=USD&country=US&store=US&languageShort=en&sizeSchema=US&limit=200&offset=0"

    const val PRODUCT_LIST_TERM_START = "$BASE_URL/getProductListBySearchTerm?searchTerm="
    const val PRODUCT_LIST_TERM_MIDDLE = "&currency=USD&country=US&store=US&languageShort=en&sizeSchema=US&limit=200&offset=1&priceMin="
    const val PRODUCT_LIST_TERM_END = "&priceMax="

    const val PRODUCT_DETAIL_START = "$BASE_URL/getProductDetails?productId="
    const val PRODUCT_DETAIL_END = "&currency=USD&store=US&language=en-US&sizeSchema=US"

    const val YOU_MIGHT_ALSO_LIKE_START = "$BASE_URL/getYouMightAlsoLike?productId="
    const val YOU_MIGHT_ALSO_LIKE_END = "&currency=USD&country=US&store=US&language=en-US"
}