package org.wikipedia.works.lesson19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val namedStepsMap = mutableMapOf<TestContext<*>, Steps>()
val <T> TestContext<T>.namedSteps: Steps
    get() {
        return namedStepsMap.getOrPut(this) {Steps(this)}
    }