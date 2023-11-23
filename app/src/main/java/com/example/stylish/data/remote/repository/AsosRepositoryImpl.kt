package com.example.stylish.data.remote.repository

import com.example.stylish.data.remote.dto.AsosApiService
import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.item.Item
import com.example.stylish.domain.repository.AsosRepository
import javax.inject.Inject

class AsosRepositoryImpl @Inject constructor(
    private val api: AsosApiService
) : AsosRepository {
    override suspend fun getCategories(): Category {
        return api.getCategories()
    }

    override suspend fun getItemListById(list: List<Long?>): List<Item> {
        return api.getItemListById(list)
    }
}