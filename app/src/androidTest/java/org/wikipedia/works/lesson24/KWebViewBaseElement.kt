package org.wikipedia.works.lesson24

import androidx.test.espresso.web.webdriver.Locator
import io.github.kakaocup.kakao.web.KWebView
import io.github.kakaocup.kakao.web.WebElementBuilder.KWebInteraction
import org.wikipedia.works.lesson20.NameHierarchy

abstract class KWebViewBaseElement<T: KWebViewBaseElement<T>>(
    val kWebView: KWebView,
    val xPath: String
) {

    abstract val self: T
    private var name: NameHierarchy = NameHierarchy("No label")

    inline fun <reified T : KWebViewBaseElement<T>> child(childXPath: String): T {
        return T::class.java
            .getConstructor(KWebView::class.java, String::class.java)
            .newInstance(kWebView, "${this.xPath}$childXPath")
    }

    operator fun invoke(function: T.() -> Unit) {
        function(self)
    }

    infix fun perform(function: T.() -> Unit): T {
        function(self)
        return self
    }

    fun executeAction(interaction: KWebInteraction.() -> Unit) {
        kWebView {
            withElement(Locator.XPATH, xPath, interaction)
        }
    }

    fun name(thisName: NameHierarchy): T {
        this.name = thisName
        return self
    }

    fun getName(): NameHierarchy = name

    fun withParent(elementName: String): NameHierarchy = NameHierarchy(elementName, name)


}