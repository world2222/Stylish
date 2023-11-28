package com.example.stylish.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryRepository(
    private val historyDao: HistoryDao
) {

    val allHistories = MutableLiveData<List<History>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    fun addHistory(history: History) {
        coroutineScope.launch(Dispatchers.IO) {
            historyDao.addHistory(history)
        }
    }

    fun deleteHistory(history: History) {
        coroutineScope.launch(Dispatchers.IO) {
            historyDao.deleteHistory(history)
        }
    }

    fun getAllHistories(): List<History>? {
        return allHistories.value
    }
}