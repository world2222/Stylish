package com.example.stylish.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class History(
    val keyword: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
