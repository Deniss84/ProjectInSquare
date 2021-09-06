package com.example.projectinsquare.data

data class Venue(val id: String, val name: String, val location: Location) {
    val address: String
        get() = location.address ?: location.city ?: location.country ?: ""

    data class Location(val address: String?, val city: String?, val country: String?)
}