package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import defpackage.AbstractC1210aB;

/* JADX INFO: loaded from: classes.dex */
public final class IntOffsetKt {
    @Stable
    public static final long IntOffset(int i, int i2) {
        return IntOffset.m5272constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: lerp-81ZRxRo, reason: not valid java name */
    public static final long m5289lerp81ZRxRo(long j, long j2, float f) {
        return IntOffset(MathHelpersKt.lerp(IntOffset.m5278getXimpl(j), IntOffset.m5278getXimpl(j2), f), MathHelpersKt.lerp(IntOffset.m5279getYimpl(j), IntOffset.m5279getYimpl(j2), f));
    }

    @Stable
    /* JADX INFO: renamed from: minus-Nv-tHpc, reason: not valid java name */
    public static final long m5290minusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.m2798getXimpl(j) - IntOffset.m5278getXimpl(j2), Offset.m2799getYimpl(j) - IntOffset.m5279getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: minus-oCl6YwE, reason: not valid java name */
    public static final long m5291minusoCl6YwE(long j, long j2) {
        return OffsetKt.Offset(IntOffset.m5278getXimpl(j) - Offset.m2798getXimpl(j2), IntOffset.m5279getYimpl(j) - Offset.m2799getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: plus-Nv-tHpc, reason: not valid java name */
    public static final long m5292plusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.m2798getXimpl(j) + IntOffset.m5278getXimpl(j2), Offset.m2799getYimpl(j) + IntOffset.m5279getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: plus-oCl6YwE, reason: not valid java name */
    public static final long m5293plusoCl6YwE(long j, long j2) {
        return OffsetKt.Offset(IntOffset.m5278getXimpl(j) + Offset.m2798getXimpl(j2), IntOffset.m5279getYimpl(j) + Offset.m2799getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: round-k-4lQ0M, reason: not valid java name */
    public static final long m5294roundk4lQ0M(long j) {
        return IntOffset(AbstractC1210aB.c(Offset.m2798getXimpl(j)), AbstractC1210aB.c(Offset.m2799getYimpl(j)));
    }

    @Stable
    /* JADX INFO: renamed from: toOffset--gyyYBs, reason: not valid java name */
    public static final long m5295toOffsetgyyYBs(long j) {
        return OffsetKt.Offset(IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(j));
    }
}
