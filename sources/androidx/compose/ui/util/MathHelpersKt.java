package androidx.compose.ui.util;

import defpackage.AbstractC1210aB;

/* JADX INFO: loaded from: classes.dex */
public final class MathHelpersKt {
    public static final float lerp(float f, float f2, float f3) {
        return ((1 - f3) * f) + (f3 * f2);
    }

    public static final int lerp(int i, int i2, float f) {
        return i + AbstractC1210aB.b(((double) (i2 - i)) * ((double) f));
    }

    public static final long lerp(long j, long j2, float f) {
        return j + AbstractC1210aB.d((j2 - j) * ((double) f));
    }
}
