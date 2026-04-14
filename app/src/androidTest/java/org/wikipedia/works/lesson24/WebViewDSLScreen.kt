package org.wikipedia.works.lesson24

import com.kaspersky.components.kautomator.component.text.UiTextView
import org.wikipedia.R
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.works.lesson20.NamedKScreen

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
        KWebViewList(webView, "//*[@id='References']/following::ol[@class='mw-references references']")
            .name(withParent("List of References"))
    }

    fun referencesList(): KWebViewList {
        return references
    }


    fun referenceAt(index: Int, block: ReferenceListItem.() -> Unit) {
        referencesList().childAt<ReferenceListItem>(index) { block() }
    }

}