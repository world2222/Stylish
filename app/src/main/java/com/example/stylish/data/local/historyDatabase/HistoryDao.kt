package com.example.stylish.data.local.historyDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface HistoryDao {
    @Upsert
    suspend fun addHistory(history: History)

    @Delete
    suspend fun deleteHistory(history: History)

    @Query("SELECT * FROM History")
    fun getAllHistories(): LiveData<List<History>>
}