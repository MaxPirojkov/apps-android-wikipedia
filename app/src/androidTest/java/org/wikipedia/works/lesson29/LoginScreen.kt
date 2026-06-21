package org.wikipedia.works.lesson29

import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.edit.KTextInputLayout
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matchers
import org.wikipedia.R
import org.wikipedia.works.lesson20.NamedKScreen
import org.wikipedia.works.lesson20.name
import org.hamcrest.Matchers.endsWith
import org.wikipedia.views.PlainPasteEditText

object LoginScreen : NamedKScreen<LoginScreen>() {
    override val screenName = "Login Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null


    val loginButton = KTextView {
        withId(R.id.login_button)
    }.name(withParent("Login button"))

    val userNameInput = KEditText {
        isDescendantOfA({ withId(R.id.login_username_text) })
        withClassName(Matchers.containsString("PlainPasteEditText"))
    }.name(withParent("Input User"))

    val passwordInput = KEditText {
        isDescendantOfA({withId(R.id.login_password_input)})
        withClassName(Matchers.containsString("PlainPasteEditText"))
    }.name(withParent("Input Password"))

}