package org.wikipedia.works.lesson13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.works.lesson20.ExploreScreenNew.withParent
import org.wikipedia.works.lesson20.name

object PopupScreen: KScreen<PopupScreen>() {
    override val layoutId = null
    override val viewClass = null

    val closePopup by lazy {
        KButton {
            withId(R.id.closeButton)
        }.name(withParent("Close popup"))
    }

    val gotItPopup = KButton {
        withId(R.id.buttonView)
        withText(R.string.onboarding_got_it)
    }
}