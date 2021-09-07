package com.example.projectinsquare.ui.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.example.projectinsquare.data.VenueRepository
import com.example.projectinsquare.data.model.VenueContact
import com.example.projectinsquare.data.model.VenueDetails
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
class DetailsViewModelShould {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var venueRepository: VenueRepository

    @Mock
    private lateinit var savedStateHandle: SavedStateHandle

    @Test
    fun provideVenueDetails() {
        testCoroutineRule.runBlockingTest {
            val id = "id"
            val venue = createTestVenueDetails()
            doReturn(venue).`when`(venueRepository).venueDetails(id)
            doReturn(id).`when`(savedStateHandle).get<String>("venueId")

            val viewModel = DetailsViewModel(venueRepository, savedStateHandle)

            assertThat(viewModel.venueDetails.getOrAwaitValue()).isEqualTo(venue)
            verify(venueRepository).venueDetails(id)
        }
    }

    private fun createTestVenueDetails() = VenueDetails(
        "Description",
        5.0f,
        "Name",
        VenueLocation("address", null, null),
        VenueContact("+371")
    )
}