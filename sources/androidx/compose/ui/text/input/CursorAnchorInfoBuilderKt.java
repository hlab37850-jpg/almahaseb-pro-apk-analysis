package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class CursorAnchorInfoBuilderKt {
    public static final CursorAnchorInfo build(CursorAnchorInfo.Builder builder, TextFieldValue textFieldValue, TextLayoutResult textLayoutResult, Matrix matrix) {
        AbstractC4492zt.h(builder, "<this>");
        AbstractC4492zt.h(textFieldValue, "textFieldValue");
        AbstractC4492zt.h(textLayoutResult, "textLayoutResult");
        AbstractC4492zt.h(matrix, "matrix");
        builder.reset();
        builder.setMatrix(matrix);
        int iM4703getMinimpl = TextRange.m4703getMinimpl(textFieldValue.m4922getSelectiond9O1mEE());
        builder.setSelectionRange(iM4703getMinimpl, TextRange.m4702getMaximpl(textFieldValue.m4922getSelectiond9O1mEE()));
        setInsertionMarker(builder, iM4703getMinimpl, textLayoutResult);
        TextRange textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
        int iM4703getMinimpl2 = textRangeM4921getCompositionMzsxiRA != null ? TextRange.m4703getMinimpl(textRangeM4921getCompositionMzsxiRA.m4709unboximpl()) : -1;
        TextRange textRangeM4921getCompositionMzsxiRA2 = textFieldValue.m4921getCompositionMzsxiRA();
        int iM4702getMaximpl = textRangeM4921getCompositionMzsxiRA2 != null ? TextRange.m4702getMaximpl(textRangeM4921getCompositionMzsxiRA2.m4709unboximpl()) : -1;
        if (iM4703getMinimpl2 >= 0 && iM4703getMinimpl2 < iM4702getMaximpl) {
            builder.setComposingText(iM4703getMinimpl2, textFieldValue.getText().subSequence(iM4703getMinimpl2, iM4702getMaximpl));
        }
        CursorAnchorInfo cursorAnchorInfoBuild = builder.build();
        AbstractC4492zt.g(cursorAnchorInfoBuild, "build()");
        return cursorAnchorInfoBuild;
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i, TextLayoutResult textLayoutResult) {
        if (i < 0) {
            return builder;
        }
        Rect cursorRect = textLayoutResult.getCursorRect(i);
        builder.setInsertionMarkerLocation(cursorRect.getLeft(), cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), textLayoutResult.getBidiRunDirection(i) == ResolvedTextDirection.Rtl ? 4 : 0);
        return builder;
    }
}
