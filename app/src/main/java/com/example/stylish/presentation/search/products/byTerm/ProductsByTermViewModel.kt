package com.example.stylish.presentation.search.products.byTerm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylish.data.remote.dto.products_by_searchTerm.Product
import com.example.stylish.data.remote.dto.products_by_searchTerm.ProductsBySearchTerm
import com.example.stylish.domain.repository.AsosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsByTermViewModel @Inject constructor(
    private val service: AsosRepository
) : ViewModel() {

    private val _data = mutableStateOf(ProductsBySearchTerm())
    val data: State<ProductsBySearchTerm> = _data

    private val _productList = mutableStateOf<List<Product>>(listOf())
    val productList: State<List<Product>> = _productList

    fun getProductByItemTerm(
        term: String,
        minPrice: String,
        maxPrice: String
    ) {
        viewModelScope.launch {
            _data.value = service.getProductsBySearchTerm(
                term = term,
                minPrice = minPrice,
                maxPrice = maxPrice
            )     // 2623 is the id of the "New in" category.
            _productList.value = data.value.data?.products ?: listOf()
        }
    }
}