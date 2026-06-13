package org.wikipedia.works.lesson26

import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.works.lesson20.NamedKScreen
import org.wikipedia.works.lesson20.name

object NavBarScreen : NamedKScreen<NavBarScreen>() {
    override val screenName: String = "Navigation Bar"
    override val layoutId: Int = R.id.main_nav_tab_layout
    override val viewClass: Class<*>? = null

    val savedButton = KButton {
        withContentDescription("Saved")
        isDescendantOfA {
            withId(R.id.main_nav_tab_layout)
        }
    }.name(withParent("Button 'Saved'"))

    val exploreButton = KButton {
        withContentDescription("Explore")
        isDescendantOfA {
            withId(R.id.main_nav_tab_layout)
        }
    }.name(withParent("Button 'Explore'"))
}