package org.wikipedia.works.lesson22

import android.R.attr.targetClass
import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class HasIdAction(private val id: Int) : ViewAction {
    private var result: Boolean = false
    override fun getConstraints(): Matcher<View?>? {
        return ViewMatchers.isAssignableFrom(View::class.java)
    }

    override fun getDescription(): String {
        return "Check id"
    }

    override fun perform(
        uiController: UiController?,
        view: View?
    ) {
        if (view == null) {
            throw RuntimeException("Not found")
        }

        if (id == view.id) {
            result = true
        } else {
           val foundView = view.findViewById<View>(id)
            result = foundView != null
        }
    }

    fun getResult() = result

 }