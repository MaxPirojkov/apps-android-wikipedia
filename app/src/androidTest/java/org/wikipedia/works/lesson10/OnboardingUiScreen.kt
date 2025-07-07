package org.wikipedia.works.lesson10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen: UiScreen<OnboardingUiScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val image = UiView {
        withId(this@OnboardingUiScreen.packageName, "imageViewCentered")
    }

    val primaryText = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "primaryTextView")
    }

    val secondaryText = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }

    val languageList = UiView {
        withId(this@OnboardingUiScreen.packageName,"languagesList")
    }

    val addLangButton = UiView {
        withId(this@OnboardingUiScreen.packageName, "addLanguageButton")
    }

    val skipButton = UiView {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }

    val continueButton = UiView {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }
}