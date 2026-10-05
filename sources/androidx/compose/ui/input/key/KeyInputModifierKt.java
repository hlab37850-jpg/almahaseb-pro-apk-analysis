package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class KeyInputModifierKt {
    public static final Modifier onKeyEvent(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onKeyEvent");
        return modifier.then(new KeyInputElement(interfaceC3750qp, null));
    }

    public static final Modifier onPreviewKeyEvent(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onPreviewKeyEvent");
        return modifier.then(new KeyInputElement(null, interfaceC3750qp));
    }
}
