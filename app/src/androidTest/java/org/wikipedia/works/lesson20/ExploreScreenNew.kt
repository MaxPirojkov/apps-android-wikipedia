package org.wikipedia.works.lesson20

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.works.lesson07.homework.CustomizeCardView
import org.wikipedia.works.lesson07.homework.DayHeaderCardView
import org.wikipedia.works.lesson07.homework.FeaturedArticleItem
import org.wikipedia.works.lesson07.homework.InTheNews
import org.wikipedia.works.lesson07.homework.SearchCardViewItem
import org.wikipedia.works.lesson07.homework.TopReadCardItem
import org.wikipedia.works.lesson07.homework.TopReadCardView

object ExploreScreenNew : NamedKScreen<ExploreScreenNew>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null
    override val screenName = "Main screen"

    val toolbarTitle = KImageView {
        withId(R.id.main_toolbar_wordmark) }
        .name(withParent("Title"))

val feedRecycler = KRecyclerView(
    builder = {
        withId(R.id.feed_view)
    },
    itemTypeBuilder = {
        itemType(::SearchCardViewItem)
        itemType(::CustomizeCardView)
        itemType(::DayHeaderCardView)
        itemType(::TopReadCardView)
        itemType(::InTheNews)
        itemType(::FeaturedArticleItem)
    }
).name(withParent("List of blocks"))

fun topReadItem(index: Int, function: TopReadCardItem.() -> Unit) {
    feedRecycler.invokeAtIndex(index, function)
}

fun topReadItem(): TopReadCardItem {
    return feedRecycler.childWith<TopReadCardItem> {
        withDescendant {
            withText("Top read")
        }
    }.name(feedRecycler.getName().withParent("Top read"))
}



}