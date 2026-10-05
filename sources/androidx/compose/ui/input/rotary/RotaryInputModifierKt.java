package androidx.compose.ui.input.rotary;

import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class RotaryInputModifierKt {
    public static final Modifier onPreRotaryScrollEvent(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onPreRotaryScrollEvent");
        return modifier.then(new RotaryInputElement(null, interfaceC3750qp));
    }

    public static final Modifier onRotaryScrollEvent(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onRotaryScrollEvent");
        return modifier.then(new RotaryInputElement(interfaceC3750qp, null));
    }
}
