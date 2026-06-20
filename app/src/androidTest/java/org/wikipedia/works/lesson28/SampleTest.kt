package org.wikipedia.works.lesson28

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.qameta.allure.kotlin.AllureId
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson20.HW.namedSteps
import org.wikipedia.works.lesson26.NavBarScreen
import org.wikipedia.works.lesson27.SuccessFinaleScreenShotTestInterceptor

class SampleTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        SuccessFinaleScreenShotTestInterceptor(screenshots)
    }
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule(order = 2)
    val isDeprecated = SkipTestRule()

    @get:Rule(order = 1)
    val id = AllureIdRule(testLogger)

    @Test
    @AllureId("1")
    fun testIdFirst() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                isDisplayed(NavBarScreen.savedButton)
                click(NavBarScreen.savedButton)
            }
        }
    }

    @Deprecated("Old function")
    @Test
    @AllureId("2")
    fun testIdSecond() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                isDisplayed(NavBarScreen.savedButton)
                isDisplayed(NavBarScreen.exploreButton)
            }
        }
    }
}
