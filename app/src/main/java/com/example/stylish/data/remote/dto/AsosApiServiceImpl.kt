package com.example.stylish.data.remote.dto

import com.example.stylish.common.HttpRoutes
import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.detail.Detail
import com.example.stylish.data.remote.dto.products.Products
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

    override suspend fun getItemListById(id: Int): Products {
        return client.get(HttpRoutes.PRODUCT_LIST_START + id + HttpRoutes.PRODUCT_LIST_END).body()
    }

    override suspend fun getItemDetailById(id: Int): Detail {
        return client.get(HttpRoutes.PRODUCT_DETAIL_START + id + HttpRoutes.PRODUCT_DETAIL_END).body()
    }
}