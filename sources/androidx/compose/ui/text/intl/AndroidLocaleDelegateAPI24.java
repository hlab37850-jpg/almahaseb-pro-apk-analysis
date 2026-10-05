package androidx.compose.ui.text.intl;

import androidx.annotation.RequiresApi;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import defpackage.AbstractC4492zt;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 24)
public final class AndroidLocaleDelegateAPI24 implements PlatformLocaleDelegate {
    private LocaleList lastLocaleList;
    private android.os.LocaleList lastPlatformLocaleList;
    private final SynchronizedObject lock = Synchronization_jvmKt.createSynchronizedObject();

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public LocaleList getCurrent() {
        android.os.LocaleList localeList = android.os.LocaleList.getDefault();
        AbstractC4492zt.g(localeList, "getDefault()");
        synchronized (this.lock) {
            LocaleList localeList2 = this.lastLocaleList;
            if (localeList2 != null && localeList == this.lastPlatformLocaleList) {
                return localeList2;
            }
            int size = localeList.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                java.util.Locale locale = localeList.get(i);
                AbstractC4492zt.g(locale, "platformLocaleList[position]");
                arrayList.add(new Locale(new AndroidLocale(locale)));
            }
            LocaleList localeList3 = new LocaleList(arrayList);
            this.lastPlatformLocaleList = localeList;
            this.lastLocaleList = localeList3;
            return localeList3;
        }
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public PlatformLocale parseLanguageTag(String str) {
        AbstractC4492zt.h(str, "languageTag");
        java.util.Locale localeForLanguageTag = java.util.Locale.forLanguageTag(str);
        AbstractC4492zt.g(localeForLanguageTag, "forLanguageTag(languageTag)");
        return new AndroidLocale(localeForLanguageTag);
    }
}
