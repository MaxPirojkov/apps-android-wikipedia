package org.wikipedia.works.lesson21.homework

import io.github.kakaocup.kakao.check.KCheckBox

fun KCheckBox.checkBox() {
    view.perform(CustomCheckBoxAction())
}