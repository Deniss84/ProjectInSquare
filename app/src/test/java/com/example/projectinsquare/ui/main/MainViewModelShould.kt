package com.example.projectinsquare.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.projectinsquare.data.VenueRepository
import com.example.projectinsquare.data.model.Venue
import com.example.projectinsquare.data.model.VenueLocation
import com.example.projectinsquare.utils.TestCoroutineRule
import com.example.projectinsquare.utils.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelShould {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var venueRepository: VenueRepository


    @Test
    fun provideVenuesList() {
        testCoroutineRule.runBlockingTest {
            val venues = listOf(createTestVenue())
            doReturn(venues).`when`(venueRepository).searchVenues("")

            val viewModel = MainViewModel(venueRepository)

            assertThat(viewModel.venuesList.getOrAwaitValue()).isEqualTo(venues)
            verify(venueRepository).searchVenues("")
        }
    }

    @Test
    fun updateVenueListOnQueryChange() {
        testCoroutineRule.runBlockingTest {
            val query = "query"
            val venues = listOf(createTestVenue())
            doReturn(venues).`when`(venueRepository).searchVenues(query)

            val viewModel = MainViewModel(venueRepository)
            viewModel.onTextChanged(query)

            assertThat(viewModel.venuesList.getOrAwaitValue()).isEqualTo(venues)
            verify(venueRepository).searchVenues(query)
        }
    }

    private fun createTestVenue() = Venue(
        "1",
        "name",
        VenueLocation("address", null, null)
    )
}