package com.example.stylish.domain.repository

import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.products.Products

interface AsosRepository {
    suspend fun getCategories(): Category

    suspend fun getItemListById(id: Int): Products
}