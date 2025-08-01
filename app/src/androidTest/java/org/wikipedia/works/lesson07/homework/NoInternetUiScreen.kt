package org.wikipedia.works.lesson07.homework

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object NoInternetUiScreen : UiScreen<NoInternetUiScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val image = UiView {
        withId(
            this@NoInternetUiScreen.packageName,
            "view_wiki_error_icon"
        )
    }

    val errorText = UiTextView {
        withId(
            this@NoInternetUiScreen.packageName,
            "view_wiki_error_text"
        )
    }

    val retryButton = UiView {
        withId(
            this@NoInternetUiScreen.packageName,
            "view_wiki_error_button"
        )
    }


}