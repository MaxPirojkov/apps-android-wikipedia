package org.wikipedia.language

import android.content.Context
import org.wikipedia.Constants
import org.wikipedia.R
import org.wikipedia.WikipediaApp
import org.wikipedia.settings.Prefs
import org.wikipedia.util.L10nUtil
import org.wikipedia.util.ReleaseUtil
import java.util.Locale

class AppLanguageState(context: Context) {

    private val appLanguageLookUpTable = AppLanguageLookUpTable(context)

    // Language codes that have been explicitly chosen by the user in most recently used order. This
    // list includes both app and article languages.
    private val _mruLanguageCodes = Prefs.mruLanguageCodeList.toMutableList()
    private val _appLanguageCodes = Prefs.appLanguageCodeList.toMutableList()

    init {
        initAppLanguageCodes()
    }

    val appLanguageCodes: List<String>
        get() {
            if (_appLanguageCodes.isEmpty()) {
                // very bad, should not happen.
                initAppLanguageCodes()
            }
            return _appLanguageCodes
        }

    val mruLanguageCodes: List<String>
        get() = _mruLanguageCodes

    val appLanguageCode: String
        get() = appLanguageCodes.first()

    val remainingSuggestedLanguageCodes: List<String>
        get() = LanguageUtil.suggestedLanguagesFromSystem.filter { !_appLanguageCodes.contains(it) && appLanguageLookUpTable.isSupportedCode(it) }

    val systemLanguageCode: String
        get() {
            val code = LanguageUtil.localeToWikiLanguageCode(Locale.getDefault())
            return if (appLanguageLookUpTable.isSupportedCode(code)) code else AppLanguageLookUpTable.FALLBACK_LANGUAGE_CODE
        }

    val appMruLanguageCodes: List<String>
        get() {
            val codes = appLanguageLookUpTable.codes.toMutableList()
            var insertIndex = 0
            for (code in _mruLanguageCodes) {
                if (codes.contains(code)) {
                    codes.remove(code)
                    codes.add(insertIndex, code)
                    ++insertIndex
                }
            }
            if (!Prefs.isShowDeveloperSettingsEnabled && !ReleaseUtil.isPreBetaRelease) {
                codes.remove(AppLanguageLookUpTable.TEST_LANGUAGE_CODE)
            }
            if (!Prefs.isShowDeveloperSettingsEnabled) {
                codes.remove(AppLanguageLookUpTable.TRADITIONAL_CHINESE_LANGUAGE_CODE)
                codes.remove(AppLanguageLookUpTable.SIMPLIFIED_CHINESE_LANGUAGE_CODE)
            }
            return codes
        }

    val appLanguageLocalizedNames: String
        get() {
            return appLanguageCodes.joinToString(", ") {
                getAppLanguageLocalizedName(it).orEmpty()
            }
        }

    fun addMruLanguageCode(code: String) {
        _mruLanguageCodes.remove(code)
        _mruLanguageCodes.add(0, code)
        Prefs.mruLanguageCodeList = _mruLanguageCodes
    }

    /** @return English name if app language is supported.
     */
    fun getAppLanguageCanonicalName(code: String?): String? {
        return if (!code.isNullOrEmpty()) {
            appLanguageLookUpTable.getCanonicalName(code).orEmpty().ifEmpty { code }
        } else {
            null
        }
    }

    /** @return Native name if app language is supported.
     */
    fun getAppLanguageLocalizedName(code: String?): String? {
        return if (!code.isNullOrEmpty()) {
            appLanguageLookUpTable.getLocalizedName(code).orEmpty().ifEmpty { code }
        } else {
            null
        }
    }

    fun getLanguageVariants(code: String?): List<String>? {
        return appLanguageLookUpTable.getLanguageVariants(code)
    }

    fun getDefaultLanguageCode(code: String?): String? {
        return appLanguageLookUpTable.getDefaultLanguageCodeFromVariant(code)
    }

    fun getLanguageCodeIndex(code: String?): Int {
        return appLanguageLookUpTable.indexOfCode(code)
    }

    fun addAppLanguageCode(code: String) {
        _appLanguageCodes.remove(code)
        _appLanguageCodes.add(code)
        Prefs.appLanguageCodeList = _appLanguageCodes
        WikipediaApp.instance.resetWikiSite()
    }

    fun setAppLanguageCodes(codes: List<String>) {
        _appLanguageCodes.clear()
        _appLanguageCodes.addAll(codes.filter { it.isNotEmpty() })
        Prefs.appLanguageCodeList = _appLanguageCodes
        WikipediaApp.instance.resetWikiSite()
    }

    fun removeAppLanguageCodes(codes: List<String>) {
        if (_appLanguageCodes.size > 1) {
            _appLanguageCodes.removeAll(codes)
            Prefs.appLanguageCodeList = _appLanguageCodes
        }
    }

    fun getWikiLanguageName(langCode: String): String {
        return when (langCode) {
            Constants.WIKI_CODE_COMMONS -> L10nUtil.getString(R.string.wikimedia_commons)
            Constants.WIKI_CODE_WIKIDATA -> L10nUtil.getString(R.string.wikidata)
            else -> getAppLanguageLocalizedName(langCode).orEmpty().ifEmpty { langCode }
        }
    }

    fun getBcp47LanguageCode(langCode: String): String {
        return appLanguageLookUpTable.getBcp47Code(langCode)
    }

    private fun initAppLanguageCodes() {
        if (_appLanguageCodes.isEmpty()) {
            if (Prefs.isInitialOnboardingEnabled) {
                setAppLanguageCodes(remainingSuggestedLanguageCodes)
            } else {
                // If user has never changed app language before
                addAppLanguageCode(systemLanguageCode)
            }
        }
        if (_appLanguageCodes.isEmpty()) {
            // If the language list is still empty, add the fallback language.
            // This is for devices that have very nonstandard language configurations, or
            // variants of languages that we don't support yet.
            addAppLanguageCode(systemLanguageCode)
        }
    }
}
