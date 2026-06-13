package org.wikipedia.works.lesson26

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.views.KView

class CloseSyncReadingList(testContext: TestContext<*>) : BaseSmartScenario(testContext) {
    override fun isConditionMed(): Boolean = waitElementById("buttonPanel")

    override val step: String = "Close sync reading list dialog"

    override val action: (StepInfo) -> Unit = {
        KView {
            withId(android.R.id.button2)
            withText("No thanks")
        }.click()
    }

}