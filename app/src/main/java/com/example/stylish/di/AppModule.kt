package com.example.stylish.di

import com.example.stylish.data.remote.dto.AsosApiService
import com.example.stylish.data.remote.dto.AsosApiServiceImpl
import com.example.stylish.domain.repository.AsosRepository
import com.example.stylish.data.remote.repository.AsosRepositoryImpl
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
                header("X-RapidAPI-Key", "824b4c3149msha9ec012c5492559p14b29ajsneeafcd381c27")
                header("X-RapidAPI-Host", "asos2.p.rapidapi.com")
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
}