package com.example.stylish.domain.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.data.remote.dto.category.Children
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

    init {
        viewModelScope.launch {
            _category.value = service.getCategories()
            _categoryMen.value = _category.value.data?.navigation?.get(0)?.children?.get(4)?.children?.get(2)?.children?.get(1)?.children
                ?: listOf()
            _categoryWomen.value = _category.value.data?.navigation?.get(1)?.children?.get(4)?.children?.get(2)?.children?.get(1)?.children
                ?: listOf()
            println(_categoryWomen.value)
        }
    }

    fun getCategoryMen(): List<Children> {
        return _categoryMen.value
    }

    fun getCategoryWomen(): List<Children> {
        return _categoryWomen.value
    }
}