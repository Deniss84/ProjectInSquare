package com.example.projectinsquare.data

import retrofit2.http.GET
import retrofit2.http.Query


interface FourSquareService {
    @GET("venues/search")
    suspend fun searchVenues(
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("v") version: String,
        @Query("near") near: String,
        @Query("limit") limit: Int,
        @Query("radius") radius: Int,
        @Query("query") query: String,
    ): Venues
}
