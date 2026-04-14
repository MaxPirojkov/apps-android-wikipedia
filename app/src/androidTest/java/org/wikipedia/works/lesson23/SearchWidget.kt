package org.wikipedia.works.lesson23

import android.view.View
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.works.lesson20.name
import org.wikipedia.works.lesson20.withParent

class SearchWidget : KWidget<SearchWidget> {
    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)
    constructor(function: ViewBuilder.() -> Unit) : super(function)

    val searchIcon by lazy {
        KImageView(parent) {
            withDrawable(R.drawable.ic_search_white_24dp)
        }.name(withParent("Search icon"))
    }

    val voiceIcon by lazy {
        KImageView(parent) {
            withId(R.id.voice_search_button)
        }.name(withParent("Voice icon"))
    }
}