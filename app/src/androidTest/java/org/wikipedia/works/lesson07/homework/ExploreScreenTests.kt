package org.wikipedia.works.lesson07.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen

class ExploreScreenTests: TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun exploreTabTest() {
        run {
            step("Skip onboarding") {
                OnboardingScreen.skipButton.click()
            }
            step("Featured article") {
                ExploreScreen.feedRecycler.childWith<FeaturedArticleItem> {
                    withDescendant {
                        withText("Featured article")
                    }

//                    isInstanceOf(FeaturedArticleItem::class.java)
                //    onPosition(3)
                }.perform {
                    title.isDisplayed()
                }
            }
        }
    }

}