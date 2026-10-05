package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerIconKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class BasicText_androidKt {
    public static final Modifier textPointerHoverIcon(Modifier modifier, SelectionRegistrar selectionRegistrar) {
        AbstractC4492zt.h(modifier, "<this>");
        return selectionRegistrar == null ? modifier : PointerIconKt.pointerHoverIcon$default(modifier, TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
    }
}
