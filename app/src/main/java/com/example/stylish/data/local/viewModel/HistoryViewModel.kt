package com.example.stylish.data.local.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stylish.data.local.History
import com.example.stylish.data.local.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val historyRepository: HistoryRepository
) : ViewModel() {
    val historyList: LiveData<List<History>> = historyRepository.allHistories

    fun getAllHistories() {
        historyRepository.getAllHistories()
    }
    fun addHistory(history: History) {
        historyRepository.addHistory(history)
        getAllHistories()
    }

    fun deleteHistory(history: History) {
        historyRepository.deleteHistory(history)
        getAllHistories()
    }
}