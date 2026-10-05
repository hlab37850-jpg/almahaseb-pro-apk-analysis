package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class FocusEventModifierKt {
    public static final Modifier onFocusEvent(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onFocusEvent");
        return modifier.then(new FocusEventElement(interfaceC3750qp));
    }
}
