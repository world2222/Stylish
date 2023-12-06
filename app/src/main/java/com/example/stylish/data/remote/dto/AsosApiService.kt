package com.example.stylish.data.remote.dto

import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.detail.Detail
import com.example.stylish.data.remote.dto.products_by_searchTerm.ProductsBySearchTerm
import com.example.stylish.data.remote.dto.you_might_also_like.YouMightAlsoLike

interface AsosApiService {
    suspend fun getCategories(): Category

    suspend fun getProductsByCategoryId(id: Int): com.example.stylish.data.remote.dto.products_by_categoryId.ProductsByCategoryId
    suspend fun getProductsBySearchTerm(
        term: String,
        sortType: String,
        minPrice: String,
        maxPrice: String
    ): ProductsBySearchTerm

    suspend fun getItemDetailById(id: Int): Detail

    suspend fun getYouMightAlsoLike(id: Int): YouMightAlsoLike
}