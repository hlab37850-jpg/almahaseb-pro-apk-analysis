package androidx.compose.ui.text.platform.extensions;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC3103iw;
import defpackage.AbstractC3185jw;
import defpackage.AbstractC4492zt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public final class LocaleListHelperMethods {
    public static final LocaleListHelperMethods INSTANCE = new LocaleListHelperMethods();

    private LocaleListHelperMethods() {
    }

    @DoNotInline
    @RequiresApi(24)
    public final Object localeSpan(LocaleList localeList) {
        AbstractC4492zt.h(localeList, "localeList");
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(localeList, 10));
        Iterator<Locale> it = localeList.iterator();
        while (it.hasNext()) {
            arrayList.add(LocaleExtensions_androidKt.toJavaLocale(it.next()));
        }
        java.util.Locale[] localeArr = (java.util.Locale[]) arrayList.toArray(new java.util.Locale[0]);
        return AbstractC3185jw.a(AbstractC3103iw.a((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }

    @DoNotInline
    @RequiresApi(24)
    public final void setTextLocales(AndroidTextPaint androidTextPaint, LocaleList localeList) {
        AbstractC4492zt.h(androidTextPaint, "textPaint");
        AbstractC4492zt.h(localeList, "localeList");
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(localeList, 10));
        Iterator<Locale> it = localeList.iterator();
        while (it.hasNext()) {
            arrayList.add(LocaleExtensions_androidKt.toJavaLocale(it.next()));
        }
        java.util.Locale[] localeArr = (java.util.Locale[]) arrayList.toArray(new java.util.Locale[0]);
        androidTextPaint.setTextLocales(AbstractC3103iw.a((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }
}
