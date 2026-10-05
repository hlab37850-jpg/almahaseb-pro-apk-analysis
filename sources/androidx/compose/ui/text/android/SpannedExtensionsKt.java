package androidx.compose.ui.text.android;

import android.text.Spanned;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class SpannedExtensionsKt {
    public static final boolean hasSpan(Spanned spanned, Class<?> cls) {
        AbstractC4492zt.h(spanned, "<this>");
        AbstractC4492zt.h(cls, "clazz");
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }

    public static final boolean hasSpan(Spanned spanned, Class<?> cls, int i, int i2) {
        AbstractC4492zt.h(spanned, "<this>");
        AbstractC4492zt.h(cls, "clazz");
        return spanned.nextSpanTransition(i - 1, i2, cls) != i2;
    }
}
