package com.example.stylish.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
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
class HomeViewModel @Inject constructor(
    private val service: AsosRepository
) : ViewModel() {

    private val _productsList = mutableStateOf(Products())
    val productsList: State<Products> = _productsList

    private val _newIn = mutableStateOf<List<Product>>(listOf())
    val newIn: State<List<Product>> = _newIn

    private val _categoryId = mutableIntStateOf(0)
    val categoryId: State<Int> = _categoryId
    init {
        viewModelScope.launch {
            _productsList.value = service.getItemListById(2623)     // 2623 is the id of the "New in" category.
            _newIn.value = productsList.value.data?.products ?: listOf()
        }
    }
}