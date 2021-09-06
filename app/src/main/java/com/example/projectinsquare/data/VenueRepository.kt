package com.example.projectinsquare.data

import com.example.projectinsquare.data.model.Venue
import com.example.projectinsquare.data.model.VenueDetails
import com.example.projectinsquare.di.LocalStorage
import com.example.projectinsquare.di.OnlineStorage
import javax.inject.Inject

class VenueRepository @Inject constructor(
    @OnlineStorage private val networkProvider: VenueProvider,
    @LocalStorage private val offlineProvider: VenueProvider
) {

    suspend fun searchVenues(query: String): List<Venue> = networkProvider.searchVenues(query)

    suspend fun venueDetails(venueId: String): VenueDetails = networkProvider.venueDetails(venueId)
}
