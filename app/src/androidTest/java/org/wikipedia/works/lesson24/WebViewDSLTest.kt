package org.wikipedia.works.lesson24

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson13.ArticleViewScreen
import org.wikipedia.works.lesson13.PopupScreen
import org.wikipedia.works.lesson20.ExploreScreenNew
import org.wikipedia.works.lesson20.HW.namedSteps
import org.wikipedia.works.lesson24.WebViewDSLScreen.refText
import org.wikipedia.works.lesson26.CloseCustomizeYourToolbarScenario

class WebViewDSLTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun webViewTest() {
        run {
            val checkYourToolbar = CloseCustomizeYourToolbarScenario(this)
            namedSteps {
                click(OnboardingScreen.skipButton)
                checkYourToolbar.init()
                ExploreScreenNew.featuredArticleItem().perform {
                    click(articleImage)
                }
                ArticleViewScreen {
                    click(PopupScreen.closePopup)
                }
                webScroll(refText)
                webHasText(refText, "References")
                webClick(refText)
                WebViewDSLScreen.referenceAt(1) {
                    index.executeAction {
                        webHasText(index, "[1]")
                    }
                }
            }
        }
    }
}

