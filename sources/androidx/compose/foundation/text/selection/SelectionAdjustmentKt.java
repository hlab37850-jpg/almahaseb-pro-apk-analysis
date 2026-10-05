package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.ui.text.TextRangeKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionAdjustmentKt {
    public static final long ensureAtLeastOneChar(String str, int i, int i2, boolean z, boolean z2) {
        AbstractC4492zt.h(str, "text");
        if (i2 == 0) {
            return TextRangeKt.TextRange(i, i);
        }
        if (i == 0) {
            return z ? TextRangeKt.TextRange(StringHelpers_androidKt.findFollowingBreak(str, 0), 0) : TextRangeKt.TextRange(0, StringHelpers_androidKt.findFollowingBreak(str, 0));
        }
        if (i == i2) {
            return z ? TextRangeKt.TextRange(StringHelpers_androidKt.findPrecedingBreak(str, i2), i2) : TextRangeKt.TextRange(i2, StringHelpers_androidKt.findPrecedingBreak(str, i2));
        }
        if (z) {
            return !z2 ? TextRangeKt.TextRange(StringHelpers_androidKt.findPrecedingBreak(str, i), i) : TextRangeKt.TextRange(StringHelpers_androidKt.findFollowingBreak(str, i), i);
        }
        return !z2 ? TextRangeKt.TextRange(i, StringHelpers_androidKt.findFollowingBreak(str, i)) : TextRangeKt.TextRange(i, StringHelpers_androidKt.findPrecedingBreak(str, i));
    }
}
