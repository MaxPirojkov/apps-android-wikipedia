package org.wikipedia.works.lesson20

import io.github.kakaocup.kakao.common.actions.BaseActions

val names = mutableMapOf<BaseActions, NameHierarchy>()

fun <T : BaseActions> T.name(nameHierarchy: NameHierarchy): T {
    names[this] = nameHierarchy
    return this
}

fun BaseActions.getName(): NameHierarchy {
    return names[this] ?: throw RuntimeException("Set name")
}

fun BaseActions.withParent(elementName: String) = this.getName().withParent(elementName)