package org.wikipedia.works.lesson13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object PopupScreen: KScreen<PopupScreen>() {
    override val layoutId = null
    override val viewClass = null

    val closePopup = KButton {
        withId(R.id.closeButton)
    }

    val gotItPopup = KButton {
        withId(R.id.buttonView)
        withText(R.string.onboarding_got_it)
    }
}