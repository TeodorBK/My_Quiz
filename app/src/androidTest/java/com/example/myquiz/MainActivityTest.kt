package com.example.myquiz

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

private const val MELDING = "Tim"

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)



    @Test
    fun verifyName() {

        onView(withId(R.id.navn))
            .perform(typeText(MELDING))

    }

    @Test
    fun verifyButtonClick() {

        assertNotNull(onView(withId(R.id.startButton)))
        onView(withId(R.id.startButton)).perform(click())

    }
}