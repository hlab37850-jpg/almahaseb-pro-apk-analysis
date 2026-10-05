package androidx.compose.animation.core;

import defpackage.AD;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0723Lm;

/* JADX INFO: loaded from: classes.dex */
public final class StartOffset {
    private final long value;

    private /* synthetic */ StartOffset(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StartOffset m114boximpl(long j) {
        return new StartOffset(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m116constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ long m117constructorimpl$default(int i, int i2, int i3, AbstractC0419Di abstractC0419Di) {
        if ((i3 & 2) != 0) {
            i2 = StartOffsetType.Companion.m132getDelayEo1U57Q();
        }
        return m115constructorimpl(i, i2);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m118equalsimpl(long j, Object obj) {
        return (obj instanceof StartOffset) && j == ((StartOffset) obj).m124unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m119equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getOffsetMillis-impl, reason: not valid java name */
    public static final int m120getOffsetMillisimpl(long j) {
        return Math.abs((int) j);
    }

    /* JADX INFO: renamed from: getOffsetType-Eo1U57Q, reason: not valid java name */
    public static final int m121getOffsetTypeEo1U57Q(long j) {
        boolean z = j > 0;
        if (z) {
            return StartOffsetType.Companion.m133getFastForwardEo1U57Q();
        }
        if (z) {
            throw new AD();
        }
        return StartOffsetType.Companion.m132getDelayEo1U57Q();
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m122hashCodeimpl(long j) {
        return AbstractC0723Lm.a(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m123toStringimpl(long j) {
        return "StartOffset(value=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m118equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m122hashCodeimpl(this.value);
    }

    public String toString() {
        return m123toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m124unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m115constructorimpl(int i, int i2) {
        return m116constructorimpl(i * i2);
    }
}
