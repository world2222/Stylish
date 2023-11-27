package com.example.stylish.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Upsert
    suspend fun addHistory(history: History)

    @Delete
    suspend fun deleteHistory(history: History)

    @Query("SELECT * FROM History")
    fun getHistories(): LiveData<List<History>>
}