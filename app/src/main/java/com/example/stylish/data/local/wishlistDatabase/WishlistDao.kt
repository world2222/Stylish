package com.example.stylish.data.local.wishlistDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface WishlistDao {
    @Upsert
    suspend fun addWishItem(wishItem: Wishitem)

    @Delete
    suspend fun deleteWishItem(wishItem: Wishitem)

    @Query("SELECT * FROM Wishitem")
    fun getWishlist(): LiveData<List<Wishitem>>
}