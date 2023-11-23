package com.example.stylish.data.remote.dto

import com.example.stylish.common.HttpRoutes
import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.item.Item
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

    override suspend fun getItemListById(list: List<Long?>): List<Item> {
        return list.map {
            client.get(HttpRoutes.PRODUCT_LIST_START + it + HttpRoutes.PRODUCT_LIST_END).body()
        }
    }
}