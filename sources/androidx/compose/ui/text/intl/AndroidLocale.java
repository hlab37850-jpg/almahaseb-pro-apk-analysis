package androidx.compose.ui.text.intl;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidLocale implements PlatformLocale {
    private final java.util.Locale javaLocale;

    public AndroidLocale(java.util.Locale locale) {
        AbstractC4492zt.h(locale, "javaLocale");
        this.javaLocale = locale;
    }

    public final java.util.Locale getJavaLocale() {
        return this.javaLocale;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocale
    public String getLanguage() {
        String language = this.javaLocale.getLanguage();
        AbstractC4492zt.g(language, "javaLocale.language");
        return language;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocale
    public String getRegion() {
        String country = this.javaLocale.getCountry();
        AbstractC4492zt.g(country, "javaLocale.country");
        return country;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocale
    public String getScript() {
        String script = this.javaLocale.getScript();
        AbstractC4492zt.g(script, "javaLocale.script");
        return script;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocale
    public String toLanguageTag() {
        String languageTag = this.javaLocale.toLanguageTag();
        AbstractC4492zt.g(languageTag, "javaLocale.toLanguageTag()");
        return languageTag;
    }
}
