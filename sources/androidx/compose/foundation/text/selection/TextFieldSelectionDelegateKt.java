package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionDelegateKt {
    /* JADX INFO: renamed from: getTextFieldSelection-bb3KNj8, reason: not valid java name */
    public static final long m947getTextFieldSelectionbb3KNj8(TextLayoutResult textLayoutResult, int i, int i2, TextRange textRange, boolean z, SelectionAdjustment selectionAdjustment) {
        AbstractC4492zt.h(selectionAdjustment, "adjustment");
        if (textLayoutResult == null) {
            return TextRangeKt.TextRange(0, 0);
        }
        long jTextRange = TextRangeKt.TextRange(i, i2);
        return (textRange == null && AbstractC4492zt.d(selectionAdjustment, SelectionAdjustment.Companion.getCharacter())) ? jTextRange : selectionAdjustment.mo893adjustZXO7KMw(textLayoutResult, jTextRange, -1, z, textRange);
    }
}
