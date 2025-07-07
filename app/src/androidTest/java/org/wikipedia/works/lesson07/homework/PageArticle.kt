package org.wikipedia.works.lesson07.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R

object PageArticle: KScreen<PageArticle>() {
    override val layoutId = null
    override val viewClass = null

    val page = KView {
        withId(R.id.page_web_view)
    }

}