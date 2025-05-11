package org.wikipedia.works.lesson05.homework

import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.R.id
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

val themeSlidout = KView {
    withId(id.design_bottom_sheet)
}

val textTitleReading = KTextView {
    withId(R.id.textSettingsCategory)
    withText(R.string.theme_category_reading)
}

val textPlaceholderSizePercent = KTextView {
    withId(R.id.text_size_percent)
}

val decreaseTextSize = KTextView {
    withId(R.id.buttonDecreaseTextSize)
}

val increaseTextSize = KTextView {
    withId(R.id.buttonIncreaseTextSize)
}

val textSizeBar = KView {
    withId(R.id.text_size_seek_bar)
}

val buttonFontSansSerif = KButton {
    withId(R.id.button_font_family_sans_serif)
}

val buttonFontSerif = KButton {
    withId(R.id.button_font_family_serif)
}

val imageGlasess = KImageView {
    withParent {
        withId(R.id.readingFocusModeContainer)
    }
    isInstanceOf(AppCompatImageView::class.java)
   // withDrawable(R.drawable.ic_icon_reading_focus_mode)
}

val switcherReadingMode = KSwitch {
    withId(R.id.theme_chooser_reading_focus_mode_switch)
    withText(R.string.reading_focus_mode)
}

val textReadingModeDescription = KTextView {
    withId(R.id.theme_chooser_reading_focus_mode_description)
    withText(R.string.reading_focus_mode_detail)
}

val textTitleTheme = KTextView {
    isDescendantOfA { withId(id.design_bottom_sheet) }
    withText(R.string.color_theme_select)
}

val lightThemeButton = KButton {
    withId(R.id.button_theme_light)
}

val sepiaThemeButton = KButton {
    withId(R.id.button_theme_sepia)
}

val darkThemeButton = KButton {
    withId(R.id.button_theme_dark)
}

val blackThemeButton = KButton {
    withId(R.id.button_theme_black)
}

val matchSystemThemeSwitcher = KSwitch {
    withId(R.id.theme_chooser_match_system_theme_switch)
    withText(R.string.theme_chooser_dialog_match_system_theme_switch_label)
}

val imageInDarkThemeSwitcher = KSwitch {
    withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    withText(R.string.theme_chooser_dialog_image_dimming_switch_label)
}