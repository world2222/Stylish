package com.example.stylish.data.local

import androidx.lifecycle.LiveData

class HistoryRepository(
    private val historyDao: HistoryDao
) {
    suspend fun addHistory(history: History) {
        historyDao.addHistory(history)
    }

    suspend fun deleteHistory(history: History) {
        historyDao.deleteHistory(history)
    }

    val getHistories: LiveData<List<History>> = historyDao.getHistories()
}