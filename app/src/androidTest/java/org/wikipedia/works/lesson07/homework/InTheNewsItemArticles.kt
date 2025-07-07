package org.wikipedia.works.lesson07.homework

import android.widget.ImageView
import androidx.compose.foundation.Image
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object InTheNewsItemArticles: KScreen<InTheNewsItemArticles>() {
    override val layoutId = null
    override val viewClass = null

    val headerImage = KImageView {
        withId(R.id.header_image_view)
    }

    val itemText = KTextView {
        withId(R.id.story_text_view)
    }

    val itemRecycler = KRecyclerView (
        builder = {
            withId(R.id.news_story_items_recyclerview)
        },
        itemTypeBuilder = {
            itemType(::ArticlesItem)
        }
    )
}