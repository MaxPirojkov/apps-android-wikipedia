package org.wikipedia.works.lesson13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.homework03.OnboardingScreen
import org.wikipedia.works.lesson07.homework.ExploreScreen
import org.wikipedia.works.lesson07.homework.SearchCardViewItem

class WebViewTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run {
            OnboardingScreen.skipButton.click()
            ExploreScreen.feedRecycler.childWith<SearchCardViewItem> {
                withDescendant {
                    withText("Featured article")
                }
            }.perform {
                click()
                Thread.sleep(10000)
            }
            ArticleViewScreen {
                webView {
                    PopupScreen.closePopup.click()
                    withElement(Locator.XPATH, "//span[@class='mw-page-title-main']") {
                        containsText("Dusky")
                    }
                }
            }
        }
    }
}