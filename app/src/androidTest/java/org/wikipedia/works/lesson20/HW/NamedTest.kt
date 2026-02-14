package org.wikipedia.works.lesson20.HW

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson20.ExploreScreenNew
import org.wikipedia.works.lesson20.HW.namedSteps


class NamedTest: TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun namedTest() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                isDisplayed(ExploreScreenNew.feedRecycler)
            }
        }
    }
}