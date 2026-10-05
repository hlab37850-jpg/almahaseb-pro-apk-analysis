package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import defpackage.AbstractC3871sJ;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutUtilsKt {
    /* JADX INFO: renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m848finalConstraintstfFHcEY(long j, boolean z, int i, float f) {
        return ConstraintsKt.Constraints$default(0, m850finalMaxWidthtfFHcEY(j, z, i, f), 0, Constraints.m5127getMaxHeightimpl(j), 5, null);
    }

    /* JADX INFO: renamed from: finalMaxLines-xdlQI24, reason: not valid java name */
    public static final int m849finalMaxLinesxdlQI24(boolean z, int i, int i2) {
        if (z || !TextOverflow.m5106equalsimpl0(i, TextOverflow.Companion.m5114getEllipsisgIe3tQ8())) {
            return AbstractC3871sJ.d(i2, 1);
        }
        return 1;
    }

    /* JADX INFO: renamed from: finalMaxWidth-tfFHcEY, reason: not valid java name */
    public static final int m850finalMaxWidthtfFHcEY(long j, boolean z, int i, float f) {
        int iM5128getMaxWidthimpl = ((z || TextOverflow.m5106equalsimpl0(i, TextOverflow.Companion.m5114getEllipsisgIe3tQ8())) && Constraints.m5124getHasBoundedWidthimpl(j)) ? Constraints.m5128getMaxWidthimpl(j) : Integer.MAX_VALUE;
        return Constraints.m5130getMinWidthimpl(j) == iM5128getMaxWidthimpl ? iM5128getMaxWidthimpl : AbstractC3871sJ.l(TextDelegateKt.ceilToIntPx(f), Constraints.m5130getMinWidthimpl(j), iM5128getMaxWidthimpl);
    }
}
