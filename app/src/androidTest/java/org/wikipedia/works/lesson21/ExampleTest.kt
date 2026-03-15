package org.wikipedia.works.lesson21

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import org.wikipedia.works.homework03.OnboardingScreen
import org.wikipedia.works.lesson07.homework.ExploreScreen
import org.wikipedia.works.lesson07.homework.SearchCardViewItem
import org.wikipedia.works.lesson07.homework.TopReadCardItem
import org.wikipedia.works.lesson07.homework.TopReadCardView
import org.wikipedia.works.lesson21.homework.hasAnyDrawable
import org.wikipedia.works.lesson21.homework.noDrawable

class ExampleTest : TestCase() {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun example() = run {
        OnboardingScreen.skipButton.customCheckText("Skip")
        val text = OnboardingScreen.skipButton.getText()
        Assert.assertEquals("Skip", text)
        OnboardingScreen.skipButton.customClick()
        ExploreScreen.logo.hasAnyDrawable()
//        ExploreScreen.feedRecycler.childAt<SearchCardViewItem>(position = 0){
//            searchIcon.noDrawable()
//        }
fun topReadItem(index: Int, function: TopReadCardItem.() -> Unit) {

}

    }
}