package androidx.compose.ui.focus;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class FocusRequester$focus$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final FocusRequester$focus$1$1 INSTANCE = new FocusRequester$focus$1$1();

    public FocusRequester$focus$1$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(FocusTargetNode focusTargetNode) {
        AbstractC4492zt.h(focusTargetNode, "it");
        return Boolean.valueOf(FocusTransactionsKt.requestFocus(focusTargetNode));
    }
}
