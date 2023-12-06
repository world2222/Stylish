package com.example.stylish.di

import android.content.Context
import com.example.stylish.data.local.historyDatabase.HistoryDao
import com.example.stylish.data.local.historyDatabase.HistoryDatabase
import com.example.stylish.data.local.historyDatabase.HistoryRepository
import com.example.stylish.data.local.wishlistDatabase.WishlistDao
import com.example.stylish.data.local.wishlistDatabase.WishlistRepository
import com.example.stylish.data.local.wishlistDatabase.WishlistDatabase
import com.example.stylish.data.remote.dto.AsosApiService
import com.example.stylish.data.remote.dto.AsosApiServiceImpl
import com.example.stylish.domain.repository.AsosRepository
import com.example.stylish.data.remote.repository.AsosRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }

            // Must delete before push!!!
            // -------------------------------------------------------------------------------------
            install(DefaultRequest) {
                header("X-RapidAPI-Key", "2cff06b069msh1ea287b3f59bd42p139a51jsn8c4f1a12d488")
                header("X-RapidAPI-Host", "asos10.p.rapidapi.com")
            }
            // -------------------------------------------------------------------------------------


        }
    }

    @Provides
    @Singleton
    fun provideAsosApiService(httpClient: HttpClient): AsosApiService {
        return AsosApiServiceImpl(httpClient)
    }

    @Provides
    @Singleton
    fun provideAsosRepository(api: AsosApiService): AsosRepository {
        return AsosRepositoryImpl(api)
    }



    // Room Database
    // - History
    @Provides
    @Singleton
    fun provideHistoryDataBase(@ApplicationContext context: Context): HistoryDatabase {
        return HistoryDatabase.getHistoryDatabase(context)
    }

    @Provides
    @Singleton
    fun provideHistoryDao(db: HistoryDatabase): HistoryDao {
        return db.historyDao()
    }

    @Provides
    @Singleton
    fun provideHistoryRepository(dao: HistoryDao): HistoryRepository {
        return HistoryRepository(dao)
    }


    // - Wishlist
    @Provides
    @Singleton
    fun provideWishlistDatabase(@ApplicationContext context: Context): WishlistDatabase {
        return WishlistDatabase.getWishlistDatabase(context)
    }

    @Provides
    @Singleton
    fun provideWishlistDao(db: WishlistDatabase): WishlistDao {
        return db.wishlistDao()
    }

    fun provideWishlistRepository(dao: WishlistDao): WishlistRepository {
        return WishlistRepository(dao)
    }
}