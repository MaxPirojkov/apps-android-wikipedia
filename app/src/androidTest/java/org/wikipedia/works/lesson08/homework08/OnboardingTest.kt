package org.wikipedia.works.lesson08.homework08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson07.OnboardingScreen.firstPage
import org.wikipedia.R
import org.wikipedia.works.homework03.languageList
import org.wikipedia.works.homework03.primaryText
import org.wikipedia.works.lesson07.LanguageItem
import org.wikipedia.works.lesson07.OnboardingPagerFirstItem


class OnboardingTest : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity?> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkFirstScreen() {
        run {
            step("Check main logo") {
                OnboardingScreen.firstPage {
                    mainLogoImage.isDisplayed()
                }
            }
            step("Check Primary text") {
                OnboardingScreen.firstPage {
                    textTitle.isDisplayed()
                    textTitle.hasText(R.string.onboarding_welcome_title_v2)
                }
            }
            step("Check Secondary text") {
                OnboardingScreen.firstPage {
                    textSubtitle.isDisplayed()
                    textSubtitle.hasText(R.string.onboarding_multilingual_secondary_text)
                }
            }
            step("Check add language button") {
                OnboardingScreen.firstPage {
                    addLanguages.isDisplayed()
                    addLanguages.hasText(R.string.onboarding_multilingual_add_language_text)
                    addLanguages.isClickable()
                }
            }
            step("Check languages list") {
                OnboardingScreen.firstPage {
                    flakySafely(timeoutMs = 10000) {
                        languages.isDisplayed()
                    }
                    println(">>>>>> ${languages.getSize()}")
                }
            }
            step("Check default language") {
                OnboardingScreen.firstPage {
                    languages.childAt<LanguageItem>(0) {
                        textView.hasText("1. English")
                    }
                }
            }
        }
    }
}