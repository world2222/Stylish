package com.example.stylish.data.local.wishlistDatabase

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Wishitem::class],
    version = 1,
)
abstract class WishlistDatabase : RoomDatabase() {

    abstract fun wishlistDao(): WishlistDao

    companion object {
        @Volatile
        private var INSTANCE: WishlistDatabase? = null

        fun getWishlistDatabase(context: Context): WishlistDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WishlistDatabase::class.java,
                    "wishlist_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}