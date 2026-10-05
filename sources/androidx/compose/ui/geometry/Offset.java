package androidx.compose.ui.geometry;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0723Lm;
import defpackage.C0774Nm;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Offset {
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long Zero = OffsetKt.Offset(0.0f, 0.0f);
    private static final long Infinite = OffsetKt.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private static final long Unspecified = OffsetKt.Offset(Float.NaN, Float.NaN);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        @Stable
        /* JADX INFO: renamed from: getInfinite-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m2809getInfiniteF1C5BW0$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getUnspecified-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m2810getUnspecifiedF1C5BW0$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getZero-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m2811getZeroF1C5BW0$annotations() {
        }

        /* JADX INFO: renamed from: getInfinite-F1C5BW0, reason: not valid java name */
        public final long m2812getInfiniteF1C5BW0() {
            return Offset.Infinite;
        }

        /* JADX INFO: renamed from: getUnspecified-F1C5BW0, reason: not valid java name */
        public final long m2813getUnspecifiedF1C5BW0() {
            return Offset.Unspecified;
        }

        /* JADX INFO: renamed from: getZero-F1C5BW0, reason: not valid java name */
        public final long m2814getZeroF1C5BW0() {
            return Offset.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Offset(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Offset m2787boximpl(long j) {
        return new Offset(j);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m2788component1impl(long j) {
        return m2798getXimpl(j);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m2789component2impl(long j) {
        return m2799getYimpl(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2790constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: copy-dBAh8RU, reason: not valid java name */
    public static final long m2791copydBAh8RU(long j, float f, float f2) {
        return OffsetKt.Offset(f, f2);
    }

    /* JADX INFO: renamed from: copy-dBAh8RU$default, reason: not valid java name */
    public static /* synthetic */ long m2792copydBAh8RU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m2798getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m2799getYimpl(j);
        }
        return m2791copydBAh8RU(j, f, f2);
    }

    @Stable
    /* JADX INFO: renamed from: div-tuRUvjQ, reason: not valid java name */
    public static final long m2793divtuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m2798getXimpl(j) / f, m2799getYimpl(j) / f);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2794equalsimpl(long j, Object obj) {
        return (obj instanceof Offset) && j == ((Offset) obj).m2808unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2795equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    /* JADX INFO: renamed from: getDistance-impl, reason: not valid java name */
    public static final float m2796getDistanceimpl(long j) {
        return (float) Math.sqrt((m2798getXimpl(j) * m2798getXimpl(j)) + (m2799getYimpl(j) * m2799getYimpl(j)));
    }

    @Stable
    /* JADX INFO: renamed from: getDistanceSquared-impl, reason: not valid java name */
    public static final float m2797getDistanceSquaredimpl(long j) {
        return (m2798getXimpl(j) * m2798getXimpl(j)) + (m2799getYimpl(j) * m2799getYimpl(j));
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m2798getXimpl(long j) {
        if (j == Unspecified) {
            throw new IllegalStateException("Offset is unspecified");
        }
        C0774Nm c0774Nm = C0774Nm.a;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m2799getYimpl(long j) {
        if (j == Unspecified) {
            throw new IllegalStateException("Offset is unspecified");
        }
        C0774Nm c0774Nm = C0774Nm.a;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2800hashCodeimpl(long j) {
        return AbstractC0723Lm.a(j);
    }

    @Stable
    /* JADX INFO: renamed from: isValid-impl, reason: not valid java name */
    public static final boolean m2801isValidimpl(long j) {
        if (Float.isNaN(m2798getXimpl(j)) || Float.isNaN(m2799getYimpl(j))) {
            throw new IllegalStateException("Offset argument contained a NaN value.");
        }
        return true;
    }

    @Stable
    /* JADX INFO: renamed from: minus-MK-Hz9U, reason: not valid java name */
    public static final long m2802minusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m2798getXimpl(j) - m2798getXimpl(j2), m2799getYimpl(j) - m2799getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: plus-MK-Hz9U, reason: not valid java name */
    public static final long m2803plusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m2798getXimpl(j) + m2798getXimpl(j2), m2799getYimpl(j) + m2799getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: rem-tuRUvjQ, reason: not valid java name */
    public static final long m2804remtuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m2798getXimpl(j) % f, m2799getYimpl(j) % f);
    }

    @Stable
    /* JADX INFO: renamed from: times-tuRUvjQ, reason: not valid java name */
    public static final long m2805timestuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m2798getXimpl(j) * f, m2799getYimpl(j) * f);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2806toStringimpl(long j) {
        if (!OffsetKt.m2817isSpecifiedk4lQ0M(j)) {
            return "Offset.Unspecified";
        }
        return "Offset(" + GeometryUtilsKt.toStringAsFixed(m2798getXimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m2799getYimpl(j), 1) + ')';
    }

    @Stable
    /* JADX INFO: renamed from: unaryMinus-F1C5BW0, reason: not valid java name */
    public static final long m2807unaryMinusF1C5BW0(long j) {
        return OffsetKt.Offset(-m2798getXimpl(j), -m2799getYimpl(j));
    }

    public boolean equals(Object obj) {
        return m2794equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2800hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m2806toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2808unboximpl() {
        return this.packedValue;
    }
}
