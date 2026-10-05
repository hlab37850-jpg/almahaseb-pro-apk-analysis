package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0723Lm;
import defpackage.C0774Nm;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class DpOffset {
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-RKDOV3M, reason: not valid java name */
        public final long m5230getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }

        /* JADX INFO: renamed from: getZero-RKDOV3M, reason: not valid java name */
        public final long m5231getZeroRKDOV3M() {
            return DpOffset.Zero;
        }

        private Companion() {
        }
    }

    static {
        float f = 0;
        Zero = DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(f));
        Dp.Companion companion = Dp.Companion;
        Unspecified = DpKt.m5181DpOffsetYgX7TsA(companion.m5180getUnspecifiedD9Ej5fM(), companion.m5180getUnspecifiedD9Ej5fM());
    }

    private /* synthetic */ DpOffset(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m5215boximpl(long j) {
        return new DpOffset(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m5216constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: copy-tPigGR8, reason: not valid java name */
    public static final long m5217copytPigGR8(long j, float f, float f2) {
        return DpKt.m5181DpOffsetYgX7TsA(f, f2);
    }

    /* JADX INFO: renamed from: copy-tPigGR8$default, reason: not valid java name */
    public static /* synthetic */ long m5218copytPigGR8$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m5221getXD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m5223getYD9Ej5fM(j);
        }
        return m5217copytPigGR8(j, f, f2);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5219equalsimpl(long j, Object obj) {
        return (obj instanceof DpOffset) && j == ((DpOffset) obj).m5229unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5220equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m5221getXD9Ej5fM(long j) {
        if (j == Unspecified) {
            throw new IllegalStateException("DpOffset is unspecified");
        }
        C0774Nm c0774Nm = C0774Nm.a;
        return Dp.m5160constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    @Stable
    /* JADX INFO: renamed from: getX-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m5222getXD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m5223getYD9Ej5fM(long j) {
        if (j == Unspecified) {
            throw new IllegalStateException("DpOffset is unspecified");
        }
        C0774Nm c0774Nm = C0774Nm.a;
        return Dp.m5160constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    @Stable
    /* JADX INFO: renamed from: getY-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m5224getYD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5225hashCodeimpl(long j) {
        return AbstractC0723Lm.a(j);
    }

    @Stable
    /* JADX INFO: renamed from: minus-CB-Mgk4, reason: not valid java name */
    public static final long m5226minusCBMgk4(long j, long j2) {
        return DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(m5221getXD9Ej5fM(j) - m5221getXD9Ej5fM(j2)), Dp.m5160constructorimpl(m5223getYD9Ej5fM(j) - m5223getYD9Ej5fM(j2)));
    }

    @Stable
    /* JADX INFO: renamed from: plus-CB-Mgk4, reason: not valid java name */
    public static final long m5227plusCBMgk4(long j, long j2) {
        return DpKt.m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(m5221getXD9Ej5fM(j) + m5221getXD9Ej5fM(j2)), Dp.m5160constructorimpl(m5223getYD9Ej5fM(j) + m5223getYD9Ej5fM(j2)));
    }

    @Stable
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5228toStringimpl(long j) {
        if (j == Companion.m5230getUnspecifiedRKDOV3M()) {
            return "DpOffset.Unspecified";
        }
        return '(' + ((Object) Dp.m5171toStringimpl(m5221getXD9Ej5fM(j))) + ", " + ((Object) Dp.m5171toStringimpl(m5223getYD9Ej5fM(j))) + ')';
    }

    public boolean equals(Object obj) {
        return m5219equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5225hashCodeimpl(this.packedValue);
    }

    @Stable
    public String toString() {
        return m5228toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5229unboximpl() {
        return this.packedValue;
    }
}
