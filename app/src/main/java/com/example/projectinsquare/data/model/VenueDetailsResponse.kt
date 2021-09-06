package com.example.projectinsquare.data.model

data class VenueDetailsResponse(val response: Response) {
    data class Response(val venue: VenueDetails)
}