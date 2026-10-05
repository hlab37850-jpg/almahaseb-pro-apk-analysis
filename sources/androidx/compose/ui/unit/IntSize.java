package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0723Lm;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class IntSize {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m5315constructorimpl(0);
    private final long packedValue;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getZero-YbymL2g, reason: not valid java name */
        public final long m5325getZeroYbymL2g() {
            return IntSize.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ IntSize(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntSize m5312boximpl(long j) {
        return new IntSize(j);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m5313component1impl(long j) {
        return m5320getWidthimpl(j);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m5314component2impl(long j) {
        return m5319getHeightimpl(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m5315constructorimpl(long j) {
        return j;
    }

    @Stable
    /* JADX INFO: renamed from: div-YEO4UFw, reason: not valid java name */
    public static final long m5316divYEO4UFw(long j, int i) {
        return IntSizeKt.IntSize(m5320getWidthimpl(j) / i, m5319getHeightimpl(j) / i);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5317equalsimpl(long j, Object obj) {
        return (obj instanceof IntSize) && j == ((IntSize) obj).m5324unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5318equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations() {
    }

    /* JADX INFO: renamed from: getHeight-impl, reason: not valid java name */
    public static final int m5319getHeightimpl(long j) {
        return (int) (j & 4294967295L);
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* JADX INFO: renamed from: getWidth-impl, reason: not valid java name */
    public static final int m5320getWidthimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5321hashCodeimpl(long j) {
        return AbstractC0723Lm.a(j);
    }

    @Stable
    /* JADX INFO: renamed from: times-YEO4UFw, reason: not valid java name */
    public static final long m5322timesYEO4UFw(long j, int i) {
        return IntSizeKt.IntSize(m5320getWidthimpl(j) * i, m5319getHeightimpl(j) * i);
    }

    @Stable
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5323toStringimpl(long j) {
        return m5320getWidthimpl(j) + " x " + m5319getHeightimpl(j);
    }

    public boolean equals(Object obj) {
        return m5317equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5321hashCodeimpl(this.packedValue);
    }

    @Stable
    public String toString() {
        return m5323toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5324unboximpl() {
        return this.packedValue;
    }
}
