package org.wikipedia.works.homework03

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.views.AppTextView

val onboardingImage = listOf(
    AppCompatImageView::class.java,
    "imageViewCentered",
    "illustration_onboarding_explore"
)

val primaryText = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "onboarding_welcome_title_v2"
)

val secondaryText = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "onboarding_multilingual_secondary_text"
)

val languageList = listOf(
    RecyclerView::class.java,
    "languagesList"
)

val addLanguageButton = listOf(
    MaterialButton::class.java,
    "addLanguageButton",
    "onboarding_multilingual_add_language_text"
)

val skipButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip"
)

val tabLayout = listOf(
    TabLayout::class.java,
    "view_onboarding_page_indicator"
)

val continueButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_forward_button",
    "onboarding_continue"
)

val primaryTextSecondPage = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "onboarding_explore_title"
)

val secondaryTextSecondPage = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "onboarding_explore_text"
)

val primaryTextThirdPage = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "onboarding_reading_list_sync_title"
)

val secondaryTextThirdPage = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "onboarding_reading_list_sync_text_v2"
)

val primaryTextFourthPage = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "onboarding_data_privacy_title"
)

val secondaryTextFourthPage = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "onboarding_data_privacy_text"
)

val getStartedButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_done_button",
    "onboarding_get_started"
)

/*
Переменную проинициализировать списком,
в который нужно добавить класс экранного элемента,
его ID если он есть в виде строки,
ID текстового значения элемента, если оно есть.
ID текстового элемента можно найти поиском по проекту текста элемента.
 */