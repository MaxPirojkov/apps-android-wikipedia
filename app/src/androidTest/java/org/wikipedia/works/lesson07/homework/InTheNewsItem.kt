package org.wikipedia.works.lesson07.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class InTheNewsItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsItem>(matcher) {
    val imageItem = KImageView(matcher) {
        withId(R.id.horizontal_scroll_list_item_image)
    }

    val textItem = KTextView(matcher) {
        withId(R.id.horizontal_scroll_list_item_text)
    }
}