package com.example.projectinsquare.di

import com.example.projectinsquare.data.network.FourSquareService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideFourSquareService(): FourSquareService {
        return Retrofit.Builder()
            .baseUrl("https://api.foursquare.com/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(FourSquareService::class.java)
    }
}