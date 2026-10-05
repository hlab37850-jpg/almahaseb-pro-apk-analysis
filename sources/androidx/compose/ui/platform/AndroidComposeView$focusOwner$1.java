package androidx.compose.ui.platform;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeView$focusOwner$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidComposeView$focusOwner$1(AndroidComposeView androidComposeView) {
        super(1);
        this.this$0 = androidComposeView;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InterfaceC3588op) obj);
        return FW.a;
    }

    public final void invoke(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "it");
        this.this$0.registerOnEndApplyChangesListener(interfaceC3588op);
    }
}
