package org.wikipedia.works.lesson26

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo

private const val WAITING_TIME_L = 100L

abstract class BaseSmartScenario(val testContext: TestContext<*>) {
    abstract fun isConditionMed(): Boolean
    abstract val step: String
    abstract val action: (StepInfo) -> Unit
    fun init(): Boolean {
        val condition = isConditionMed()
        if (condition) {
            testContext.step(step, action)
        }
        return condition
    }

    fun waitElementById(id: String): Boolean = getElementById(id).waitForExists(WAITING_TIME_L)


    fun getElementById(id: String): UiObject {
        return testContext
            .device
            .uiDevice
            .findObject(
                UiSelector()
                    .resourceId("${testContext.device.targetContext.packageName}:id/$id")
            )
    }

    fun getElementByText(text: String): UiObject {
        return testContext
            .device
            .uiDevice
            .findObject(
                UiSelector()
                    .textContains(text)
            )
    }
}