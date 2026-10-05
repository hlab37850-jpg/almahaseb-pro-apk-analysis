package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0723Lm;
import defpackage.C0774Nm;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class DpSize {
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-MYxV2XQ, reason: not valid java name */
        public final long m5267getUnspecifiedMYxV2XQ() {
            return DpSize.Unspecified;
        }

        /* JADX INFO: renamed from: getZero-MYxV2XQ, reason: not valid java name */
        public final long m5268getZeroMYxV2XQ() {
            return DpSize.Zero;
        }

        private Companion() {
        }
    }

    static {
        float f = 0;
        Zero = DpKt.m5182DpSizeYgX7TsA(Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(f));
        Dp.Companion companion = Dp.Companion;
        Unspecified = DpKt.m5182DpSizeYgX7TsA(companion.m5180getUnspecifiedD9Ej5fM(), companion.m5180getUnspecifiedD9Ej5fM());
    }

    private /* synthetic */ DpSize(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpSize m5246boximpl(long j) {
        return new DpSize(j);
    }

    @Stable
    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    public static final float m5247component1D9Ej5fM(long j) {
        return m5258getWidthD9Ej5fM(j);
    }

    @Stable
    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
    public static final float m5248component2D9Ej5fM(long j) {
        return m5256getHeightD9Ej5fM(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m5249constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: copy-DwJknco, reason: not valid java name */
    public static final long m5250copyDwJknco(long j, float f, float f2) {
        return DpKt.m5182DpSizeYgX7TsA(f, f2);
    }

    /* JADX INFO: renamed from: copy-DwJknco$default, reason: not valid java name */
    public static /* synthetic */ long m5251copyDwJknco$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m5258getWidthD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m5256getHeightD9Ej5fM(j);
        }
        return m5250copyDwJknco(j, f, f2);
    }

    @Stable
    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m5253divGh9hcWk(long j, int i) {
        float f = i;
        return DpKt.m5182DpSizeYgX7TsA(Dp.m5160constructorimpl(m5258getWidthD9Ej5fM(j) / f), Dp.m5160constructorimpl(m5256getHeightD9Ej5fM(j) / f));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5254equalsimpl(long j, Object obj) {
        return (obj instanceof DpSize) && j == ((DpSize) obj).m5266unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5255equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m5256getHeightD9Ej5fM(long j) {
        if (j == Unspecified) {
            throw new IllegalStateException("DpSize is unspecified");
        }
        C0774Nm c0774Nm = C0774Nm.a;
        return Dp.m5160constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    @Stable
    /* JADX INFO: renamed from: getHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m5257getHeightD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m5258getWidthD9Ej5fM(long j) {
        if (j == Unspecified) {
            throw new IllegalStateException("DpSize is unspecified");
        }
        C0774Nm c0774Nm = C0774Nm.a;
        return Dp.m5160constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    @Stable
    /* JADX INFO: renamed from: getWidth-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m5259getWidthD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5260hashCodeimpl(long j) {
        return AbstractC0723Lm.a(j);
    }

    @Stable
    /* JADX INFO: renamed from: minus-e_xh8Ic, reason: not valid java name */
    public static final long m5261minuse_xh8Ic(long j, long j2) {
        return DpKt.m5182DpSizeYgX7TsA(Dp.m5160constructorimpl(m5258getWidthD9Ej5fM(j) - m5258getWidthD9Ej5fM(j2)), Dp.m5160constructorimpl(m5256getHeightD9Ej5fM(j) - m5256getHeightD9Ej5fM(j2)));
    }

    @Stable
    /* JADX INFO: renamed from: plus-e_xh8Ic, reason: not valid java name */
    public static final long m5262pluse_xh8Ic(long j, long j2) {
        return DpKt.m5182DpSizeYgX7TsA(Dp.m5160constructorimpl(m5258getWidthD9Ej5fM(j) + m5258getWidthD9Ej5fM(j2)), Dp.m5160constructorimpl(m5256getHeightD9Ej5fM(j) + m5256getHeightD9Ej5fM(j2)));
    }

    @Stable
    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m5264timesGh9hcWk(long j, int i) {
        float f = i;
        return DpKt.m5182DpSizeYgX7TsA(Dp.m5160constructorimpl(m5258getWidthD9Ej5fM(j) * f), Dp.m5160constructorimpl(m5256getHeightD9Ej5fM(j) * f));
    }

    @Stable
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5265toStringimpl(long j) {
        if (j == Companion.m5267getUnspecifiedMYxV2XQ()) {
            return "DpSize.Unspecified";
        }
        return ((Object) Dp.m5171toStringimpl(m5258getWidthD9Ej5fM(j))) + " x " + ((Object) Dp.m5171toStringimpl(m5256getHeightD9Ej5fM(j)));
    }

    public boolean equals(Object obj) {
        return m5254equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5260hashCodeimpl(this.packedValue);
    }

    @Stable
    public String toString() {
        return m5265toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5266unboximpl() {
        return this.packedValue;
    }

    @Stable
    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m5252divGh9hcWk(long j, float f) {
        return DpKt.m5182DpSizeYgX7TsA(Dp.m5160constructorimpl(m5258getWidthD9Ej5fM(j) / f), Dp.m5160constructorimpl(m5256getHeightD9Ej5fM(j) / f));
    }

    @Stable
    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m5263timesGh9hcWk(long j, float f) {
        return DpKt.m5182DpSizeYgX7TsA(Dp.m5160constructorimpl(m5258getWidthD9Ej5fM(j) * f), Dp.m5160constructorimpl(m5256getHeightD9Ej5fM(j) * f));
    }
}
