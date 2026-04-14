package org.wikipedia.works.lesson20.HW

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import org.wikipedia.works.lesson20.getName
import org.wikipedia.works.lesson24.KWebViewBaseElement

class NamedSteps(val testContext: TestContext<*>) {

    operator fun invoke(function: NamedSteps.() -> Unit) {
        function()
    }

    fun click(item: BaseActions) {
        testContext.step("click on ${item.getName()}") {
            item.click()
        }
    }

    fun isDisplayed(item: BaseAssertions) {
        testContext.step("${(item as BaseActions).getName()} is displayed") {
            item.isDisplayed()
        }
    }

    fun scroll(item: BaseActions) {
        testContext.step("scroll to ${item.getName()}") {
            item.scrollTo()
        }
    }

    fun sleep(millis: Long) {
        testContext.step("Pause on $millis") {
            Thread.sleep(millis)
        }
    }

    fun webScroll(item: KWebViewBaseElement<*>) {
        testContext.step("Scroll to ${item.getName()}") {
            item.executeAction {
                scroll()
            }
        }
    }

    fun webClick(item: KWebViewBaseElement<*>) {
        testContext.step("Click on ${item.getName()}") {
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
}
