package com.example.stylish.data.local.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.stylish.data.local.History
import com.example.stylish.data.local.HistoryDatabase
import com.example.stylish.data.local.HistoryRepository
import kotlinx.coroutines.launch

class HistoryViewModel(application: Application) : AndroidViewModel(application) {

    private val getHistories: LiveData<List<History>>
    private val repository: HistoryRepository
    init {
        val historyDao = HistoryDatabase.getHistoryDatabase(application).historyDao()
        repository = HistoryRepository(historyDao)
        getHistories = repository.getHistories
    }
    fun addHistory(history: History) {
        viewModelScope.launch {
            repository.addHistory(history)
        }
    }

    fun deleteHistory(history: History) {
        viewModelScope.launch {
            repository.deleteHistory(history)
        }
    }
}