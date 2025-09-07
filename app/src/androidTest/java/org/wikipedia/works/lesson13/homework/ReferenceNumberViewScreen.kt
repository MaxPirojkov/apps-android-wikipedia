package org.wikipedia.works.lesson13.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ReferenceNumberViewScreen : KScreen<ReferenceNumberViewScreen>() {
    override val layoutId = null
    override val viewClass = null

    val index = KTextView {
        withId(R.id.reference_id)
        isDisplayed()
    }

    val openArticleInWeb = KButton {
        withId(R.id.link_preview_secondary_button)
    }

    val readArticle = KButton {
        withId(R.id.link_preview_primary_button)
    }


}