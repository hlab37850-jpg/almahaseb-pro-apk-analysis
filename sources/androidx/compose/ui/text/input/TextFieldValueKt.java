package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldValueKt {
    public static final AnnotatedString getSelectedText(TextFieldValue textFieldValue) {
        AbstractC4492zt.h(textFieldValue, "<this>");
        return textFieldValue.getAnnotatedString().m4583subSequence5zctL8(textFieldValue.m4922getSelectiond9O1mEE());
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue textFieldValue, int i) {
        AbstractC4492zt.h(textFieldValue, "<this>");
        return textFieldValue.getAnnotatedString().subSequence(TextRange.m4702getMaximpl(textFieldValue.m4922getSelectiond9O1mEE()), Math.min(TextRange.m4702getMaximpl(textFieldValue.m4922getSelectiond9O1mEE()) + i, textFieldValue.getText().length()));
    }

    public static final AnnotatedString getTextBeforeSelection(TextFieldValue textFieldValue, int i) {
        AbstractC4492zt.h(textFieldValue, "<this>");
        return textFieldValue.getAnnotatedString().subSequence(Math.max(0, TextRange.m4703getMinimpl(textFieldValue.m4922getSelectiond9O1mEE()) - i), TextRange.m4703getMinimpl(textFieldValue.m4922getSelectiond9O1mEE()));
    }
}
