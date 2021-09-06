package com.example.projectinsquare.data

import javax.inject.Inject

class VenueRepository @Inject constructor() {

    private val forSquareService = RetrofitBuilder.fourSquareService

    private val near = "Rotterdam"
    private val version = "20210901"
    private val limit = 10
    private val radiusInMeters = 1000

    suspend fun searchVenues(): List<Venue> {
        return forSquareService.searchVenues(
            clientId,
            clientSecret,
            version,
            near,
            limit,
            radiusInMeters,
            "Bank"
        ).response.venues
    }
}
