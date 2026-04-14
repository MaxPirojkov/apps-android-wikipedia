package org.wikipedia.works.lesson07.homework

import android.view.View
import androidx.test.espresso.action.CoordinatesProvider
import com.kaspersky.components.kautomator.component.common.views.UiView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.works.lesson20.name
import org.wikipedia.works.lesson20.withParent


class FeaturedArticleItem(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticleItem>(matcher) {

    val title = KTextView {
        withId(R.id.view_card_header_title)
    }

    val articleImage by lazy {
        KImageView(matcher) {
            withId(R.id.articleImage)
        }.name(withParent("Image article"))
    }

    val articleTitle = KTextView {
        withId(R.id.articleTitle)
    }

    val articleDescription = KTextView {
        withId(R.id.articleDescription)
    }

    val articleExtract = KTextView {
        withId(R.id.articleExtract)
    }
}