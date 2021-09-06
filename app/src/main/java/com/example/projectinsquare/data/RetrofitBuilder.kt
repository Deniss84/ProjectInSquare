package com.example.projectinsquare.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {

    private val forSquareApiBuilder: Retrofit

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        forSquareApiBuilder = Retrofit.Builder()
            .baseUrl("https://api.foursquare.com/v2/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .build()
    }

    val fourSquareService: FourSquareService =
        forSquareApiBuilder.create(FourSquareService::class.java)
}