package com.example.stylish.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylish.data.remote.dto.AsosApiService
import com.example.stylish.data.remote.dto.category.CategoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val service: AsosApiService
) : ViewModel() {
    private val _category = mutableStateOf<List<CategoryItem>>(listOf())
    val category: State<List<CategoryItem>> = _category

    init {
        viewModelScope.launch {
            _category.value = service.getCategories()
        }
    }

    fun getCategories(): List<CategoryItem> {
        return _category.value
    }
}