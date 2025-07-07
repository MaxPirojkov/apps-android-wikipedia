package org.wikipedia.works.lesson09.homework

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson07.homework.ArticlesItem
import org.wikipedia.works.lesson07.homework.ExploreScreen
import org.wikipedia.works.lesson07.homework.InTheNews
import org.wikipedia.works.lesson07.homework.InTheNewsItem
import org.wikipedia.works.lesson07.homework.InTheNewsItemArticles
import org.wikipedia.works.lesson07.homework.PageArticle

class Homework09 : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun openInTheNewsArticle() {
        run {
            step("Skip onboarding") {
                OnboardingScreen.skipButton.click()
            }
            step("Find block In the news") {
                ExploreScreen.feedRecycler.childWith<InTheNews> {
                    withDescendant {
                        withText(R.string.view_card_news_title)
                    }
                }.perform {
                    step("Click on 3rd news") {
                        items.childAt<InTheNewsItem>(2) {
                            click()
                        }
                    }
                }
            }
            step("Click on 2nd article from list") {
                InTheNewsItemArticles.itemRecycler.childAt<ArticlesItem>(1) {
                    itemTitle.click()
                }
            }
            step("Page is displayed") {
                PageArticle.page.isDisplayed()
            }
        }
    }
}