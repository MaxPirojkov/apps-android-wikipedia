package org.wikipedia.works.lesson07.homework

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadCardItem(matcher: Matcher<View>) : KRecyclerItem<TopReadCardItem>(matcher) {
    val numberOfCard = KTextView(matcher) {
        withId(R.id.numberView)
    }

    val itemTitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }

    val itemSubtitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }

    val itemGraph = KView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }

    val itemImage = KImageView(matcher) {
        withId(R.id.view_list_card_item_image)
    }

    val pageViews = KTextView(matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }
}