package org.wikipedia.works.lesson20.HW

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson20.ExploreScreenNew


class NamedTest: TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun namedTest() {
        run {
           val namedSteps = NamedSteps(this)
            namedSteps.click(OnboardingScreen.skipButton)
            namedSteps.isDisplayed(ExploreScreenNew.feedRecycler)
        }
    }
}