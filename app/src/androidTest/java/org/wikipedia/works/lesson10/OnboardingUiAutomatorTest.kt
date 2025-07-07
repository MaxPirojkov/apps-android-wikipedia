package org.wikipedia.works.lesson10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiAutomatorTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkTextOnFirstPage(){
        run {
            step("Check Primary text on first page") {
                OnboardingUiScreen.primaryText.containsText("The Free Encyclopedia\n…in over 300 languages")
            }
            step("Check Secondary text on first page") {
                OnboardingUiScreen.secondaryText.containsText("We’ve found the following on your device:")
            }
        }
    }

    @Test
    fun checkTextOnSecondPage(){
        run {
            step("Go to second page") {
                OnboardingUiScreen.continueButton.click()
            }
            step("Check Primary text on second page") {
                OnboardingUiScreen.primaryText.containsText("New ways to explore")
            }
            step("Check Secondary text on second page") {
                OnboardingUiScreen.secondaryText.containsText("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. \nCustomize the feed to your interests – whether it’s learning about historical events On this day, or rolling the dice with Random.")
            }
        }
    }

    @Test
    fun addLanguage() {
        run {
            step("Add language") {
                OnboardingUiScreen.addLangButton.click()
            }
            step("Open list of languages") {
                AddLanguageUiScreen.addLanguage.click()
            }
            step("Choose russian language") {
                AddLanguageUiScreen.itemFromLangList.click()
            }
        }

    }

}