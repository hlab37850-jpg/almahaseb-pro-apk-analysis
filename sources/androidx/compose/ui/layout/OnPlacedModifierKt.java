package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class OnPlacedModifierKt {
    @Stable
    public static final Modifier onPlaced(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onPlaced");
        return modifier.then(new OnPlacedElement(interfaceC3750qp));
    }
}
