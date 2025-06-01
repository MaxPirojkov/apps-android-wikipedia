package org.wikipedia.works.lesson07

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

object OnboardingScreen: KScreen<OnboardingScreen>() {
    override val layoutId = R.layout.fragment_onboarding_pager
    override val viewClass = null

    val slider = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType( ::OnboardingPagerFirstItem)
            itemType(::OnboardingPagerSecondItem)
        }
    )
    fun OnboardingScreen.firstPage(block: OnboardingPagerFirstItem.() -> Unit) {
        slider.childAt(0, block)
    }

    fun OnboardingScreen.secondPage(block: OnboardingPagerSecondItem.() -> Unit) {
        slider.childAt(1, block)
    }
}

class OnboardingPagerFirstItem(
    matcher: Matcher<View>
) : KViewPagerItem<OnboardingPagerFirstItem>(matcher) {

    val mainLogoImage = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }

    val textTitle = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }

    val textSubtitle = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }

    val languages = KRecyclerView(
        builder = {
            withId(R.id.languageList)
        },
        itemTypeBuilder = {
            itemType(::LanguageItem)
        }
    )

    val addLanguages = KButton(matcher) {
        withId(R.id.addLanguageButton)
    }
}

class OnboardingPagerSecondItem(
    matcher: Matcher<View>
) : KViewPagerItem<OnboardingPagerSecondItem>(matcher) {
    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }

    val textPrimary = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }

    val textSecondary = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }
}

class LanguageItem(matcher: Matcher<View>): KRecyclerItem<LanguageItem>(matcher) {
    val textView = KTextView(matcher) {
        withId(R.id.option_label)
    }
}