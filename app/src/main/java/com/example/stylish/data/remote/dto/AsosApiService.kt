package com.example.stylish.data.remote.dto

import com.example.stylish.data.remote.dto.category.CategoryItem

interface AsosApiService {
    suspend fun getCategory(): List<CategoryItem>
}