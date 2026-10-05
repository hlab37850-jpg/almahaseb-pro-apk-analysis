package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0723Lm;
import defpackage.C0774Nm;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Velocity {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = VelocityKt.Velocity(0.0f, 0.0f);
    private final long packedValue;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        @Stable
        /* JADX INFO: renamed from: getZero-9UxMQ8M$annotations, reason: not valid java name */
        public static /* synthetic */ void m5395getZero9UxMQ8M$annotations() {
        }

        /* JADX INFO: renamed from: getZero-9UxMQ8M, reason: not valid java name */
        public final long m5396getZero9UxMQ8M() {
            return Velocity.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Velocity(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Velocity m5376boximpl(long j) {
        return new Velocity(j);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m5377component1impl(long j) {
        return m5385getXimpl(j);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m5378component2impl(long j) {
        return m5386getYimpl(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m5379constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: copy-OhffZ5M, reason: not valid java name */
    public static final long m5380copyOhffZ5M(long j, float f, float f2) {
        return VelocityKt.Velocity(f, f2);
    }

    /* JADX INFO: renamed from: copy-OhffZ5M$default, reason: not valid java name */
    public static /* synthetic */ long m5381copyOhffZ5M$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m5385getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m5386getYimpl(j);
        }
        return m5380copyOhffZ5M(j, f, f2);
    }

    @Stable
    /* JADX INFO: renamed from: div-adjELrA, reason: not valid java name */
    public static final long m5382divadjELrA(long j, float f) {
        return VelocityKt.Velocity(m5385getXimpl(j) / f, m5386getYimpl(j) / f);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5383equalsimpl(long j, Object obj) {
        return (obj instanceof Velocity) && j == ((Velocity) obj).m5394unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5384equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m5385getXimpl(long j) {
        C0774Nm c0774Nm = C0774Nm.a;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m5386getYimpl(long j) {
        C0774Nm c0774Nm = C0774Nm.a;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5387hashCodeimpl(long j) {
        return AbstractC0723Lm.a(j);
    }

    @Stable
    /* JADX INFO: renamed from: minus-AH228Gc, reason: not valid java name */
    public static final long m5388minusAH228Gc(long j, long j2) {
        return VelocityKt.Velocity(m5385getXimpl(j) - m5385getXimpl(j2), m5386getYimpl(j) - m5386getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: plus-AH228Gc, reason: not valid java name */
    public static final long m5389plusAH228Gc(long j, long j2) {
        return VelocityKt.Velocity(m5385getXimpl(j) + m5385getXimpl(j2), m5386getYimpl(j) + m5386getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: rem-adjELrA, reason: not valid java name */
    public static final long m5390remadjELrA(long j, float f) {
        return VelocityKt.Velocity(m5385getXimpl(j) % f, m5386getYimpl(j) % f);
    }

    @Stable
    /* JADX INFO: renamed from: times-adjELrA, reason: not valid java name */
    public static final long m5391timesadjELrA(long j, float f) {
        return VelocityKt.Velocity(m5385getXimpl(j) * f, m5386getYimpl(j) * f);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5392toStringimpl(long j) {
        return '(' + m5385getXimpl(j) + ", " + m5386getYimpl(j) + ") px/sec";
    }

    @Stable
    /* JADX INFO: renamed from: unaryMinus-9UxMQ8M, reason: not valid java name */
    public static final long m5393unaryMinus9UxMQ8M(long j) {
        return VelocityKt.Velocity(-m5385getXimpl(j), -m5386getYimpl(j));
    }

    public boolean equals(Object obj) {
        return m5383equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5387hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m5392toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5394unboximpl() {
        return this.packedValue;
    }
}
