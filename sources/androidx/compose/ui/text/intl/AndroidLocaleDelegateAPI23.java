package androidx.compose.ui.text.intl;

import defpackage.AbstractC1805bc;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidLocaleDelegateAPI23 implements PlatformLocaleDelegate {
    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public LocaleList getCurrent() {
        java.util.Locale locale = java.util.Locale.getDefault();
        AbstractC4492zt.g(locale, "getDefault()");
        return new LocaleList((List<Locale>) AbstractC1805bc.e(new Locale(new AndroidLocale(locale))));
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public PlatformLocale parseLanguageTag(String str) {
        AbstractC4492zt.h(str, "languageTag");
        java.util.Locale localeForLanguageTag = java.util.Locale.forLanguageTag(str);
        AbstractC4492zt.g(localeForLanguageTag, "forLanguageTag(languageTag)");
        return new AndroidLocale(localeForLanguageTag);
    }
}
