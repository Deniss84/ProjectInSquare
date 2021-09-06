package com.example.projectinsquare.data

data class Venues(val response: Response) {
    data class Response(val venues: List<Venue>)
}
