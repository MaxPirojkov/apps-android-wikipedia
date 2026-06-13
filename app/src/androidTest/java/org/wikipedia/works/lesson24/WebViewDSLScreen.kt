package org.wikipedia.works.lesson24

import com.kaspersky.components.kautomator.component.text.UiTextView
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.works.lesson20.NamedKScreen
import org.wikipedia.works.lesson20.name

object WebViewDSLScreen : NamedKScreen<WebViewDSLScreen>() {
    override val screenName: String = "WebViewDSL"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }

    val refText by lazy {
        KWebViewElement(webView, "//*[@id='References']")
            .name(withParent("Reference title"))
    }

    val references by lazy {
        KWebViewList(
            webView,
            "//*[@id='References']/following::ol[@class='mw-references references']"
        )
            .name(withParent("List of References"))
    }


    fun referenceAt(index: Int, block: ReferenceListItem.() -> Unit) {
        references.childAt<ReferenceListItem>(index) { block() }
    }

    val webActionsTab by lazy {
        KWebView {
            withId(R.id.page_actions_tab_layout)
        }
    }

    val saveButton by lazy {
        KView {
            withId(R.id.page_save)
    }.name(withParent("Save Button"))
}

}