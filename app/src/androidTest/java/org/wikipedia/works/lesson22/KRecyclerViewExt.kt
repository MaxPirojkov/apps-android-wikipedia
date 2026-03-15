package org.wikipedia.works.lesson22

import android.content.res.Resources
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.works.lesson20.getName
import org.wikipedia.works.lesson20.name
import kotlin.math.min

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeById(
    targetIndex: Int,       //индекс нужного блока
    targetID: Int,     //
    blockName: String,
    limiter: Int,      //огранчиение по поиску блоков
    function: T.() -> Unit
) {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetID)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                name(recycler.getName().withParent("$targetIndex's block of $blockName"))
                function()
            }
        }
    }
    throw NoSuchElementException("Not found block with $targetIndex index of $blockName")
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.findById(
    targetIndex: Int,       //индекс нужного блока
    targetID: Int,     //
    limiter: Int,
    blockName: String
): T {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) { ->
            if (hasIdAction(targetID)) findBlockCounter++
            if (findBlockCounter == targetIndex) {
                name(recycler.getName().withParent("$targetIndex's block of $blockName"))
                return this
            }
        }
    }
    throw NoSuchElementException("Not found block with $targetIndex index of $blockName")
}
