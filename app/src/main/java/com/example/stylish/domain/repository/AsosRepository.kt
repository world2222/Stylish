package com.example.stylish.domain.repository

import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.detail.Detail
import com.example.stylish.data.remote.dto.products_by_categoryId.ProductsByCategoryId
import com.example.stylish.data.remote.dto.products_by_searchTerm.ProductsBySearchTerm

interface AsosRepository {
    suspend fun getCategories(): Category

    suspend fun getProductsByCategoryId(id: Int): ProductsByCategoryId

    suspend fun getProductsBySearchTerm(
        term: String,
        minPrice: String,
        maxPrice: String
    ): ProductsBySearchTerm

    suspend fun getItemDetailById(id: Int): Detail
}