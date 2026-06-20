package org.wikipedia.works.lesson27

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.qameta.allure.kotlin.AllureId
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson20.ExploreScreenNew
import org.wikipedia.works.lesson20.HW.namedSteps
import org.wikipedia.works.lesson24.WebViewDSLScreen
import org.wikipedia.works.lesson26.NavBarScreen
import org.wikipedia.works.lesson26.SavedScreen
import org.wikipedia.works.lesson28.AllureIdRule
import org.wikipedia.works.lesson28.HappyTestRule

class SuccessAllureScreenshotTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        SuccessFinaleScreenShotTestInterceptor(screenshots)
    }
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule(order = 2)
    val happy = HappyTestRule(testLogger)

    @get:Rule(order = 1)
    val id = AllureIdRule(testLogger)

    @Test
    @AllureId("1")
    fun screenShotSuccess() {
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

// adb pull /sdcard/Documents/allure-results ./allure-results  - скачать репорт из эмулятора
// allure serve ./allure-results      - сгенерировать отчет


