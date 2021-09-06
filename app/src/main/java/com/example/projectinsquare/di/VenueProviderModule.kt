package com.example.projectinsquare.di

import com.example.projectinsquare.data.VenueProvider
import com.example.projectinsquare.data.local.OfflineVenueProvider
import com.example.projectinsquare.data.network.NetworkVenueProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class VenueProviderModule {

    @OnlineStorage
    @Binds
    abstract fun bindNetworkVenueProvider(networkVenueProvider: NetworkVenueProvider): VenueProvider


    @LocalStorage
    @Binds
    abstract fun bindOfflineVenueProvider(offlineVenueProvider: OfflineVenueProvider): VenueProvider

}