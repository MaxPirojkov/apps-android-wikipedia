package org.wikipedia.works.lesson19

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson07.homework.ExploreScreen
import org.wikipedia.works.lesson07.homework.FeaturedArticleItem
import org.wikipedia.works.lesson07.homework.NoInternetUiScreen


class HWTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun deviceTest() {
        run {
            val steps = Steps(this)
            steps {
                click(OnboardingScreen.skipButton)
                setOrientationLeft()
                setOrientationRight()
                setOrientationNatural()
                sleep(5_000)
                isDisplayed(ExploreScreen.logo, "logo")
                disableNetwork()
                ExploreScreen.feedRecycler.childWith<FeaturedArticleItem> {
                    withDescendant {
                        withText("Featured article")
                    }
                }.perform {
                    click(articleImage)
                }
                hasText(NoInternetUiScreen.errorText, "Cannot connect to internet")
                enableNetwork()
                clickUi(NoInternetUiScreen.retryButton, "Retry button")
            }

        }
    }
}