package com.example.stylish.data.remote.dto

import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.item.Item

interface AsosApiService {
    suspend fun getCategories(): Category

    suspend fun getItemListById(list: List<Long?>): List<Item>
}