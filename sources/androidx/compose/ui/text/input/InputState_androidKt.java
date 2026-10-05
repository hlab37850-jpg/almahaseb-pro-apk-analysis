package androidx.compose.ui.text.input;

import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.text.TextRange;
import defpackage.AbstractC3961tS;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class InputState_androidKt {
    public static final ExtractedText toExtractedText(TextFieldValue textFieldValue) {
        AbstractC4492zt.h(textFieldValue, "<this>");
        ExtractedText extractedText = new ExtractedText();
        extractedText.text = textFieldValue.getText();
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = textFieldValue.getText().length();
        extractedText.partialStartOffset = -1;
        extractedText.selectionStart = TextRange.m4703getMinimpl(textFieldValue.m4922getSelectiond9O1mEE());
        extractedText.selectionEnd = TextRange.m4702getMaximpl(textFieldValue.m4922getSelectiond9O1mEE());
        extractedText.flags = !AbstractC3961tS.F(textFieldValue.getText(), '\n', false, 2, null) ? 1 : 0;
        return extractedText;
    }
}
