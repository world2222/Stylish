package com.example.stylish.data.local.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.stylish.data.local.historyDatabase.History
import com.example.stylish.data.local.historyDatabase.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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