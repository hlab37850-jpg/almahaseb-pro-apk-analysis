package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class OrientationIndependentConstraints {
    private final long value;

    private /* synthetic */ OrientationIndependentConstraints(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OrientationIndependentConstraints m451boximpl(long j) {
        return new OrientationIndependentConstraints(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m453constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: copy-yUG9Ft0, reason: not valid java name */
    public static final long m455copyyUG9Ft0(long j, int i, int i2, int i3, int i4) {
        return m452constructorimpl(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: copy-yUG9Ft0$default, reason: not valid java name */
    public static /* synthetic */ long m456copyyUG9Ft0$default(long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = Constraints.m5130getMinWidthimpl(j);
        }
        int i6 = i;
        if ((i5 & 2) != 0) {
            i2 = Constraints.m5128getMaxWidthimpl(j);
        }
        int i7 = i2;
        if ((i5 & 4) != 0) {
            i3 = Constraints.m5129getMinHeightimpl(j);
        }
        int i8 = i3;
        if ((i5 & 8) != 0) {
            i4 = Constraints.m5127getMaxHeightimpl(j);
        }
        return m455copyyUG9Ft0(j, i6, i7, i8, i4);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m457equalsimpl(long j, Object obj) {
        return (obj instanceof OrientationIndependentConstraints) && Constraints.m5121equalsimpl0(j, ((OrientationIndependentConstraints) obj).m469unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m458equalsimpl0(long j, long j2) {
        return Constraints.m5121equalsimpl0(j, j2);
    }

    /* JADX INFO: renamed from: getCrossAxisMax-impl, reason: not valid java name */
    public static final int m459getCrossAxisMaximpl(long j) {
        return Constraints.m5127getMaxHeightimpl(j);
    }

    /* JADX INFO: renamed from: getCrossAxisMin-impl, reason: not valid java name */
    public static final int m460getCrossAxisMinimpl(long j) {
        return Constraints.m5129getMinHeightimpl(j);
    }

    /* JADX INFO: renamed from: getMainAxisMax-impl, reason: not valid java name */
    public static final int m461getMainAxisMaximpl(long j) {
        return Constraints.m5128getMaxWidthimpl(j);
    }

    /* JADX INFO: renamed from: getMainAxisMin-impl, reason: not valid java name */
    public static final int m462getMainAxisMinimpl(long j) {
        return Constraints.m5130getMinWidthimpl(j);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m463hashCodeimpl(long j) {
        return Constraints.m5131hashCodeimpl(j);
    }

    /* JADX INFO: renamed from: maxHeight-impl, reason: not valid java name */
    public static final int m464maxHeightimpl(long j, LayoutOrientation layoutOrientation) {
        AbstractC4492zt.h(layoutOrientation, "orientation");
        return layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m5127getMaxHeightimpl(j) : Constraints.m5128getMaxWidthimpl(j);
    }

    /* JADX INFO: renamed from: maxWidth-impl, reason: not valid java name */
    public static final int m465maxWidthimpl(long j, LayoutOrientation layoutOrientation) {
        AbstractC4492zt.h(layoutOrientation, "orientation");
        return layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m5128getMaxWidthimpl(j) : Constraints.m5127getMaxHeightimpl(j);
    }

    /* JADX INFO: renamed from: stretchCrossAxis-q4ezo7Y, reason: not valid java name */
    public static final long m466stretchCrossAxisq4ezo7Y(long j) {
        return m452constructorimpl(Constraints.m5130getMinWidthimpl(j), Constraints.m5128getMaxWidthimpl(j), Constraints.m5127getMaxHeightimpl(j) != Integer.MAX_VALUE ? Constraints.m5127getMaxHeightimpl(j) : Constraints.m5129getMinHeightimpl(j), Constraints.m5127getMaxHeightimpl(j));
    }

    /* JADX INFO: renamed from: toBoxConstraints-OenEA2s, reason: not valid java name */
    public static final long m467toBoxConstraintsOenEA2s(long j, LayoutOrientation layoutOrientation) {
        AbstractC4492zt.h(layoutOrientation, "orientation");
        return layoutOrientation == LayoutOrientation.Horizontal ? ConstraintsKt.Constraints(Constraints.m5130getMinWidthimpl(j), Constraints.m5128getMaxWidthimpl(j), Constraints.m5129getMinHeightimpl(j), Constraints.m5127getMaxHeightimpl(j)) : ConstraintsKt.Constraints(Constraints.m5129getMinHeightimpl(j), Constraints.m5127getMaxHeightimpl(j), Constraints.m5130getMinWidthimpl(j), Constraints.m5128getMaxWidthimpl(j));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m468toStringimpl(long j) {
        return "OrientationIndependentConstraints(value=" + ((Object) Constraints.m5133toStringimpl(j)) + ')';
    }

    public boolean equals(Object obj) {
        return m457equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m463hashCodeimpl(this.value);
    }

    public String toString() {
        return m468toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m469unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m452constructorimpl(int i, int i2, int i3, int i4) {
        return m453constructorimpl(ConstraintsKt.Constraints(i, i2, i3, i4));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m454constructorimpl(long j, LayoutOrientation layoutOrientation) {
        AbstractC4492zt.h(layoutOrientation, "orientation");
        LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
        return m452constructorimpl(layoutOrientation == layoutOrientation2 ? Constraints.m5130getMinWidthimpl(j) : Constraints.m5129getMinHeightimpl(j), layoutOrientation == layoutOrientation2 ? Constraints.m5128getMaxWidthimpl(j) : Constraints.m5127getMaxHeightimpl(j), layoutOrientation == layoutOrientation2 ? Constraints.m5129getMinHeightimpl(j) : Constraints.m5130getMinWidthimpl(j), layoutOrientation == layoutOrientation2 ? Constraints.m5127getMaxHeightimpl(j) : Constraints.m5128getMaxWidthimpl(j));
    }
}
