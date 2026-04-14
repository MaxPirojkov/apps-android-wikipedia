package org.wikipedia.works.lesson19

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.works.lesson20.getName
import org.wikipedia.works.lesson24.KWebViewBaseElement
import org.wikipedia.works.lesson24.KWebViewElement

class Steps(val testContext: TestContext<*>) {

    private fun execute(textOfSteps: String, actions: (StepInfo) -> Unit) {
        testContext.step(textOfSteps, actions)
    }

    operator fun invoke(function: Steps.() -> Unit) {
        function()
    }

    fun click(item: BaseActions) {
        testContext.step("Click on view ${item.getName()}") {
            item.click()
        }
    }

    fun clickUi(item: UiView, name: String) {
        execute("Click on UiView $name") {
            item.click()
        }
    }

    fun isDisplayed(item: BaseAssertions, name: String) {
        execute("$name element is displayed") {
            item.isDisplayed()
        }
    }

    fun sleep(millis: Long) {
        execute("Pause on $millis") {
            Thread.sleep(millis)
        }
    }

    fun setOrientationLeft() {
        execute("Set orientation left") {
            testContext.device.uiDevice.setOrientationLeft()
        }
    }

    fun setOrientationRight() {
        execute("Set orientation right") {
            testContext.device.uiDevice.setOrientationRight()
        }
    }

    fun setOrientationNatural() {
        execute("Set orientation natural") {
            testContext.device.uiDevice.setOrientationNatural()
        }
    }

    fun disableNetwork() {
        execute("Network disable") {
            testContext.device.uiDevice.executeShellCommand("svc wifi disable")
        }
    }

    fun enableNetwork() {
        execute("Network enable") {
            testContext.device.uiDevice.executeShellCommand("svc wifi enable")
        }
    }

    fun typeText(item: EditableActions, textForType: String) {
        execute("Type text '$textForType'") {
            item.typeText(textForType)
        }
    }

    fun setChecked(item: CheckableActions, condition: Boolean) {
        execute("Set '$condition'") {
            item.setChecked(condition)
        }
    }

    fun hasText(item: UiTextView, textForMatch: String) {
        execute("Has text '$textForMatch'") {
            item.hasText(textForMatch)
        }
    }

    fun hasAnyText(item: TextViewAssertions, name: String) {
        execute("Has any text in view $name") {
            item.hasAnyText()
        }
    }

    fun containsText(item: TextViewAssertions, textForMatch: String) {
        execute("Contains text '$textForMatch'") {
            item.containsText(textForMatch)
        }
    }

    fun isChecked(item: CheckableAssertions, name: String) {
        execute("Checked view $name") {
            item.isChecked()
        }
    }

    fun isNotChecked(item: CheckableAssertions, name: String) {
        execute("Not checked view $name") {
            item.isChecked()
        }
    }

    fun scroll(item: KWebViewElement) {
        execute("Scroll '${item.getName()}'") {
            item.executeAction { scroll() }
        }
    }

}
