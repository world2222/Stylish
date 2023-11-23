package com.example.stylish.common

object HttpRoutes {
    private const val BASE_URL = "https://asos2.p.rapidapi.com"

    const val CATEGORY = "$BASE_URL/categories/list?country=US&lang=en-US"

    const val PRODUCT_LIST_START = "$BASE_URL/products/v2/list?store=US&offset=0&categoryId="
    const val PRODUCT_LIST_END = "&limit=48&country=US&sort=freshness&currency=USD&sizeSchema=US&lang=en-US"
}