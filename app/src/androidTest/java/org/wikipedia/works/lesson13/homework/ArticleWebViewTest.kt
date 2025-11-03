package org.wikipedia.works.lesson13.homework

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.homework03.OnboardingScreen
import org.wikipedia.works.lesson07.homework.ExploreScreen
import org.wikipedia.works.lesson07.homework.SearchCardViewItem
import org.wikipedia.works.lesson13.ArticleViewScreen
import org.wikipedia.works.lesson13.PopupScreen

class ArticleWebViewTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun homeworkTest() {
        run {
            OnboardingScreen.skipButton.click()
            ExploreScreen.feedRecycler.childWith<SearchCardViewItem> {
                withDescendant {
                    withText("Featured article")
                }
            }.perform {
                click()
            }
            ArticleViewScreen {
                PopupScreen.closePopup.click()
                webView {
                    withElement(Locator.ID, "References") {
                        scroll()
                        hasText("References")
                        click()
                    }
                    withElement(
                        Locator.XPATH,
                        "//sup[contains(@class,'reference')]/a[node()='[5]']"
                    ) {
                        click()
                    }
                }
                ReferenceNumberViewScreen.index.containsText("5.")
                device.uiDevice.pressBack()
                webView {
                    withElement(
                        Locator.XPATH,
                        "(//a[contains(@class,'mw-redirect')])[2]"
                    ) {
                        click()
                    }
                }
                ReferenceNumberViewScreen.readArticle.click()
                webView {
                    withElement(Locator.ID, "References") {
                        scroll()
                    }
                    Thread.sleep(4000)
                }
            }
        }
    }
}
