package org.wikipedia.works.lesson20.HW

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import org.wikipedia.works.lesson20.getName

class NamedSteps(val testContext: TestContext<*>) {

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
}

val <T> TestContext<T>.namedSteps: NamedSteps
    get() = NamedSteps(this)