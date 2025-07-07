package org.wikipedia.works.lesson07.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class ArticlesItem(matcher: Matcher<View>) : KRecyclerItem<ArticlesItem>(matcher) {
    val itemTitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }

    val itemSubtitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }
}