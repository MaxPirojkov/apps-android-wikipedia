package org.wikipedia.works.lesson08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.topread.TopReadCardView
import org.wikipedia.main.MainActivity
import org.wikipedia.works.homework03.OnboardingScreen
import org.wikipedia.works.lesson07.homework.ExploreScreen
import org.wikipedia.works.lesson07.homework.SearchCardViewItem
import org.wikipedia.works.lesson07.homework.TopReadCardItem

class Work08: TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity?> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleTest() {
        run {
            step("Skip onboarding") {
                OnboardingScreen.skipButton.click()
            }
            step("Check toolbar is displayed") {
                ExploreScreen.logo.isDisplayed()
            }
            step("logo mic in search") {
                ExploreScreen.feedRecycler.childAt<SearchCardViewItem>(0) {
                    voiceIcon.isDisplayed()
                }
            }
            step("Check logo in 2nd child in topRead") {
                ExploreScreen.feedRecycler.childAt<TopReadCardItem>(1) {
                    step("TopRead item is displayed") {
                        isDisplayed()
                    }
                    itemImage.isDisplayed()
                }
            }
        }
    }
}