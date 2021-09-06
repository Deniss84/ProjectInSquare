package com.example.projectinsquare.data

import javax.inject.Inject

class VenueRepository @Inject constructor() {

    private val forSquareService = RetrofitBuilder.fourSquareService

    private val near = "Rotterdam"
    private val version = "20210901"
    private val limit = 10
    private val radiusInMeters = 1000

    suspend fun searchVenues(query: String): List<Venue> {
        return forSquareService.searchVenues(
            clientId,
            clientSecret,
            version,
            near,
            limit,
            radiusInMeters,
            query
        ).response.venues
    }

    suspend fun venueDetails(venueId: String): VenueDetails {
        return forSquareService.venueDetails(
            venueId,
            clientId,
            clientSecret,
            version,
        ).response.venue
    }
}
