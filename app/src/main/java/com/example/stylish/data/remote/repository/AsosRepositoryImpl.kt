package com.example.stylish.data.remote.repository

import com.example.stylish.data.remote.dto.AsosApiService
import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.detail.Detail
import com.example.stylish.data.remote.dto.products_by_searchTerm.ProductsBySearchTerm
import com.example.stylish.domain.repository.AsosRepository
import javax.inject.Inject

class AsosRepositoryImpl @Inject constructor(
    private val api: AsosApiService
) : AsosRepository {
    override suspend fun getCategories(): Category {
        return api.getCategories()
    }

    override suspend fun getProductsByCategoryId(id: Int): com.example.stylish.data.remote.dto.products_by_categoryId.ProductsByCategoryId {
        return api.getProductsByCategoryId(id)
    }

    override suspend fun getProductsBySearchTerm(
        term: String,
        minPrice: String,
        maxPrice: String
    ): ProductsBySearchTerm {
        return api.getProductsBySearchTerm(
            term = term,
            minPrice = minPrice,
            maxPrice = maxPrice
        )
    }

    override suspend fun getItemDetailById(id: Int): Detail {
        return api.getItemDetailById(id)
    }
}