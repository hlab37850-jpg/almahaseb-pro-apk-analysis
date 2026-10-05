package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusOrder;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusProperties;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class FocusOrderModifierToProperties implements InterfaceC3750qp {
    private final FocusOrderModifier modifier;

    public FocusOrderModifierToProperties(FocusOrderModifier focusOrderModifier) {
        AbstractC4492zt.h(focusOrderModifier, "modifier");
        this.modifier = focusOrderModifier;
    }

    public final FocusOrderModifier getModifier() {
        return this.modifier;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusProperties) obj);
        return FW.a;
    }

    public void invoke(FocusProperties focusProperties) {
        AbstractC4492zt.h(focusProperties, "focusProperties");
        this.modifier.populateFocusOrder(new FocusOrder(focusProperties));
    }
}
