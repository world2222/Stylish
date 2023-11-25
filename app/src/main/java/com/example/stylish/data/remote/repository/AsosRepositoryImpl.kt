package com.example.stylish.data.remote.repository

import com.example.stylish.data.remote.dto.AsosApiService
import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.products.Products
import com.example.stylish.domain.repository.AsosRepository
import javax.inject.Inject

class AsosRepositoryImpl @Inject constructor(
    private val api: AsosApiService
) : AsosRepository {
    override suspend fun getCategories(): Category {
        return api.getCategories()
    }

    override suspend fun getItemListById(id: Int): Products {
        return api.getItemListById(id)
    }
}