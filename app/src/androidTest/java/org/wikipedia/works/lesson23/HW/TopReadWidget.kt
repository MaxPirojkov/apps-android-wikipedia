package org.wikipedia.works.lesson23.HW

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.aggregated.AggregatedFeedContentClient
import org.wikipedia.works.lesson07.homework.FeaturedArticleItem
import org.wikipedia.works.lesson07.homework.TopReadCardItem
import org.wikipedia.works.lesson07.homework.TopReadCardView
import org.wikipedia.works.lesson20.ExploreScreenNew
import org.wikipedia.works.lesson20.invokeAtIndex
import org.wikipedia.works.lesson20.name
import org.wikipedia.works.lesson20.withParent
import org.wikipedia.works.lesson23.KWidget

class TopReadWidget : KWidget<TopReadWidget> {
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)

    val titleHeader by lazy {
        KTextView(parent) {
            withId(R.id.view_card_header_title)
        }.name(withParent("title Top read"))
    }


    val cardList by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.view_list_card_list)
            },
            itemTypeBuilder = {
                itemType(::TopReadCardWidget)
            }
        ).name(withParent("Card in widget Top Read"))
    }

    fun openArticleAt(index: Int, function: TopReadCardWidget.() -> Unit) {
        cardList.invokeAtIndex(index, function)
    }

    val scrollToTopRead by lazy {
        ExploreScreenNew.feedRecycler.childWith<TopReadCardView> {
            withDescendant {
                withText("Top read")
            }
        }.name(withParent("Top Read container"))
    }

}