package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class FocusModifierKt {
    public static final Modifier focusModifier(Modifier modifier) {
        AbstractC4492zt.h(modifier, "<this>");
        return focusTarget(modifier);
    }

    public static final Modifier focusTarget(Modifier modifier) {
        AbstractC4492zt.h(modifier, "<this>");
        return modifier.then(FocusTargetNode.FocusTargetElement.INSTANCE);
    }
}
