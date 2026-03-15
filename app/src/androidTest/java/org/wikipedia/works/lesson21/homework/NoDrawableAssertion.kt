package org.wikipedia.works.lesson21.homework

import android.view.View
import android.widget.ImageView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert
import org.wikipedia.dataclient.donate.Campaign

class NoDrawableAssertion : ViewAssertion {
    override fun check(
        view: View?,
        noViewFoundException: NoMatchingViewException?
    ) {
        if (view is ImageView) {
            Assert.assertNull("Must have not drawable", view.drawable)
        } else {
            noViewFoundException ?: AssertionError("View is not ImageView")
        }
    }
}