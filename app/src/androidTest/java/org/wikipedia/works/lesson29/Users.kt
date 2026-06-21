package org.wikipedia.works.lesson29

import org.wikipedia.BuildConfig

object Users {
    val alphaLogin = "alphaLogin"
    val bettaLogin = "bettaLogin"
    val Wikitest8767 = "Wikitest8767"
}

object Credentials {
    val map = mapOf(
        Users.alphaLogin to BuildConfig.alphaLogin,
        Users.bettaLogin to BuildConfig.bettaLogin,
        Users.Wikitest8767 to BuildConfig.Wikitest8767
    )

    fun getPassword(user: String) : String {
        return map.getOrElse(user) {
            throw IllegalArgumentException("$user don't find")
        }
    }
}