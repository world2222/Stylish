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
    private val _category = mutableStateOf<List<Children>>(listOf())
    val category: State<List<Children>> = _category

    private val _categoryNameWithId = mutableStateOf<List<CategoryNameWithId>>(listOf())
    val categoryNameWithId: State<List<CategoryNameWithId>> = _categoryNameWithId

    private val _menWomenImage = mutableStateOf<List<String>>(listOf())
    val menWomenImage: State<List<String>> = _menWomenImage

    fun getMenWomenImage() {
        viewModelScope.launch {
            _menWomenImage.value = service.getCategories().data?.navigation?.map {
                it.children?.get(4)?.children?.find { it2 ->
                    it2.content?.title == "Clothing"
                }?.content?.mobileImageUrl.toString()
            }?: listOf()
        }
    }

    fun getCategoryByGender(gender: String) {
        viewModelScope.launch {
            _category.value = service.getCategories().data?.navigation?.get(if (gender == "Men") 0 else 1)?.children?.get(4)?.children?.find { it.content?.title == "Clothing" }?.children?.get(1)?.children
                ?: listOf()
            _categoryNameWithId.value = category.value.map { CategoryNameWithId(name = it.content?.title, id = it.link?.categoryId) }
        }
    }
}