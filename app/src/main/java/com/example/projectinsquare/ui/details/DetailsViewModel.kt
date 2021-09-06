package com.example.projectinsquare.ui.details

import androidx.lifecycle.*
import com.example.projectinsquare.data.VenueRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: VenueRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val selectedVenueId = requireNotNull(savedStateHandle.get<String>("venueId"))
    private val venueId: MutableLiveData<String> = MutableLiveData(selectedVenueId)

    val venueDetails = venueId.switchMap { id ->
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(repository.venueDetails(id))
        }
    }
}
