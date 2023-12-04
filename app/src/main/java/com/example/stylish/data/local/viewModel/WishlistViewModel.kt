package com.example.stylish.data.local.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.stylish.data.local.wishlistDatabase.Wishitem
import com.example.stylish.data.local.wishlistDatabase.WishlistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WishlistViewModel @Inject constructor(
    private val wishlistRepository: WishlistRepository
) : ViewModel() {
    val wishList: LiveData<List<Wishitem>> = wishlistRepository.allWishItems

    fun getWishList() {
        wishlistRepository.getWishlist()
    }
    fun addWishItem(wishItem: Wishitem) {
        wishlistRepository.addWishlist(wishItem)
        getWishList()
    }

    fun deleteWishItem(wishItem: Wishitem) {
        wishlistRepository.deleteWishlist(wishItem)
        getWishList()
    }
}