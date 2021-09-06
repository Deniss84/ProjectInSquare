package com.example.projectinsquare.ui.main

import androidx.lifecycle.*
import com.example.projectinsquare.data.VenueRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: VenueRepository
) : ViewModel() {


    private val searchQuery: MutableLiveData<String> = MutableLiveData("")

    fun onTextChanged(newQuery: String) {
        searchQuery.value = newQuery
    }

    val repositoryList = searchQuery.switchMap { searchQuery ->
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(repository.searchVenues(searchQuery))
        }
    }
}