package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import defpackage.C1001Vs;

/* JADX INFO: loaded from: classes2.dex */
public final class SpannableStringKt {
    public static final void clearSpans(Spannable spannable) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, int i, int i2, Object obj) {
        spannable.setSpan(obj, i, i2, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }

    public static final void set(Spannable spannable, C1001Vs c1001Vs, Object obj) {
        spannable.setSpan(obj, c1001Vs.getStart().intValue(), c1001Vs.getEndInclusive().intValue(), 17);
    }
}
