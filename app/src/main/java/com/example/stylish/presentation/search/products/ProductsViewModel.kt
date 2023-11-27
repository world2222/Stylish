package com.example.stylish.presentation.search.products

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylish.data.remote.dto.products.Product
import com.example.stylish.data.remote.dto.products.Products
import com.example.stylish.domain.repository.AsosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val service: AsosRepository
) : ViewModel() {

    private val _data = mutableStateOf(Products())
    val data: State<Products> = _data

    private val _productList = mutableStateOf<List<Product>>(listOf())
    val productList: State<List<Product>> = _productList

    private val _categoryName = mutableStateOf("")
    val categoryName: State<String> = _categoryName

    fun getProductList(id: Int) {
        viewModelScope.launch {
            _data.value = service.getItemListById(id)     // 2623 is the id of the "New in" category.
            _productList.value = data.value.data?.products ?: listOf()
            _categoryName.value = data.value.data?.categoryName.toString()
        }
    }
}