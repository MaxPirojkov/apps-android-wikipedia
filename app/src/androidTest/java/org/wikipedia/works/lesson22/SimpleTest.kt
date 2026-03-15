package org.wikipedia.works.lesson22

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson07.homework.CustomizeCardView
import org.wikipedia.works.lesson07.homework.SearchCardViewItem
import org.wikipedia.works.lesson20.ExploreScreenNew
import org.wikipedia.works.lesson20.HW.namedSteps


class SimpleTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun searchBlock() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                isDisplayed(ExploreScreenNew.feedRecycler)
                ExploreScreenNew.searchBlock().isDisplayed()
                ExploreScreenNew.announcementBlock {
                    isDisplayed()
                }
            }
        }
    }
}