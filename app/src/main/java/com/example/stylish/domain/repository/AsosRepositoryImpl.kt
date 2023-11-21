package com.example.stylish.domain.repository

import com.example.stylish.data.remote.dto.AsosApiService
import com.example.stylish.data.remote.dto.category.CategoryItem
import javax.inject.Inject

class AsosRepositoryImpl @Inject constructor(
    private val api: AsosApiService
) : AsosRepository {
    override suspend fun getCategories(): List<CategoryItem> {
        return api.getCategories()
    }
}