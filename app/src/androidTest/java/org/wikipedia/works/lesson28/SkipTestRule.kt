package org.wikipedia.works.lesson28

import org.junit.AssumptionViolatedException
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class SkipTestRule() : TestRule {
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        return object : Statement() {
            override fun evaluate() {
                val descr = description?.getAnnotation(Deprecated::class.java)?.message
                if (descr != null) {
                    throw AssumptionViolatedException("Test deprecated $descr")
                } else {
                    base?.evaluate()
                }

            }
        }
    }
}