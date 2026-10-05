package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class OffsetKt {
    @Stable
    public static final long Offset(float f, float f2) {
        return Offset.m2790constructorimpl((((long) Float.floatToIntBits(f2)) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    /* JADX INFO: renamed from: isFinite-k-4lQ0M, reason: not valid java name */
    public static final boolean m2815isFinitek4lQ0M(long j) {
        float fM2798getXimpl = Offset.m2798getXimpl(j);
        if (!Float.isInfinite(fM2798getXimpl) && !Float.isNaN(fM2798getXimpl)) {
            float fM2799getYimpl = Offset.m2799getYimpl(j);
            if (!Float.isInfinite(fM2799getYimpl) && !Float.isNaN(fM2799getYimpl)) {
                return true;
            }
        }
        return false;
    }

    @Stable
    /* JADX INFO: renamed from: isFinite-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m2816isFinitek4lQ0M$annotations(long j) {
    }

    /* JADX INFO: renamed from: isSpecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m2817isSpecifiedk4lQ0M(long j) {
        return j != Offset.Companion.m2813getUnspecifiedF1C5BW0();
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m2818isSpecifiedk4lQ0M$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m2819isUnspecifiedk4lQ0M(long j) {
        return j == Offset.Companion.m2813getUnspecifiedF1C5BW0();
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m2820isUnspecifiedk4lQ0M$annotations(long j) {
    }

    @Stable
    /* JADX INFO: renamed from: lerp-Wko1d7g, reason: not valid java name */
    public static final long m2821lerpWko1d7g(long j, long j2, float f) {
        return Offset(MathHelpersKt.lerp(Offset.m2798getXimpl(j), Offset.m2798getXimpl(j2), f), MathHelpersKt.lerp(Offset.m2799getYimpl(j), Offset.m2799getYimpl(j2), f));
    }

    /* JADX INFO: renamed from: takeOrElse-3MmeM6k, reason: not valid java name */
    public static final long m2822takeOrElse3MmeM6k(long j, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        return m2817isSpecifiedk4lQ0M(j) ? j : ((Offset) interfaceC3588op.invoke()).m2808unboximpl();
    }
}
