package com.example.projectinsquare.data.local

import com.example.projectinsquare.data.VenueProvider
import com.example.projectinsquare.data.model.Venue
import com.example.projectinsquare.data.model.VenueDetails
import javax.inject.Inject

class OfflineVenueProvider @Inject constructor() : VenueProvider {

    override suspend fun searchVenues(query: String): List<Venue> {
        TODO("Not yet implemented")
    }

    override suspend fun venueDetails(venueId: String): VenueDetails {
        TODO("Not yet implemented")
    }
}
