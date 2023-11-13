package com.example.stylish.ui.screens.create

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(

) : ViewModel() {
    private val _openDialog = mutableStateOf(false)
    val openDialog: State<Boolean> = _openDialog    // This value will be used in CreateScreen.

    fun openDialog() {
        _openDialog.value = true
    }

    fun closeDialog() {
        _openDialog.value = false
    }
}