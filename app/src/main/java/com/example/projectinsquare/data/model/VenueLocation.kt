package com.example.projectinsquare.data.model

data class VenueLocation(val address: String?, val city: String?, val country: String?){
    val addressIfAny: String
        get() = address ?: city ?: country ?: ""

}