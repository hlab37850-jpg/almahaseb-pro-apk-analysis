package androidx.compose.ui.text;

import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class TextRangeKt {
    public static final long TextRange(int i, int i2) {
        return TextRange.m4694constructorimpl(packWithCheck(i, i2));
    }

    /* JADX INFO: renamed from: coerceIn-8ffj60Q, reason: not valid java name */
    public static final long m4711coerceIn8ffj60Q(long j, int i, int i2) {
        int iL = AbstractC3871sJ.l(TextRange.m4705getStartimpl(j), i, i2);
        int iL2 = AbstractC3871sJ.l(TextRange.m4700getEndimpl(j), i, i2);
        return (iL == TextRange.m4705getStartimpl(j) && iL2 == TextRange.m4700getEndimpl(j)) ? j : TextRange(iL, iL2);
    }

    private static final long packWithCheck(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException(("start cannot be negative. [start: " + i + ", end: " + i2 + ']').toString());
        }
        if (i2 >= 0) {
            return (((long) i2) & 4294967295L) | (((long) i) << 32);
        }
        throw new IllegalArgumentException(("end cannot be negative. [start: " + i + ", end: " + i2 + ']').toString());
    }

    /* JADX INFO: renamed from: substring-FDrldGo, reason: not valid java name */
    public static final String m4712substringFDrldGo(CharSequence charSequence, long j) {
        AbstractC4492zt.h(charSequence, "$this$substring");
        return charSequence.subSequence(TextRange.m4703getMinimpl(j), TextRange.m4702getMaximpl(j)).toString();
    }

    public static final long TextRange(int i) {
        return TextRange(i, i);
    }
}
