package org.wikipedia.works.lesson26

import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.works.lesson20.NamedKScreen
import org.wikipedia.R
import org.wikipedia.works.lesson20.name


object SavedScreen : NamedKScreen<SavedScreen>() {
    override val screenName: String = "Saved"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val notNowButton = KButton {
        withId(R.id.negativeButton)
    }.name(withParent("Button 'Not now'"))

}