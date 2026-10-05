package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldKeyInputKt {
    /* JADX INFO: renamed from: textFieldKeyInput-2WJ9YEU, reason: not valid java name */
    public static final Modifier m824textFieldKeyInput2WJ9YEU(Modifier modifier, TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, InterfaceC3750qp interfaceC3750qp, boolean z, boolean z2, OffsetMapping offsetMapping, UndoManager undoManager, int i) {
        AbstractC4492zt.h(modifier, "$this$textFieldKeyInput");
        AbstractC4492zt.h(textFieldState, "state");
        AbstractC4492zt.h(textFieldSelectionManager, "manager");
        AbstractC4492zt.h(textFieldValue, "value");
        AbstractC4492zt.h(interfaceC3750qp, "onValueChange");
        AbstractC4492zt.h(offsetMapping, "offsetMapping");
        AbstractC4492zt.h(undoManager, "undoManager");
        return ComposedModifierKt.composed$default(modifier, null, new TextFieldKeyInputKt$textFieldKeyInput$2(textFieldState, textFieldSelectionManager, textFieldValue, z, z2, offsetMapping, undoManager, interfaceC3750qp, i), 1, null);
    }
}
