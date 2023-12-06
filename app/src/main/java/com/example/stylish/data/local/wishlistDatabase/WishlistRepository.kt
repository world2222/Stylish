package com.example.stylish.data.local.wishlistDatabase

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class WishlistRepository @Inject constructor(
    private val wishlistDao: WishlistDao
) {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allWishItems: LiveData<List<Wishitem>> = wishlistDao.getWishlist()
    fun addWishlist(wishItem: Wishitem) {
        coroutineScope.launch(Dispatchers.IO) {
            wishlistDao.addWishItem(wishItem)
        }
    }

    fun deleteWishlist(wishItem: Wishitem) {
        coroutineScope.launch(Dispatchers.IO) {
            wishlistDao.deleteWishItem(wishItem)
        }
    }

    fun getWishlist(): List<Wishitem>? {
        return allWishItems.value
    }
}