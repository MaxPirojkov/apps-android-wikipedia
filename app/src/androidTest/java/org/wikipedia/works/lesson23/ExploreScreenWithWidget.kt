package org.wikipedia.works.lesson23


import androidx.compose.ui.test.hasAnyDescendant
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.wikipedia.R
import org.wikipedia.works.lesson20.NamedKScreen
import org.wikipedia.works.lesson20.name
import org.wikipedia.works.lesson23.HW.TopReadWidget

class ExploreScreenWithWidget: NamedKScreen<ExploreScreenWithWidget>() {
    override val screenName: String = "Explore Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_container)
        }.name(withParent("Widget of search"))
    }

    val topReadWidget by lazy {
        TopReadWidget(
            matcher = allOf(
                isDescendantOfA(withId(R.id.feed_view)),
                hasDescendant(withText("Top read"))
            )
        ) {}.name(withParent("Top Read - Widget"))
    }

}