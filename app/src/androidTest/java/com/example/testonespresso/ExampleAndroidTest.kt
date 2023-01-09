package com.example.testonespresso

import android.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ExampleAndroidTest {
    //launch application
    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java);

    @Test
    fun clickButtonHome() {
        onView(withId(com.example.testonespresso.R.id.navigation_home))
            .perform(click())
            .check(matches(isDisplayed()))
            .check(matches(isSelected()))
        onView(withId(com.example.testonespresso.R.id.text_home))
            .check(matches(isDisplayed()))
        onView(withId(com.example.testonespresso.R.id.navigation_dashboard))
            .check(matches(isNotSelected()))
        onView(withId(com.example.testonespresso.R.id.navigation_notifications))
            .check(matches(isNotSelected()))
    }

    @Test
    fun clickButtonNotification() {
        onView(withId(com.example.testonespresso.R.id.navigation_notifications))
            .perform(click())
            .check(matches(isDisplayed()))
            .check(matches(isSelected()))
        onView(withId(com.example.testonespresso.R.id.text_notifications))
            .check(matches(withText("This is notifications Fragment")))
    }

    @Test
    fun clickButtonDashboard() {
        onView(withId(com.example.testonespresso.R.id.navigation_dashboard))
            .perform(click())
            .check(matches(isDisplayed()))
            .check(matches(isSelected()))
        onView(withId(com.example.testonespresso.R.id.text_dashboard))
            .check(matches(withText("This is dashboard Fragment")))
    }

    @Test
    fun userUsesPressBackBtn() {
        onView(withId(com.example.testonespresso.R.id.navigation_home))
            .perform(click())
            .check(matches(isDisplayed()))
            .check(matches(isSelected()))
        onView(withId(com.example.testonespresso.R.id.navigation_dashboard))
            .perform(click())
            .check(matches(isSelected()))
        onView(withId(com.example.testonespresso.R.id.text_dashboard))
            .check(matches(withText("This is dashboard Fragment")))
            .perform(pressBack())
            .check(doesNotExist())
        onView(withId(com.example.testonespresso.R.id.navigation_home))
            .check(matches(isSelected()))
        onView(withId(com.example.testonespresso.R.id.text_home))
            .check(matches(withText("This is home Fragment")))
    }
}