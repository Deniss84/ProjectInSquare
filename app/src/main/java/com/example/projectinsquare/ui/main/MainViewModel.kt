package com.example.projectinsquare.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.projectinsquare.data.Venue
import com.example.projectinsquare.data.VenueRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: VenueRepository
) : ViewModel() {

    val repositoryList: LiveData<List<Venue>>
        get() = liveData(Dispatchers.IO) {
            emit(repository.searchVenues())
        }
}