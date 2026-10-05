package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class SpannedStringKt {
    public static final /* synthetic */ <T> T[] getSpans(Spanned spanned, int i, int i2) {
        AbstractC4492zt.m(4, "T");
        return (T[]) spanned.getSpans(i, i2, Object.class);
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = spanned.length();
        }
        AbstractC4492zt.m(4, "T");
        return spanned.getSpans(i, i2, Object.class);
    }

    public static final Spanned toSpanned(CharSequence charSequence) {
        return SpannedString.valueOf(charSequence);
    }
}
