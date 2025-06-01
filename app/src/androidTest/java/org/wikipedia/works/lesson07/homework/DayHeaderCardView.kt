package org.wikipedia.works.lesson07.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class DayHeaderCardView(matcher: Matcher<View>) : KRecyclerItem<DayHeaderCardView>(matcher) {
    val dayText = KTextView(matcher){
        withId(R.id.day_header_text)
    }
}