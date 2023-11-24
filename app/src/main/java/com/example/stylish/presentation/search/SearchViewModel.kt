package com.example.stylish.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylish.data.remote.dto.category.Brand
import com.example.stylish.data.remote.dto.category.Category
import com.example.stylish.domain.repository.AsosRepository
import com.example.stylish.domain.viewModel.SharedViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(

) : ViewModel() {
    private val _query = mutableStateOf("")
    val query: State<String> = _query

    private val _active = mutableStateOf(false)
    val active: State<Boolean> = _active

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
}