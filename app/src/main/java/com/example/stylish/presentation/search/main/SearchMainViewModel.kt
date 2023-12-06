package com.example.stylish.presentation.search.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchMainViewModel @Inject constructor(

) : ViewModel() {
    private val _query = mutableStateOf("")
    val query: State<String> = _query

    private val _active = mutableStateOf(false)
    val active: State<Boolean> = _active

    private val _sortType = mutableStateOf(SortType.None.type)
    val sortType: State<String> = _sortType

    private val _minPrice = mutableStateOf("")
    val minPrice: State<String> = _minPrice

    private val _maxPrice = mutableStateOf("")
    val maxPrice: State<String> = _maxPrice

    fun getQuery(): String {
        return _query.value
    }

    fun setQuery(query: String) {
        _query.value = query
    }

    fun isActive(): Boolean {
        return _active.value
    }

    fun toggleActive() {
        _active.value = !_active.value
    }

    fun setSortType(type: String) {
        _sortType.value = type
    }

    fun setMinPrice(price: String) {
        _minPrice.value = price
    }

    fun setMaxPrice(price: String) {
        _maxPrice.value = price
    }
}

sealed class SortType(val type: String) {
    data object None: SortType(type = "None")
    data object Asc: SortType(type = "priceasc")
    data object Dsc: SortType(type = "pricedesc")
    data object Rec: SortType(type = "recommended")
    data object New: SortType(type = "freshness")
}