package com.example.projectinsquare

import com.example.projectinsquare.data.VenueProvider
import com.example.projectinsquare.data.model.Venue
import com.example.projectinsquare.data.model.VenueContact
import com.example.projectinsquare.data.model.VenueDetails
import com.example.projectinsquare.data.model.VenueLocation

class FakeNetworkVenueProvider : VenueProvider {
    override suspend fun searchVenues(query: String): List<Venue> {
        return listOf(createTestVenue("name1"), createTestVenue("name2"))
    }

    override suspend fun venueDetails(venueId: String): VenueDetails {
        return createTestVenueDetails()
    }

    private fun createTestVenueDetails() = VenueDetails(
        "Description",
        5.0f,
        "Name",
        VenueLocation("address", null, null),
        VenueContact("+371")
    )

    private fun createTestVenue(name: String) = Venue(
        "1",
        name,
        VenueLocation("address", null, null)
    )
}