package com.example.stylish.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.item.Item
import com.example.stylish.domain.repository.AsosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val service: AsosRepository
) : ViewModel() {
    private val _category = mutableStateOf(Category())
    val category: State<Category> = _category

    private val _items = mutableStateOf(listOf(Item()))
    val items: State<List<Item>> = _items

    private val _ex = mutableStateOf<Item>(Item())
    val ex: State<Item> = _ex

    init {
        viewModelScope.launch {
            _category.value = service.getCategories()
            _items.value = service.getItemListById(getWomenCategoriesId())
        }
    }

    fun getWomenCategoriesId(): List<Long?> {
        return _category.value.navigation?.get(1)?.children?.get(4)?.children?.get(2)?.children?.get(1)?.children?.map {
            it.link?.categoryID
        } ?: listOf()
    }

    fun getRandomWomenClothes(): List<Item> {
        return _items.value
    }
}