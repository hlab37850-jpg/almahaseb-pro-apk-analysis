package androidx.compose.ui.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0723Lm;
import defpackage.C0774Nm;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class ScaleFactor {
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified = ScaleFactorKt.ScaleFactor(Float.NaN, Float.NaN);
    private final long packedValue;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        @Stable
        /* JADX INFO: renamed from: getUnspecified-_hLwfpc$annotations, reason: not valid java name */
        public static /* synthetic */ void m4228getUnspecified_hLwfpc$annotations() {
        }

        /* JADX INFO: renamed from: getUnspecified-_hLwfpc, reason: not valid java name */
        public final long m4229getUnspecified_hLwfpc() {
            return ScaleFactor.Unspecified;
        }

        private Companion() {
        }
    }

    private /* synthetic */ ScaleFactor(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ScaleFactor m4213boximpl(long j) {
        return new ScaleFactor(j);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m4214component1impl(long j) {
        return m4222getScaleXimpl(j);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m4215component2impl(long j) {
        return m4223getScaleYimpl(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m4216constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: copy-8GGzs04, reason: not valid java name */
    public static final long m4217copy8GGzs04(long j, float f, float f2) {
        return ScaleFactorKt.ScaleFactor(f, f2);
    }

    /* JADX INFO: renamed from: copy-8GGzs04$default, reason: not valid java name */
    public static /* synthetic */ long m4218copy8GGzs04$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m4222getScaleXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m4223getScaleYimpl(j);
        }
        return m4217copy8GGzs04(j, f, f2);
    }

    @Stable
    /* JADX INFO: renamed from: div-44nBxM0, reason: not valid java name */
    public static final long m4219div44nBxM0(long j, float f) {
        return ScaleFactorKt.ScaleFactor(m4222getScaleXimpl(j) / f, m4223getScaleYimpl(j) / f);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4220equalsimpl(long j, Object obj) {
        return (obj instanceof ScaleFactor) && j == ((ScaleFactor) obj).m4227unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4221equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getScaleX$annotations() {
    }

    /* JADX INFO: renamed from: getScaleX-impl, reason: not valid java name */
    public static final float m4222getScaleXimpl(long j) {
        if (j == Unspecified) {
            throw new IllegalStateException("ScaleFactor is unspecified");
        }
        C0774Nm c0774Nm = C0774Nm.a;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    @Stable
    public static /* synthetic */ void getScaleY$annotations() {
    }

    /* JADX INFO: renamed from: getScaleY-impl, reason: not valid java name */
    public static final float m4223getScaleYimpl(long j) {
        if (j == Unspecified) {
            throw new IllegalStateException("ScaleFactor is unspecified");
        }
        C0774Nm c0774Nm = C0774Nm.a;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4224hashCodeimpl(long j) {
        return AbstractC0723Lm.a(j);
    }

    @Stable
    /* JADX INFO: renamed from: times-44nBxM0, reason: not valid java name */
    public static final long m4225times44nBxM0(long j, float f) {
        return ScaleFactorKt.ScaleFactor(m4222getScaleXimpl(j) * f, m4223getScaleYimpl(j) * f);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4226toStringimpl(long j) {
        return "ScaleFactor(" + ScaleFactorKt.roundToTenths(m4222getScaleXimpl(j)) + ", " + ScaleFactorKt.roundToTenths(m4223getScaleYimpl(j)) + ')';
    }

    public boolean equals(Object obj) {
        return m4220equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4224hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m4226toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m4227unboximpl() {
        return this.packedValue;
    }
}
