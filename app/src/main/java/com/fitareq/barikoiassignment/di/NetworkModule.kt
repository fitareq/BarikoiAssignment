package com.fitareq.barikoiassignment.di

import com.fitareq.barikoiassignment.data.network.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    private val BASE_URL = "https://barikoi.xyz/v2/api/"

    @Singleton
    @Provides
    fun providesRetrofit(
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApi(
        retrofit: Retrofit
    ): Api {
        return retrofit.create(Api::class.java)
    }
}