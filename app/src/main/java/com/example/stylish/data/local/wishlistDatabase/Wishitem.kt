package com.example.stylish.data.local.wishlistDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Wishitem(
    val itemId: Int,
    val brandName: String,
    val price: String,
    val imageUrl: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
