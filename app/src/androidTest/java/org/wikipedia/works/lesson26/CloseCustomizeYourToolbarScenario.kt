package org.wikipedia.works.lesson26

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R


class CloseCustomizeYourToolbarScenario(testContext: TestContext<*>) : BaseSmartScenario(testContext) {
     override fun isConditionMed(): Boolean = waitElementById("balloon_card")

    override val step: String = "Close Balloon customize toolbar"

    override val action: (StepInfo) -> Unit = {
        KView {
            withId(R.id.buttonView)
        }.click()
    }
}