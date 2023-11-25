package com.example.stylish.data.remote.dto

import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.products.Products

interface AsosApiService {
    suspend fun getCategories(): Category

    suspend fun getItemListById(id: Int): Products
}