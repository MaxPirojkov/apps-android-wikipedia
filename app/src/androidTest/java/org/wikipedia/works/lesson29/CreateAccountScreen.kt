package org.wikipedia.works.lesson29

import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.works.lesson20.NamedKScreen
import org.wikipedia.works.lesson20.name

object CreateAccountScreen : NamedKScreen<CreateAccountScreen>(){
    override val screenName: String = "Create account screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val loginButton = KTextView {
        withId(R.id.create_account_login_button)
    }.name(withParent("Login Button"))
}