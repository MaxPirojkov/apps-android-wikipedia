package org.wikipedia.works.lesson23

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson20.HW.namedSteps

class WidgetTest : TestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun widgetTest() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                ExploreScreenWithWidget().searchWidget{
                    isDisplayed(voiceIcon)
                }
            }
        }
    }
}