package org.wikipedia.works.lesson24

import io.github.kakaocup.kakao.web.KWebView

class ReferenceListItem(kWebView: KWebView, xPath: String) :
    KWebViewItem<ReferenceListItem>(kWebView, xPath) {
    override val self: ReferenceListItem = this

    val index by lazy {
        child<KWebViewElement>("//a[contains(@class,'pcs-ref-back-link')]")
            .name(withParent("Number of reference"))
    }

    val content by lazy {
        child<KWebViewElement>(".//span[contains(@class,'mw-reference-text')]")
    }
}