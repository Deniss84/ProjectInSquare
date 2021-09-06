package com.example.projectinsquare.data

data class VenueDetailsResponse(val response: Response) {
    data class Response(val venue: VenueDetails)
}