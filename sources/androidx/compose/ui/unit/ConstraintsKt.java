package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC3871sJ;

/* JADX INFO: loaded from: classes.dex */
public final class ConstraintsKt {
    @Stable
    public static final long Constraints(int i, int i2, int i3, int i4) {
        if (i2 < i) {
            throw new IllegalArgumentException(("maxWidth(" + i2 + ") must be >= than minWidth(" + i + ')').toString());
        }
        if (i4 < i3) {
            throw new IllegalArgumentException(("maxHeight(" + i4 + ") must be >= than minHeight(" + i3 + ')').toString());
        }
        if (i >= 0 && i3 >= 0) {
            return Constraints.Companion.m5135createConstraintsZbe2FdA$ui_unit_release(i, i2, i3, i4);
        }
        throw new IllegalArgumentException(("minWidth(" + i + ") and minHeight(" + i3 + ") must be >= 0").toString());
    }

    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    private static final int addMaxWithMinimum(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : AbstractC3871sJ.d(i + i2, 0);
    }

    @Stable
    /* JADX INFO: renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m5139constrain4WqzIAM(long j, long j2) {
        return IntSizeKt.IntSize(AbstractC3871sJ.l(IntSize.m5320getWidthimpl(j2), Constraints.m5130getMinWidthimpl(j), Constraints.m5128getMaxWidthimpl(j)), AbstractC3871sJ.l(IntSize.m5319getHeightimpl(j2), Constraints.m5129getMinHeightimpl(j), Constraints.m5127getMaxHeightimpl(j)));
    }

    /* JADX INFO: renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m5140constrainN9IONVI(long j, long j2) {
        return Constraints(AbstractC3871sJ.l(Constraints.m5130getMinWidthimpl(j2), Constraints.m5130getMinWidthimpl(j), Constraints.m5128getMaxWidthimpl(j)), AbstractC3871sJ.l(Constraints.m5128getMaxWidthimpl(j2), Constraints.m5130getMinWidthimpl(j), Constraints.m5128getMaxWidthimpl(j)), AbstractC3871sJ.l(Constraints.m5129getMinHeightimpl(j2), Constraints.m5129getMinHeightimpl(j), Constraints.m5127getMaxHeightimpl(j)), AbstractC3871sJ.l(Constraints.m5127getMaxHeightimpl(j2), Constraints.m5129getMinHeightimpl(j), Constraints.m5127getMaxHeightimpl(j)));
    }

    @Stable
    /* JADX INFO: renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m5141constrainHeightK40F9xA(long j, int i) {
        return AbstractC3871sJ.l(i, Constraints.m5129getMinHeightimpl(j), Constraints.m5127getMaxHeightimpl(j));
    }

    @Stable
    /* JADX INFO: renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m5142constrainWidthK40F9xA(long j, int i) {
        return AbstractC3871sJ.l(i, Constraints.m5130getMinWidthimpl(j), Constraints.m5128getMaxWidthimpl(j));
    }

    @Stable
    /* JADX INFO: renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m5143isSatisfiedBy4WqzIAM(long j, long j2) {
        int iM5130getMinWidthimpl = Constraints.m5130getMinWidthimpl(j);
        int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j);
        int iM5320getWidthimpl = IntSize.m5320getWidthimpl(j2);
        if (iM5130getMinWidthimpl <= iM5320getWidthimpl && iM5320getWidthimpl <= iM5128getMaxWidthimpl) {
            int iM5129getMinHeightimpl = Constraints.m5129getMinHeightimpl(j);
            int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
            int iM5319getHeightimpl = IntSize.m5319getHeightimpl(j2);
            if (iM5129getMinHeightimpl <= iM5319getHeightimpl && iM5319getHeightimpl <= iM5127getMaxHeightimpl) {
                return true;
            }
        }
        return false;
    }

    @Stable
    /* JADX INFO: renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m5144offsetNN6EwU(long j, int i, int i2) {
        return Constraints(AbstractC3871sJ.d(Constraints.m5130getMinWidthimpl(j) + i, 0), addMaxWithMinimum(Constraints.m5128getMaxWidthimpl(j), i), AbstractC3871sJ.d(Constraints.m5129getMinHeightimpl(j) + i2, 0), addMaxWithMinimum(Constraints.m5127getMaxHeightimpl(j), i2));
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m5145offsetNN6EwU$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m5144offsetNN6EwU(j, i, i2);
    }
}
