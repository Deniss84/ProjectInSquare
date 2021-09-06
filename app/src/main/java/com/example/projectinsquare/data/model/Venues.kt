package com.example.projectinsquare.data.model

data class Venues(val response: Response) {
    data class Response(val venues: List<Venue>)
}
