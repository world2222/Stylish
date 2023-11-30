package com.example.stylish.domain.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.category.Children
import com.example.stylish.domain.model.CategoryNameWithId
import com.example.stylish.domain.repository.AsosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val service: AsosRepository
) : ViewModel() {
    private val _category = mutableStateOf(Category())
    val category: State<Category> = _category

    private val _categoryMen = mutableStateOf<List<Children>>(listOf())
    val categoryMen: State<List<Children>> = _categoryMen

    private val _categoryWomen = mutableStateOf<List<Children>>(listOf())
    val categoryWomen: State<List<Children>> = _categoryWomen

    private val _categoryNameWithId = mutableStateOf<List<CategoryNameWithId>>(listOf())
    val categoryNameWithId: State<List<CategoryNameWithId>> = _categoryNameWithId

    init {
        viewModelScope.launch {
            _category.value = service.getCategories()
            _categoryMen.value = category.value.data?.navigation?.get(0)?.children?.get(4)?.children?.find { it.content?.title == "Clothing" }?.children?.get(1)?.children
                ?: listOf()
            _categoryWomen.value = category.value.data?.navigation?.get(1)?.children?.get(4)?.children?.find { it.content?.title == "Clothing" }?.children?.get(1)?.children
                ?: listOf()
            _categoryNameWithId.value = categoryWomen.value.map { CategoryNameWithId(name = it.content?.title, id = it.link?.categoryId) }
        }
    }
}