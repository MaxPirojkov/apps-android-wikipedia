package org.wikipedia.works.lesson07.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object PopupGames: KScreen<PopupGames>() {
    override val layoutId = null
    override val viewClass = null

    val closeButtonPopup = KButton {
        withId(R.id.closeButton)
    }
}