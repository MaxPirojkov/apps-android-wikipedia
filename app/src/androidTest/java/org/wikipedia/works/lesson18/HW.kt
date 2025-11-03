package org.wikipedia.works.lesson18

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson07.homework.ExploreScreen
import org.wikipedia.works.lesson07.homework.SearchCardViewItem

class HW: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun deviceTest() {
        before {
        }.after {
        }.run {
            step("Skip onboarding") {
                OnboardingScreen.skipButton.click()
            }
            step("Check landscape orientation") {
                device.uiDevice.setOrientationLeft()
                device.uiDevice.isNaturalOrientation
                device.uiDevice.setOrientationNatural()
            }
            step("Switch off display") {
                device.uiDevice.sleep()
                Thread.sleep(1_000)
            }
            step("Switch on display") {
                device.uiDevice.wakeUp()
            }
            step("Check logo") {
                ExploreScreen.logo.isDisplayed()
            }
            step("Check hint in search input") {
                ExploreScreen.feedRecycler.childAt<SearchCardViewItem>(0) {
                    searchText.isDisplayed()
                }
            }
        }
    }
}