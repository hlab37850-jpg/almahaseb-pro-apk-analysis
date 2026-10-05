package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutModifierKt {
    public static final Modifier layout(Modifier modifier, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp, "measure");
        return modifier.then(new LayoutElement(interfaceC0552Gp));
    }
}
