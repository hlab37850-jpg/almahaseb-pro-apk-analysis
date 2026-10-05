package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class FocusOrderModifierKt {
    public static final Modifier focusOrder(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "focusOrderReceiver");
        return FocusPropertiesKt.focusProperties(modifier, new FocusOrderToProperties(interfaceC3750qp));
    }

    public static final Modifier focusOrder(Modifier modifier, FocusRequester focusRequester) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(focusRequester, "focusRequester");
        return FocusRequesterModifierKt.focusRequester(modifier, focusRequester);
    }

    public static final Modifier focusOrder(Modifier modifier, FocusRequester focusRequester, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(focusRequester, "focusRequester");
        AbstractC4492zt.h(interfaceC3750qp, "focusOrderReceiver");
        return FocusPropertiesKt.focusProperties(FocusRequesterModifierKt.focusRequester(modifier, focusRequester), new FocusOrderToProperties(interfaceC3750qp));
    }
}
