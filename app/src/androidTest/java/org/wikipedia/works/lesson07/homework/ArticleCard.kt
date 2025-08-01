package org.wikipedia.works.lesson07.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ArticleCard: KScreen<ArticleCard>() {
    override val layoutId = null
    override val viewClass = null

    val articleImage = KImageView {
        withId(R.id.articleImage)
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