package com.example.projectinsquare.data

data class VenueDetails(
    val description: String,
    val rating: Float,
    val name: String,
    val location: VenueLocation,
    val contact: VenueContact,
)