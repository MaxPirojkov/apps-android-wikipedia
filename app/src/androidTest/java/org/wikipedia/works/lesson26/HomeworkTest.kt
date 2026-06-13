package org.wikipedia.works.lesson26

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson20.ExploreScreenNew
import org.wikipedia.works.lesson20.HW.namedSteps
import org.wikipedia.works.lesson24.WebViewDSLScreen

class HomeworkTest : TestCase() {


    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                click(NavBarScreen.savedButton)
                click(SavedScreen.notNowButton)
                click(NavBarScreen.exploreButton)
                ExploreScreenNew.featuredArticleItem().perform {
                    click(articleImage)
                }
                click(WebViewDSLScreen.saveButton)
                pressBack()
                click(NavBarScreen.savedButton)
            }
        }
    }
}
