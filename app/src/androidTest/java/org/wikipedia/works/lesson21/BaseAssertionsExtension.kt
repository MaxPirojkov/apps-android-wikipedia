package org.wikipedia.works.lesson21

import io.github.kakaocup.kakao.common.assertions.BaseAssertions

fun BaseAssertions.customCheckText(text: String) {
    view.check(CustomViewAssertion(text))
}