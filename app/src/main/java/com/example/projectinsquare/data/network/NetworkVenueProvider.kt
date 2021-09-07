package com.example.projectinsquare.data.network

import android.content.Context
import com.example.projectinsquare.R
import com.example.projectinsquare.data.VenueProvider
import com.example.projectinsquare.data.model.Venue
import com.example.projectinsquare.data.model.VenueDetails
import dagger.hilt.android.qualifiers.ApplicationContext
import java.lang.RuntimeException
import javax.inject.Inject

class NetworkVenueProvider @Inject constructor(
    private val forSquareService: FourSquareService,
    @ApplicationContext context: Context
) : VenueProvider {

    private val clientId = context.getString(R.string.client_id)
    private val clientSecret = context.getString(R.string.client_secret)

    init {
        if (clientId.isBlank() or clientSecret.isBlank()){
            throw RuntimeException("Please set clientId and clientSecret in secrets.xml")
        }
    }

    override suspend fun searchVenues(query: String): List<Venue> = forSquareService.searchVenues(
        clientId,
        clientSecret,
        version,
        near,
        limit,
        radiusInMeters,
        query
    ).response.venues

    override suspend fun venueDetails(venueId: String): VenueDetails =
        forSquareService.venueDetails(
            venueId,
            clientId,
            clientSecret,
            version,
        ).response.venue

    companion object {
        private const val near = "Rotterdam"
        private const val version = "20210901"
        private const val limit = 10
        private const val radiusInMeters = 1000
    }
}