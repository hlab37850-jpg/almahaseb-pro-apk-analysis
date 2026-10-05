package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C0774Nm;
import defpackage.C0893Rs;
import defpackage.C2020dG;
import defpackage.HV;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class VisibilityThresholdsKt {
    private static final float DpVisibilityThreshold = 0.1f;
    private static final float PxVisibilityThreshold = 0.5f;
    private static final Rect rectVisibilityThreshold;
    private static final Map<TwoWayConverter<?, ?>, Float> visibilityThresholdMap;

    static {
        Float fValueOf = Float.valueOf(0.5f);
        rectVisibilityThreshold = new Rect(0.5f, 0.5f, 0.5f, 0.5f);
        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(C0893Rs.a);
        Float fValueOf2 = Float.valueOf(1.0f);
        C2020dG c2020dGA = HV.a(vectorConverter, fValueOf2);
        C2020dG c2020dGA2 = HV.a(VectorConvertersKt.getVectorConverter(IntSize.Companion), fValueOf2);
        C2020dG c2020dGA3 = HV.a(VectorConvertersKt.getVectorConverter(IntOffset.Companion), fValueOf2);
        C2020dG c2020dGA4 = HV.a(VectorConvertersKt.getVectorConverter(C0774Nm.a), Float.valueOf(0.01f));
        C2020dG c2020dGA5 = HV.a(VectorConvertersKt.getVectorConverter(Rect.Companion), fValueOf);
        C2020dG c2020dGA6 = HV.a(VectorConvertersKt.getVectorConverter(Size.Companion), fValueOf);
        C2020dG c2020dGA7 = HV.a(VectorConvertersKt.getVectorConverter(Offset.Companion), fValueOf);
        TwoWayConverter<Dp, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(Dp.Companion);
        Float fValueOf3 = Float.valueOf(0.1f);
        visibilityThresholdMap = AbstractC4243wx.j(c2020dGA, c2020dGA2, c2020dGA3, c2020dGA4, c2020dGA5, c2020dGA6, c2020dGA7, HV.a(vectorConverter2, fValueOf3), HV.a(VectorConvertersKt.getVectorConverter(DpOffset.Companion), fValueOf3));
    }

    public static final int getVisibilityThreshold(C0893Rs c0893Rs) {
        AbstractC4492zt.h(c0893Rs, "<this>");
        return 1;
    }

    public static final Map<TwoWayConverter<?, ?>, Float> getVisibilityThresholdMap() {
        return visibilityThresholdMap;
    }

    public static final long getVisibilityThreshold(IntOffset.Companion companion) {
        AbstractC4492zt.h(companion, "<this>");
        return IntOffsetKt.IntOffset(1, 1);
    }

    public static final long getVisibilityThreshold(Offset.Companion companion) {
        AbstractC4492zt.h(companion, "<this>");
        return OffsetKt.Offset(0.5f, 0.5f);
    }

    public static final long getVisibilityThreshold(DpOffset.Companion companion) {
        AbstractC4492zt.h(companion, "<this>");
        Dp.Companion companion2 = Dp.Companion;
        return DpKt.m5181DpOffsetYgX7TsA(getVisibilityThreshold(companion2), getVisibilityThreshold(companion2));
    }

    public static final long getVisibilityThreshold(Size.Companion companion) {
        AbstractC4492zt.h(companion, "<this>");
        return SizeKt.Size(0.5f, 0.5f);
    }

    public static final long getVisibilityThreshold(IntSize.Companion companion) {
        AbstractC4492zt.h(companion, "<this>");
        return IntSizeKt.IntSize(1, 1);
    }

    public static final Rect getVisibilityThreshold(Rect.Companion companion) {
        AbstractC4492zt.h(companion, "<this>");
        return rectVisibilityThreshold;
    }

    public static final float getVisibilityThreshold(Dp.Companion companion) {
        AbstractC4492zt.h(companion, "<this>");
        return Dp.m5160constructorimpl(0.1f);
    }
}
