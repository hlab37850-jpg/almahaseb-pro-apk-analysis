package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class ScaleFactorKt {
    @Stable
    public static final long ScaleFactor(float f, float f2) {
        return ScaleFactor.m4216constructorimpl((((long) Float.floatToIntBits(f2)) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: div-UQTWf7w, reason: not valid java name */
    public static final long m4230divUQTWf7w(long j, long j2) {
        return SizeKt.Size(Size.m2867getWidthimpl(j) / ScaleFactor.m4222getScaleXimpl(j2), Size.m2864getHeightimpl(j) / ScaleFactor.m4223getScaleYimpl(j2));
    }

    /* JADX INFO: renamed from: isSpecified-FK8aYYs, reason: not valid java name */
    public static final boolean m4231isSpecifiedFK8aYYs(long j) {
        return j != ScaleFactor.Companion.m4229getUnspecified_hLwfpc();
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m4232isSpecifiedFK8aYYs$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-FK8aYYs, reason: not valid java name */
    public static final boolean m4233isUnspecifiedFK8aYYs(long j) {
        return j == ScaleFactor.Companion.m4229getUnspecified_hLwfpc();
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m4234isUnspecifiedFK8aYYs$annotations(long j) {
    }

    @Stable
    /* JADX INFO: renamed from: lerp--bDIf60, reason: not valid java name */
    public static final long m4235lerpbDIf60(long j, long j2, float f) {
        return ScaleFactor(MathHelpersKt.lerp(ScaleFactor.m4222getScaleXimpl(j), ScaleFactor.m4222getScaleXimpl(j2), f), MathHelpersKt.lerp(ScaleFactor.m4223getScaleYimpl(j), ScaleFactor.m4223getScaleYimpl(j2), f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float roundToTenths(float f) {
        float f2 = 10;
        float f3 = f * f2;
        int i = (int) f3;
        if (f3 - i >= 0.5f) {
            i++;
        }
        return i / f2;
    }

    /* JADX INFO: renamed from: takeOrElse-oyDd2qo, reason: not valid java name */
    public static final long m4236takeOrElseoyDd2qo(long j, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        return j != ScaleFactor.Companion.m4229getUnspecified_hLwfpc() ? j : ((ScaleFactor) interfaceC3588op.invoke()).m4227unboximpl();
    }

    @Stable
    /* JADX INFO: renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m4237timesUQTWf7w(long j, long j2) {
        return SizeKt.Size(Size.m2867getWidthimpl(j) * ScaleFactor.m4222getScaleXimpl(j2), Size.m2864getHeightimpl(j) * ScaleFactor.m4223getScaleYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: times-m-w2e94, reason: not valid java name */
    public static final long m4238timesmw2e94(long j, long j2) {
        return m4237timesUQTWf7w(j2, j);
    }
}
