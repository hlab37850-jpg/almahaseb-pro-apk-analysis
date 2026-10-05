package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;

/* JADX INFO: loaded from: classes.dex */
public final class ModifierUtilsKt {
    /* JADX INFO: renamed from: maxWidthForTextLayout-R2G3SPE, reason: not valid java name */
    public static final int m852maxWidthForTextLayoutR2G3SPE(long j, boolean z, int i) {
        if ((z || TextOverflow.m5106equalsimpl0(i, TextOverflow.Companion.m5114getEllipsisgIe3tQ8())) && Constraints.m5124getHasBoundedWidthimpl(j)) {
            return Constraints.m5128getMaxWidthimpl(j);
        }
        return Integer.MAX_VALUE;
    }
}
