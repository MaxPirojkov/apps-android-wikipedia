package org.wikipedia.works.lesson20.HW

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val namedStepsMap = mutableMapOf<TestContext<*>, NamedSteps>()
val <T> TestContext<T>.namedSteps: NamedSteps
    get() {
        return namedStepsMap.getOrPut(this) {NamedSteps(this)}
    }