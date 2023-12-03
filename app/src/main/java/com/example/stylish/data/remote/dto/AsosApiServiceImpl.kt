package com.example.stylish.data.remote.dto

import com.example.stylish.common.HttpRoutes
import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.detail.Detail
import com.example.stylish.data.remote.dto.products_by_searchTerm.ProductsBySearchTerm
import com.example.stylish.data.remote.dto.you_might_also_like.YouMightAlsoLike
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class AsosApiServiceImpl @Inject constructor(
    private val client: HttpClient
): AsosApiService {
    override suspend fun getCategories(): Category {
        return client.get(HttpRoutes.CATEGORY).body()
    }

    override suspend fun getProductsByCategoryId(id: Int): com.example.stylish.data.remote.dto.products_by_categoryId.ProductsByCategoryId {
        return client.get(HttpRoutes.PRODUCT_LIST_ID_START + id + HttpRoutes.PRODUCT_LIST_ID_END).body()
    }

    override suspend fun getProductsBySearchTerm(
        term: String,
        minPrice: String,
        maxPrice: String
    ): ProductsBySearchTerm {
        return client.get(
            HttpRoutes.PRODUCT_LIST_TERM_START + term +
            HttpRoutes.PRODUCT_LIST_TERM_MIDDLE + minPrice +
            HttpRoutes.PRODUCT_LIST_TERM_END + maxPrice
        ).body()
    }

    override suspend fun getItemDetailById(id: Int): Detail {
        return client.get(HttpRoutes.PRODUCT_DETAIL_START + id + HttpRoutes.PRODUCT_DETAIL_END).body()
    }

    override suspend fun getYouMightAlsoLike(id: Int): YouMightAlsoLike {
        return client.get(HttpRoutes.YOU_MIGHT_ALSO_LIKE_START + id + HttpRoutes.YOU_MIGHT_ALSO_LIKE_END).body()
    }
}