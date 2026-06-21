package org.wikipedia.works.lesson29

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.qameta.allure.kotlin.AllureId
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson20.HW.namedSteps

class AuthorizeTest: TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @AllureId("1")
    fun authorize() {
        run {
            namedSteps {
                click(OnboardingScreen.skipButton)
                authorize(Users.Wikitest8767)
            }
        }
    }

}