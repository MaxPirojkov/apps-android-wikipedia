package org.wikipedia.works.lesson27

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson20.HW.namedSteps
import org.wikipedia.works.lesson26.SavedScreen

class FailTestAllureSupportScreenshotTest: TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport().apply {
        FailOnlyScreenshotStepInterceptor(screenshots)
    }
){
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun screenShotStandard() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                click(SavedScreen.notNowButton)
            }
        }
    }
}