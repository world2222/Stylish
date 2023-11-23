package com.example.stylish.domain.repository

import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.item.Item

interface AsosRepository {
    suspend fun getCategories(): Category

    suspend fun getItemListById(list: List<Long?>): List<Item>
}