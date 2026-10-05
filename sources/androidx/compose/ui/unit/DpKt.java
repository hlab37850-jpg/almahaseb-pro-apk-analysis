package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class DpKt {
    @Stable
    /* JADX INFO: renamed from: DpOffset-YgX7TsA, reason: not valid java name */
    public static final long m5181DpOffsetYgX7TsA(float f, float f2) {
        return DpOffset.m5216constructorimpl((((long) Float.floatToIntBits(f2)) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m5182DpSizeYgX7TsA(float f, float f2) {
        return DpSize.m5249constructorimpl((((long) Float.floatToIntBits(f2)) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: coerceAtLeast-YgX7TsA, reason: not valid java name */
    public static final float m5183coerceAtLeastYgX7TsA(float f, float f2) {
        return Dp.m5160constructorimpl(AbstractC3871sJ.c(f, f2));
    }

    @Stable
    /* JADX INFO: renamed from: coerceAtMost-YgX7TsA, reason: not valid java name */
    public static final float m5184coerceAtMostYgX7TsA(float f, float f2) {
        return Dp.m5160constructorimpl(AbstractC3871sJ.f(f, f2));
    }

    @Stable
    /* JADX INFO: renamed from: coerceIn-2z7ARbQ, reason: not valid java name */
    public static final float m5185coerceIn2z7ARbQ(float f, float f2, float f3) {
        return Dp.m5160constructorimpl(AbstractC3871sJ.k(f, f2, f3));
    }

    /* JADX INFO: renamed from: getCenter-EaSLcWc, reason: not valid java name */
    public static final long m5186getCenterEaSLcWc(long j) {
        return m5181DpOffsetYgX7TsA(Dp.m5160constructorimpl(DpSize.m5258getWidthD9Ej5fM(j) / 2.0f), Dp.m5160constructorimpl(DpSize.m5256getHeightD9Ej5fM(j) / 2.0f));
    }

    @Stable
    /* JADX INFO: renamed from: getCenter-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m5187getCenterEaSLcWc$annotations(long j) {
    }

    public static final float getDp(int i) {
        return Dp.m5160constructorimpl(i);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(double d) {
    }

    public static final float getHeight(DpRect dpRect) {
        AbstractC4492zt.h(dpRect, "<this>");
        return Dp.m5160constructorimpl(dpRect.m5242getBottomD9Ej5fM() - dpRect.m5245getTopD9Ej5fM());
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations(DpRect dpRect) {
    }

    public static final long getSize(DpRect dpRect) {
        AbstractC4492zt.h(dpRect, "<this>");
        return m5182DpSizeYgX7TsA(Dp.m5160constructorimpl(dpRect.m5244getRightD9Ej5fM() - dpRect.m5243getLeftD9Ej5fM()), Dp.m5160constructorimpl(dpRect.m5242getBottomD9Ej5fM() - dpRect.m5245getTopD9Ej5fM()));
    }

    @Stable
    public static /* synthetic */ void getSize$annotations(DpRect dpRect) {
    }

    public static final float getWidth(DpRect dpRect) {
        AbstractC4492zt.h(dpRect, "<this>");
        return Dp.m5160constructorimpl(dpRect.m5244getRightD9Ej5fM() - dpRect.m5243getLeftD9Ej5fM());
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations(DpRect dpRect) {
    }

    /* JADX INFO: renamed from: isFinite-0680j_4, reason: not valid java name */
    public static final boolean m5188isFinite0680j_4(float f) {
        return !(f == Float.POSITIVE_INFINITY);
    }

    @Stable
    /* JADX INFO: renamed from: isFinite-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m5189isFinite0680j_4$annotations(float f) {
    }

    /* JADX INFO: renamed from: isSpecified-0680j_4, reason: not valid java name */
    public static final boolean m5190isSpecified0680j_4(float f) {
        return !Float.isNaN(f);
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m5191isSpecified0680j_4$annotations(float f) {
    }

    /* JADX INFO: renamed from: isSpecified-EaSLcWc, reason: not valid java name */
    public static final boolean m5192isSpecifiedEaSLcWc(long j) {
        return j != DpSize.Companion.m5267getUnspecifiedMYxV2XQ();
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m5193isSpecifiedEaSLcWc$annotations(long j) {
    }

    /* JADX INFO: renamed from: isSpecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m5194isSpecifiedjoFl9I(long j) {
        return j != DpOffset.Companion.m5230getUnspecifiedRKDOV3M();
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m5195isSpecifiedjoFl9I$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-0680j_4, reason: not valid java name */
    public static final boolean m5196isUnspecified0680j_4(float f) {
        return Float.isNaN(f);
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m5197isUnspecified0680j_4$annotations(float f) {
    }

    /* JADX INFO: renamed from: isUnspecified-EaSLcWc, reason: not valid java name */
    public static final boolean m5198isUnspecifiedEaSLcWc(long j) {
        return j == DpSize.Companion.m5267getUnspecifiedMYxV2XQ();
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m5199isUnspecifiedEaSLcWc$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m5200isUnspecifiedjoFl9I(long j) {
        return j == DpOffset.Companion.m5230getUnspecifiedRKDOV3M();
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m5201isUnspecifiedjoFl9I$annotations(long j) {
    }

    @Stable
    /* JADX INFO: renamed from: lerp-IDex15A, reason: not valid java name */
    public static final long m5202lerpIDex15A(long j, long j2, float f) {
        return m5182DpSizeYgX7TsA(m5203lerpMdfbLM(DpSize.m5258getWidthD9Ej5fM(j), DpSize.m5258getWidthD9Ej5fM(j2), f), m5203lerpMdfbLM(DpSize.m5256getHeightD9Ej5fM(j), DpSize.m5256getHeightD9Ej5fM(j2), f));
    }

    @Stable
    /* JADX INFO: renamed from: lerp-Md-fbLM, reason: not valid java name */
    public static final float m5203lerpMdfbLM(float f, float f2, float f3) {
        return Dp.m5160constructorimpl(MathHelpersKt.lerp(f, f2, f3));
    }

    @Stable
    /* JADX INFO: renamed from: lerp-xhh869w, reason: not valid java name */
    public static final long m5204lerpxhh869w(long j, long j2, float f) {
        return m5181DpOffsetYgX7TsA(m5203lerpMdfbLM(DpOffset.m5221getXD9Ej5fM(j), DpOffset.m5221getXD9Ej5fM(j2), f), m5203lerpMdfbLM(DpOffset.m5223getYD9Ej5fM(j), DpOffset.m5223getYD9Ej5fM(j2), f));
    }

    @Stable
    /* JADX INFO: renamed from: max-YgX7TsA, reason: not valid java name */
    public static final float m5205maxYgX7TsA(float f, float f2) {
        return Dp.m5160constructorimpl(Math.max(f, f2));
    }

    @Stable
    /* JADX INFO: renamed from: min-YgX7TsA, reason: not valid java name */
    public static final float m5206minYgX7TsA(float f, float f2) {
        return Dp.m5160constructorimpl(Math.min(f, f2));
    }

    /* JADX INFO: renamed from: takeOrElse-D5KLDUw, reason: not valid java name */
    public static final float m5207takeOrElseD5KLDUw(float f, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        return !Float.isNaN(f) ? f : ((Dp) interfaceC3588op.invoke()).m5174unboximpl();
    }

    /* JADX INFO: renamed from: takeOrElse-gVKV90s, reason: not valid java name */
    public static final long m5208takeOrElsegVKV90s(long j, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        return j != DpOffset.Companion.m5230getUnspecifiedRKDOV3M() ? j : ((DpOffset) interfaceC3588op.invoke()).m5229unboximpl();
    }

    /* JADX INFO: renamed from: takeOrElse-itqla9I, reason: not valid java name */
    public static final long m5209takeOrElseitqla9I(long j, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        return j != DpSize.Companion.m5267getUnspecifiedMYxV2XQ() ? j : ((DpSize) interfaceC3588op.invoke()).m5266unboximpl();
    }

    @Stable
    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m5211times3ABfNKs(float f, float f2) {
        return Dp.m5160constructorimpl(f * f2);
    }

    @Stable
    /* JADX INFO: renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m5214times6HolHcs(int i, long j) {
        return DpSize.m5264timesGh9hcWk(j, i);
    }

    public static final float getDp(double d) {
        return Dp.m5160constructorimpl((float) d);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(float f) {
    }

    @Stable
    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m5210times3ABfNKs(double d, float f) {
        return Dp.m5160constructorimpl(((float) d) * f);
    }

    @Stable
    /* JADX INFO: renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m5213times6HolHcs(float f, long j) {
        return DpSize.m5263timesGh9hcWk(j, f);
    }

    public static final float getDp(float f) {
        return Dp.m5160constructorimpl(f);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(int i) {
    }

    @Stable
    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m5212times3ABfNKs(int i, float f) {
        return Dp.m5160constructorimpl(i * f);
    }
}
