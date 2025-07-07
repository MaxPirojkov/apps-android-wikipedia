package org.wikipedia.works.lesson10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.screen.UiScreen

object AddLanguageUiScreen: UiScreen<AddLanguageUiScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val addLanguage = UiView {
        containsText("Add language")
    }

    val itemFromLangList = UiView {
        containsText("Русский")
    }
}