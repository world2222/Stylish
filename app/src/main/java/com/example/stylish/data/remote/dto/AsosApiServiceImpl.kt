package com.example.stylish.data.remote.dto

import com.example.stylish.common.HttpRoutes
import com.example.stylish.data.remote.dto.category.CategoryItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class AsosApiServiceImpl @Inject constructor(
    private val client: HttpClient
): AsosApiService {
    override suspend fun getCategories(): List<CategoryItem> {
        return client.get(HttpRoutes.CATEGORY).body()
    }
}