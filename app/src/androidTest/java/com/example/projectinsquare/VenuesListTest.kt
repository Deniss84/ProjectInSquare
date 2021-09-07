package com.example.projectinsquare

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.projectinsquare.data.VenueProvider
import com.example.projectinsquare.di.LocalStorage
import com.example.projectinsquare.di.OnlineStorage
import com.example.projectinsquare.di.VenueProviderModule
import com.example.projectinsquare.ui.MainActivity
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@UninstallModules(VenueProviderModule::class)
@HiltAndroidTest
class VenuesListTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @BindValue
    @OnlineStorage
    @JvmField
    val onlineProvider: VenueProvider = FakeNetworkVenueProvider()

    @BindValue
    @LocalStorage
    @JvmField
    val localProvider: VenueProvider = FakeNetworkVenueProvider()

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun loadVenues() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withText("name1")).check(matches(isDisplayed()))
        onView(withText("name2")).check(matches(isDisplayed()))
    }

    @Test
    fun viewVenueDetails() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withText("name1")).perform(click())

        onView(withText("Description")).check(matches(isDisplayed()))
        onView(withText("Name")).check(matches(isDisplayed()))
        onView(withText("address")).check(matches(isDisplayed()))
    }
}