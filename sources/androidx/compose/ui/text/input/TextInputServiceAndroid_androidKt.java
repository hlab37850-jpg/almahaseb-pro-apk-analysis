package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import defpackage.AbstractC4492zt;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    public static final Executor asExecutor(final Choreographer choreographer) {
        AbstractC4492zt.h(choreographer, "<this>");
        return new Executor() { // from class: rU
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.asExecutor$lambda$1(choreographer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asExecutor$lambda$1(Choreographer choreographer, final Runnable runnable) {
        AbstractC4492zt.h(choreographer, "$this_asExecutor");
        choreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: qU
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                runnable.run();
            }
        });
    }

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        AbstractC4492zt.h(editorInfo, "<this>");
        AbstractC4492zt.h(imeOptions, "imeOptions");
        AbstractC4492zt.h(textFieldValue, "textFieldValue");
        int iM4873getImeActioneUduSuo = imeOptions.m4873getImeActioneUduSuo();
        ImeAction.Companion companion = ImeAction.Companion;
        int i = 6;
        if (ImeAction.m4850equalsimpl0(iM4873getImeActioneUduSuo, companion.m4862getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m4850equalsimpl0(iM4873getImeActioneUduSuo, companion.m4866getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m4850equalsimpl0(iM4873getImeActioneUduSuo, companion.m4864getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m4850equalsimpl0(iM4873getImeActioneUduSuo, companion.m4865getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m4850equalsimpl0(iM4873getImeActioneUduSuo, companion.m4867getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m4850equalsimpl0(iM4873getImeActioneUduSuo, companion.m4868getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m4850equalsimpl0(iM4873getImeActioneUduSuo, companion.m4869getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m4850equalsimpl0(iM4873getImeActioneUduSuo, companion.m4863getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction");
        }
        editorInfo.imeOptions = i;
        int iM4874getKeyboardTypePjHm6EE = imeOptions.m4874getKeyboardTypePjHm6EE();
        KeyboardType.Companion companion2 = KeyboardType.Companion;
        if (KeyboardType.m4895equalsimpl0(iM4874getKeyboardTypePjHm6EE, companion2.m4915getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m4895equalsimpl0(iM4874getKeyboardTypePjHm6EE, companion2.m4908getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m4895equalsimpl0(iM4874getKeyboardTypePjHm6EE, companion2.m4911getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m4895equalsimpl0(iM4874getKeyboardTypePjHm6EE, companion2.m4914getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m4895equalsimpl0(iM4874getKeyboardTypePjHm6EE, companion2.m4916getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m4895equalsimpl0(iM4874getKeyboardTypePjHm6EE, companion2.m4910getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m4895equalsimpl0(iM4874getKeyboardTypePjHm6EE, companion2.m4913getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m4895equalsimpl0(iM4874getKeyboardTypePjHm6EE, companion2.m4912getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else {
            if (!KeyboardType.m4895equalsimpl0(iM4874getKeyboardTypePjHm6EE, companion2.m4909getDecimalPjHm6EE())) {
                throw new IllegalStateException("Invalid Keyboard Type");
            }
            editorInfo.inputType = 8194;
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m4850equalsimpl0(imeOptions.m4873getImeActioneUduSuo(), companion.m4862getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int iM4872getCapitalizationIUNYP9k = imeOptions.m4872getCapitalizationIUNYP9k();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.Companion;
            if (KeyboardCapitalization.m4880equalsimpl0(iM4872getCapitalizationIUNYP9k, companion3.m4888getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m4880equalsimpl0(iM4872getCapitalizationIUNYP9k, companion3.m4891getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m4880equalsimpl0(iM4872getCapitalizationIUNYP9k, companion3.m4890getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m4705getStartimpl(textFieldValue.m4922getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m4700getEndimpl(textFieldValue.m4922getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }
}
