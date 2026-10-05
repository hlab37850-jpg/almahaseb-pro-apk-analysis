package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SizeKt {
    @Stable
    public static final long Size(float f, float f2) {
        return Size.m2858constructorimpl((((long) Float.floatToIntBits(f2)) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    /* JADX INFO: renamed from: getCenter-uvyYCjk, reason: not valid java name */
    public static final long m2877getCenteruvyYCjk(long j) {
        return OffsetKt.Offset(Size.m2867getWidthimpl(j) / 2.0f, Size.m2864getHeightimpl(j) / 2.0f);
    }

    @Stable
    /* JADX INFO: renamed from: getCenter-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m2878getCenteruvyYCjk$annotations(long j) {
    }

    /* JADX INFO: renamed from: isSpecified-uvyYCjk, reason: not valid java name */
    public static final boolean m2879isSpecifieduvyYCjk(long j) {
        return j != Size.Companion.m2875getUnspecifiedNHjbRc();
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m2880isSpecifieduvyYCjk$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-uvyYCjk, reason: not valid java name */
    public static final boolean m2881isUnspecifieduvyYCjk(long j) {
        return j == Size.Companion.m2875getUnspecifiedNHjbRc();
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m2882isUnspecifieduvyYCjk$annotations(long j) {
    }

    @Stable
    /* JADX INFO: renamed from: lerp-VgWVRYQ, reason: not valid java name */
    public static final long m2883lerpVgWVRYQ(long j, long j2, float f) {
        return Size(MathHelpersKt.lerp(Size.m2867getWidthimpl(j), Size.m2867getWidthimpl(j2), f), MathHelpersKt.lerp(Size.m2864getHeightimpl(j), Size.m2864getHeightimpl(j2), f));
    }

    /* JADX INFO: renamed from: takeOrElse-TmRCtEA, reason: not valid java name */
    public static final long m2884takeOrElseTmRCtEA(long j, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        return j != Size.Companion.m2875getUnspecifiedNHjbRc() ? j : ((Size) interfaceC3588op.invoke()).m2872unboximpl();
    }

    @Stable
    /* JADX INFO: renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m2887timesd16Qtg0(int i, long j) {
        return Size.m2870times7Ah8Wj8(j, i);
    }

    @Stable
    /* JADX INFO: renamed from: toRect-uvyYCjk, reason: not valid java name */
    public static final Rect m2888toRectuvyYCjk(long j) {
        return RectKt.m2838Recttz77jQw(Offset.Companion.m2814getZeroF1C5BW0(), j);
    }

    @Stable
    /* JADX INFO: renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m2885timesd16Qtg0(double d, long j) {
        return Size.m2870times7Ah8Wj8(j, (float) d);
    }

    @Stable
    /* JADX INFO: renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m2886timesd16Qtg0(float f, long j) {
        return Size.m2870times7Ah8Wj8(j, f);
    }
}
