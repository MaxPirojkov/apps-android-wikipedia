package org.wikipedia.works.lesson22

import org.wikipedia.R
import org.wikipedia.works.lesson07.homework.CustomizeCardView
import org.wikipedia.works.lesson07.homework.SearchCardViewItem
import org.wikipedia.works.lesson20.ExploreScreenNew

fun ExploreScreenNew.searchBlock(): SearchCardViewItem {
    return feedRecycler.findById<SearchCardViewItem>(
        targetIndex = 1,
        targetID = R.id.voice_search_button,
        limiter = 5,
        blockName = "Search block"
    )
}

fun ExploreScreenNew.announcementBlock(block: CustomizeCardView.() -> Unit) {
    feedRecycler.invokeById<CustomizeCardView>(
        1,
        R.id.view_announcement_header_image,
        "Announcement block",
        5,
        block
    )
}