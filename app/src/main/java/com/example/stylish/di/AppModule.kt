package com.example.stylish.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
                header("X-RapidAPI-Key", "1ecfb10b70mshfa4f5ebc61dc83fp1cdff0jsn017508bd5254")
                header("X-RapidAPI-Host", "asos-com1.p.rapidapi.com")
            }
            // -------------------------------------------------------------------------------------
        }
    }
}