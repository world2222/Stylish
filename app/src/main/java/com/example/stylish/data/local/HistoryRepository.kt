package com.example.stylish.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HistoryRepository @Inject constructor(
    private val historyDao: HistoryDao
) {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allHistories: LiveData<List<History>> = historyDao.getAllHistories()

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