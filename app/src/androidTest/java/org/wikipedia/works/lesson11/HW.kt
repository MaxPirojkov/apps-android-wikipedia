package org.wikipedia.works.lesson11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kaspersky.kaspresso.annotations.ScreenShooterTest
import com.kaspersky.kaspresso.testcases.api.testcase.DocLocScreenshotTestCase
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import org.wikipedia.works.lesson07.OnboardingScreen
import org.wikipedia.works.lesson07.homework.ArticleCard
import org.wikipedia.works.lesson07.homework.ExploreScreen
import org.wikipedia.works.lesson07.homework.FeaturedArticleItem
import org.wikipedia.works.lesson07.homework.NoInternetUiScreen
import org.wikipedia.works.lesson07.homework.SearchCardViewItem
import org.wikipedia.R
import org.wikipedia.works.lesson07.homework.PopupGames
import java.io.File
import java.util.Locale

class HW : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun deviceTest() {
        before {
        }.after {
            device.network.toggleWiFi(true)
            activityScenarioRule.scenario.close()
        }.run {
            step("Skip onboarding") {
                OnboardingScreen.skipButton.click()
            }
//            step("Check landscape orientation") {
//                device.uiDevice.setOrientationLeft()
                device.uiDevice.isNaturalOrientation
//                device.uiDevice.setOrientationNatural()
//            }
//            step("Switch off display") {
//                device.uiDevice.sleep()
//                Thread.sleep(1_000)
//            }
//            step("Switch on display") {
//                device.uiDevice.wakeUp()
//            }
//            step("Check logo") {
//                ExploreScreen.logo.isDisplayed()
//            }
//            step("Hide app") {
//                device.uiDevice.pressHome()
//            }
//            step("Open app from background") {
//                repeat(2) {
//                    device.uiDevice.pressRecentApps()}
//            }
//            step("Check hint in search input") {
//                ExploreScreen.feedRecycler.childAt<SearchCardViewItem>(0){
//                    searchText.isDisplayed()
//                }
//            }
//            step("Switch off network") {
//                device.network.toggleWiFi(false)
//            }
//            step("Open article without internet") {
//                ExploreScreen.feedRecycler.childWith<FeaturedArticleItem> {
//                    withDescendant {
//                        withText("Featured article")
//                    }
//                }.perform {
//                   articleImage.click()
//                }
//            }
//            step("Check error text") {
//                NoInternetUiScreen.errorText.hasText("Cannot connect to internet")
//            }
//            step("Switch on network") {
//                device.network.toggleWiFi(true)
//            }
//            step("Tap on retry") {
//                NoInternetUiScreen.retryButton.click()
//            }
//            step("Check header after repeat") {
//                ArticleCard.articleTitle.isDisplayed()
//            }
            step("Change language") {
                device.language.switchInApp(Locale("es"))
                PopupGames.closeButtonPopup.click()
                device.uiDevice.swipe(device.uiDevice.displayWidth / 2,(device.uiDevice.displayHeight * 0.25).toInt(),device.uiDevice.displayWidth / 2,(device.uiDevice.displayHeight * 0.75).toInt(),30)
            }
            step("Check language after change") {
                ExploreScreen.feedRecycler.childAt<SearchCardViewItem>(0) {
                    searchText.hasText("Buscar en Wikipedia")
                }
            }
            step("Check mainActivity is active") {
                device.activities.isCurrent(MainActivity::class.java)
            }
            step("screenshot") {
                val screenshotPathOnDevice = File("/storage/emulated/0/Documents/screenshots/org.wikipedia.works.lesson11.HW/deviceTest/shot.png")
                val targetPath = File("app/src/androidTest/java/org/wikipedia/works/lesson11/shot.png") //лучше копировать в папку build что бы не накапаливался мусор и при cleanBuild очищалось
                device.screenshots.take("shot")
                device.files
                val command = "pull"
                val arguments = listOf(screenshotPathOnDevice.toString(), targetPath.toString() )
                adbServer.performAdb(command,arguments)
            }
        }
    }
}