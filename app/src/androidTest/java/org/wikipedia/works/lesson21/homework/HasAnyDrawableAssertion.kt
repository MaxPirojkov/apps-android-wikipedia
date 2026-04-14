package org.wikipedia.works.lesson21.homework

import android.R
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert
import org.wikipedia.works.lesson05.image

open class HasAnyDrawableAssertion : ViewAssertion {
    override fun check(
        view: View?,
        noViewFoundException: NoMatchingViewException?
    ) {
        if (view is ImageView) {
            Assert.assertTrue("Must have drawable", view.drawable != null)
        } else {
           throw noViewFoundException ?: AssertionError("View is not ImageView")
        }
    }
}