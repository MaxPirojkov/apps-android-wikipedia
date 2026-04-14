package org.wikipedia.works.lesson07.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.works.lesson20.name
import org.wikipedia.works.lesson20.withParent

class TopReadCardView(matcher: Matcher<View>) : KRecyclerItem<TopReadCardView>(matcher) {
    val titleHeader = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val headerText by lazy {
        KTextView(matcher) { withId(R.id.view_list_card_header) }
            .name(withParent("Title"))
    }

    val headerMenu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
        withDrawable(R.drawable.ic_more_vert_white_24dp)
    }

    val cardList = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.view_list_card_list)
        },
        itemTypeBuilder = {
            itemType(::TopReadCardItem)
        }
    )


}