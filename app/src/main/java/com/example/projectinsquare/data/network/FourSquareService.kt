package com.example.projectinsquare.data.network

import com.example.projectinsquare.data.model.VenueDetailsResponse
import com.example.projectinsquare.data.model.Venues
import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("venues/{id}")
    suspend fun venueDetails(
        @Path("id") venueId: String,
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("v") version: String,
    ): VenueDetailsResponse
}
