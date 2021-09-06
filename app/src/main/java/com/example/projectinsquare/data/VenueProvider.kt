package com.example.projectinsquare.data

import com.example.projectinsquare.data.model.Venue
import com.example.projectinsquare.data.model.VenueDetails

interface VenueProvider {
    suspend fun searchVenues(query: String): List<Venue>
    suspend fun venueDetails(venueId: String): VenueDetails
}