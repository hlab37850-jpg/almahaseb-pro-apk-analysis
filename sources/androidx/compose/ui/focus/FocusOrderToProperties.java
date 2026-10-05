package androidx.compose.ui.focus;

import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class FocusOrderToProperties implements InterfaceC3750qp {
    private final InterfaceC3750qp focusOrderReceiver;

    public FocusOrderToProperties(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "focusOrderReceiver");
        this.focusOrderReceiver = interfaceC3750qp;
    }

    public final InterfaceC3750qp getFocusOrderReceiver() {
        return this.focusOrderReceiver;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusProperties) obj);
        return FW.a;
    }

    public void invoke(FocusProperties focusProperties) {
        AbstractC4492zt.h(focusProperties, "focusProperties");
        this.focusOrderReceiver.invoke(new FocusOrder(focusProperties));
    }
}
