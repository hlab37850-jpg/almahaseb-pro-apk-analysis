package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;

/* JADX INFO: loaded from: classes.dex */
public final class MultiWidgetSelectionDelegateKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getAssembledSelectionInfo-vJH6DeI, reason: not valid java name */
    public static final Selection m888getAssembledSelectionInfovJH6DeI(long j, boolean z, long j2, TextLayoutResult textLayoutResult) {
        return new Selection(new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(TextRange.m4705getStartimpl(j)), TextRange.m4705getStartimpl(j), j2), new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(Math.max(TextRange.m4700getEndimpl(j) - 1, 0)), TextRange.m4700getEndimpl(j), j2), z);
    }

    /* JADX INFO: renamed from: getOffsetForPosition-0AR0LA0, reason: not valid java name */
    public static final int m889getOffsetForPosition0AR0LA0(TextLayoutResult textLayoutResult, Rect rect, long j) {
        AbstractC4492zt.h(textLayoutResult, "textLayoutResult");
        AbstractC4492zt.h(rect, "bounds");
        int length = textLayoutResult.getLayoutInput().getText().length();
        if (rect.m2824containsk4lQ0M(j)) {
            return AbstractC3871sJ.l(textLayoutResult.m4677getOffsetForPositionk4lQ0M(j), 0, length);
        }
        if (SelectionMode.Vertical.mo943compare3MmeM6k$foundation_release(j, rect) < 0) {
            return 0;
        }
        return length;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x008c  */
    /* JADX INFO: renamed from: getTextSelectionInfo-yM0VcXU, reason: not valid java name */
    public static final C2020dG m890getTextSelectionInfoyM0VcXU(TextLayoutResult textLayoutResult, long j, long j2, Offset offset, long j3, SelectionAdjustment selectionAdjustment, Selection selection, boolean z) {
        boolean z2;
        AbstractC4492zt.h(textLayoutResult, "textLayoutResult");
        AbstractC4492zt.h(selectionAdjustment, "adjustment");
        Rect rect = new Rect(0.0f, 0.0f, IntSize.m5320getWidthimpl(textLayoutResult.m4678getSizeYbymL2g()), IntSize.m5319getHeightimpl(textLayoutResult.m4678getSizeYbymL2g()));
        if (!SelectionMode.Vertical.m944isSelected2x9bVx0$foundation_release(rect, j, j2)) {
            return new C2020dG(null, Boolean.FALSE);
        }
        int iM889getOffsetForPosition0AR0LA0 = m889getOffsetForPosition0AR0LA0(textLayoutResult, rect, j);
        int iM889getOffsetForPosition0AR0LA1 = m889getOffsetForPosition0AR0LA0(textLayoutResult, rect, j2);
        int iM889getOffsetForPosition0AR0LA2 = offset != null ? m889getOffsetForPosition0AR0LA0(textLayoutResult, rect, offset.m2808unboximpl()) : -1;
        long jMo893adjustZXO7KMw = selectionAdjustment.mo893adjustZXO7KMw(textLayoutResult, TextRangeKt.TextRange(iM889getOffsetForPosition0AR0LA0, iM889getOffsetForPosition0AR0LA1), iM889getOffsetForPosition0AR0LA2, z, selection != null ? TextRange.m4693boximpl(selection.m892toTextRanged9O1mEE()) : null);
        Selection selectionM888getAssembledSelectionInfovJH6DeI = m888getAssembledSelectionInfovJH6DeI(jMo893adjustZXO7KMw, TextRange.m4704getReversedimpl(jMo893adjustZXO7KMw), j3, textLayoutResult);
        boolean zD = AbstractC4492zt.d(selectionM888getAssembledSelectionInfovJH6DeI, selection);
        if (!z ? iM889getOffsetForPosition0AR0LA1 == iM889getOffsetForPosition0AR0LA2 : iM889getOffsetForPosition0AR0LA0 == iM889getOffsetForPosition0AR0LA2) {
            z2 = true;
        } else if (zD) {
            z2 = false;
        } else {
            z2 = true;
        }
        return new C2020dG(selectionM888getAssembledSelectionInfovJH6DeI, Boolean.valueOf(z2));
    }
}
