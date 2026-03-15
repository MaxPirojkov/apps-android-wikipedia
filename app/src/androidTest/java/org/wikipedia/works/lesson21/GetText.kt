package org.wikipedia.works.lesson21

import android.view.View
import android.widget.TextView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class GetText: ViewAction {

    var text1: String = ""

    fun getText() = text1

    override fun getConstraints(): Matcher<View?>? {
        return ViewMatchers.isAssignableFrom(TextView::class.java)
    }

    override fun getDescription(): String? {
        return "Get text"
    }

    override fun perform(
        uiController: UiController?,
        view: View?
    ) {
        text1 = (view as TextView).text.toString()
    }
}