package com.example.stylish.presentation.search.search_main

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