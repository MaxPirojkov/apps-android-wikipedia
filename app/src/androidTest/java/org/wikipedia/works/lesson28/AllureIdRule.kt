package org.wikipedia.works.lesson28

import com.kaspersky.kaspresso.logger.UiTestLogger
import io.qameta.allure.kotlin.AllureId
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class AllureIdRule(private val testLogger: UiTestLogger) : TestRule {
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        return object : Statement() {
            override fun evaluate() {
                val descr = description?.getAnnotation(AllureId::class.java)?.value
                testLogger.i("AllureId equals $descr")

                try {
                    base?.evaluate()
                } catch (e: Throwable) {
                    throw e
                } finally {
                    testLogger.i("Test finish")
                }
            }
        }
    }

}