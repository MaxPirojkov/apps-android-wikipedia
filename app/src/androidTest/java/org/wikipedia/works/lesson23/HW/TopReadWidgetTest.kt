package org.wikipedia.works.lesson23.HW

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson20.HW.namedSteps
import org.wikipedia.works.lesson23.ExploreScreenWithWidget

class TopReadWidgetTest : TestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun widgetTest() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                scroll(
                    ExploreScreenWithWidget().topReadWidget.scrollToTopRead
                )
                ExploreScreenWithWidget().topReadWidget {
                    isDisplayed(titleHeader)
                    openArticleAt(2){
                        isDisplayed(numberOfCard)
                        isDisplayed(itemTitle)
                        isDisplayed(itemSubtitle)
                    }
                }

            }
        }
    }
}