package org.wikipedia.works.lesson23.HW

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.works.lesson20.name
import org.wikipedia.works.lesson20.withParent
import kotlin.getValue

class TopReadCardWidget(matcher: Matcher<View>) : KRecyclerItem<TopReadCardWidget>(matcher) {
    val numberOfCard by lazy {
        KTextView(matcher) {
            withId(R.id.baseNumberView)
        }.name(withParent("Number of card"))
    }

    val itemTitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.name(withParent("Title card"))
    }

    val itemSubtitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_subtitle)
        }.name(withParent("Subtitle card"))
    }
}