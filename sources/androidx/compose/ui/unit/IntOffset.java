package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0723Lm;
import defpackage.AbstractC1210aB;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class IntOffset {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = IntOffsetKt.IntOffset(0, 0);
    private final long packedValue;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getZero-nOcc-ac, reason: not valid java name */
        public final long m5288getZeronOccac() {
            return IntOffset.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ IntOffset(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntOffset m5269boximpl(long j) {
        return new IntOffset(j);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m5270component1impl(long j) {
        return m5278getXimpl(j);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m5271component2impl(long j) {
        return m5279getYimpl(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m5272constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: copy-iSbpLlY, reason: not valid java name */
    public static final long m5273copyiSbpLlY(long j, int i, int i2) {
        return IntOffsetKt.IntOffset(i, i2);
    }

    /* JADX INFO: renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static /* synthetic */ long m5274copyiSbpLlY$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = m5278getXimpl(j);
        }
        if ((i3 & 2) != 0) {
            i2 = m5279getYimpl(j);
        }
        return m5273copyiSbpLlY(j, i, i2);
    }

    @Stable
    /* JADX INFO: renamed from: div-Bjo55l4, reason: not valid java name */
    public static final long m5275divBjo55l4(long j, float f) {
        return IntOffsetKt.IntOffset(AbstractC1210aB.c(m5278getXimpl(j) / f), AbstractC1210aB.c(m5279getYimpl(j) / f));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5276equalsimpl(long j, Object obj) {
        return (obj instanceof IntOffset) && j == ((IntOffset) obj).m5287unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5277equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final int m5278getXimpl(long j) {
        return (int) (j >> 32);
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final int m5279getYimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5280hashCodeimpl(long j) {
        return AbstractC0723Lm.a(j);
    }

    @Stable
    /* JADX INFO: renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m5281minusqkQi6aY(long j, long j2) {
        return IntOffsetKt.IntOffset(m5278getXimpl(j) - m5278getXimpl(j2), m5279getYimpl(j) - m5279getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m5282plusqkQi6aY(long j, long j2) {
        return IntOffsetKt.IntOffset(m5278getXimpl(j) + m5278getXimpl(j2), m5279getYimpl(j) + m5279getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: rem-Bjo55l4, reason: not valid java name */
    public static final long m5283remBjo55l4(long j, int i) {
        return IntOffsetKt.IntOffset(m5278getXimpl(j) % i, m5279getYimpl(j) % i);
    }

    @Stable
    /* JADX INFO: renamed from: times-Bjo55l4, reason: not valid java name */
    public static final long m5284timesBjo55l4(long j, float f) {
        return IntOffsetKt.IntOffset(AbstractC1210aB.c(m5278getXimpl(j) * f), AbstractC1210aB.c(m5279getYimpl(j) * f));
    }

    @Stable
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5285toStringimpl(long j) {
        return '(' + m5278getXimpl(j) + ", " + m5279getYimpl(j) + ')';
    }

    @Stable
    /* JADX INFO: renamed from: unaryMinus-nOcc-ac, reason: not valid java name */
    public static final long m5286unaryMinusnOccac(long j) {
        return IntOffsetKt.IntOffset(-m5278getXimpl(j), -m5279getYimpl(j));
    }

    public boolean equals(Object obj) {
        return m5276equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5280hashCodeimpl(this.packedValue);
    }

    @Stable
    public String toString() {
        return m5285toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5287unboximpl() {
        return this.packedValue;
    }
}
