package org.wikipedia.works.lesson20.HW

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import com.kaspersky.components.kautomator.system.UiSystem.view
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.works.lesson20.getName
import org.wikipedia.works.lesson24.KWebViewBaseElement
import org.wikipedia.works.lesson26.CloseCustomizeYourToolbarScenario
import org.wikipedia.works.lesson26.CloseDialogScenario
import org.wikipedia.works.lesson26.CloseSyncReadingList
import org.wikipedia.works.lesson26.ListOfSmartScenario
import org.wikipedia.works.lesson26.NavBarScreen
import org.wikipedia.works.lesson29.CreateAccountScreen
import org.wikipedia.works.lesson29.Credentials
import org.wikipedia.works.lesson29.LoginScreen


class NamedSteps(val testContext: TestContext<*>) {

    operator fun invoke(function: NamedSteps.() -> Unit) {
        function()
    }

    private val listOfSmartScenario = ListOfSmartScenario(
        listOf(
            CloseDialogScenario(testContext),
            CloseSyncReadingList(testContext),
            CloseCustomizeYourToolbarScenario(testContext),

        )
    )

    private fun execute(textOfSteps: String, actions: (StepInfo) -> Unit) {
        try {
            testContext.step(textOfSteps, actions)
        } catch (e: Throwable) {
            if (listOfSmartScenario.execute()) {
                testContext.step(textOfSteps, actions)
            } else throw e
        }
    }

    fun click(item: BaseActions) {
        execute("click on ${item.getName()}") {
            item.click()
        }
    }

    fun isDisplayed(item: BaseAssertions) {
        execute("${(item as BaseActions).getName()} is displayed") {
            item.isDisplayed()
        }
    }

    fun scroll(item: BaseActions) {
        execute("scroll to ${item.getName()}") {
            item.scrollTo()
        }
    }

    fun sleep(millis: Long) {
        execute("Pause on $millis") {
            Thread.sleep(millis)
        }
    }

    fun webScroll(item: KWebViewBaseElement<*>) {
        execute("Scroll to ${item.getName()}") {
            item.executeAction {
                scroll()
            }
        }
    }

    fun webClick(item: KWebViewBaseElement<*>) {
        execute("Click on ${item.getName()}") {
            item.executeAction {
                click()
            }
        }
    }

    fun webHasText(item: KWebViewBaseElement<*>, text: String) {
        testContext.step("${item.getName()} : Has text '$text'") {
            item.executeAction {
                hasText(text)
            }
        }
    }

    fun pressBack() {
        execute("Press back") {
            Espresso.pressBack()
        }
        isDisplayed(NavBarScreen.savedButton)
    }

    fun authorize(userName: String) {
        execute("Authorization by $userName") {
            NavBarScreen {
                click(moreButton)
                click(loginMenu)
            }
            click(CreateAccountScreen.loginButton)
            LoginScreen {
                userNameInput.typeText(userName)
                passwordInput.typeText(
                    Credentials.getPassword(
                        userName
                            ?: throw IllegalArgumentException("Password for $userName don't find ")
                    )
                )
            }
            click(LoginScreen.loginButton)
        }
    }


}
