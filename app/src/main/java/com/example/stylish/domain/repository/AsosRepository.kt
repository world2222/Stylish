package com.example.stylish.domain.repository

import com.example.stylish.data.remote.dto.category.CategoryItem

interface AsosRepository {
    suspend fun getCategories(): List<CategoryItem>
}