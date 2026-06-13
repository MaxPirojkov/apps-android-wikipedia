package org.wikipedia.works.lesson26

class ListOfSmartScenario(private val list: List<BaseSmartScenario>) {
    fun execute() : Boolean = list.any { it.init() }
}