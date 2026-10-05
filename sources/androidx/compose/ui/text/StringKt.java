package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidStringDelegate_androidKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class StringKt {
    private static final PlatformStringDelegate stringDelegate = AndroidStringDelegate_androidKt.ActualStringDelegate();

    public static final String capitalize(String str, Locale locale) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(locale, "locale");
        return stringDelegate.capitalize(str, locale.getPlatformLocale$ui_text_release());
    }

    public static final String decapitalize(String str, Locale locale) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(locale, "locale");
        return stringDelegate.decapitalize(str, locale.getPlatformLocale$ui_text_release());
    }

    public static final String toLowerCase(String str, Locale locale) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(locale, "locale");
        return stringDelegate.toLowerCase(str, locale.getPlatformLocale$ui_text_release());
    }

    public static final String toUpperCase(String str, Locale locale) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(locale, "locale");
        return stringDelegate.toUpperCase(str, locale.getPlatformLocale$ui_text_release());
    }

    public static final String capitalize(String str, LocaleList localeList) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(localeList, "localeList");
        return capitalize(str, localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0));
    }

    public static final String decapitalize(String str, LocaleList localeList) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(localeList, "localeList");
        return decapitalize(str, localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0));
    }

    public static final String toLowerCase(String str, LocaleList localeList) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(localeList, "localeList");
        return toLowerCase(str, localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0));
    }

    public static final String toUpperCase(String str, LocaleList localeList) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(localeList, "localeList");
        return toUpperCase(str, localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0));
    }
}
