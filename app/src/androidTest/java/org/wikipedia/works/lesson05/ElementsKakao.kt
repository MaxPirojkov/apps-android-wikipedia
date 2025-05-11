package org.wikipedia.works.lesson05

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

val image = KImageView {
    withId(R.id.imageViewCentered)
}

val mainTextOnboarding = KTextView {
    withText(R.string.onboarding_welcome_title_v2)
}



fun main() {
    image.isDisplayed()
}