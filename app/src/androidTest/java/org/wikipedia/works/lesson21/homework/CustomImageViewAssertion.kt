package org.wikipedia.works.lesson21.homework


import io.github.kakaocup.kakao.image.ImageViewAssertions

fun ImageViewAssertions.hasAnyDrawable() {
    view.check(HasAnyDrawableAssertion())
}

fun ImageViewAssertions.noDrawable() {
    view.check(NoDrawableAssertion())
}