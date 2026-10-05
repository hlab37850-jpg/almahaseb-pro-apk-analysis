package androidx.compose.ui.node;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1 INSTANCE = new ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1();

    public ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ObserverNodeOwnerScope) obj);
        return FW.a;
    }

    public final void invoke(ObserverNodeOwnerScope observerNodeOwnerScope) {
        AbstractC4492zt.h(observerNodeOwnerScope, "it");
        if (observerNodeOwnerScope.isValidOwnerScope()) {
            observerNodeOwnerScope.getObserverNode$ui_release().onObservedReadsChanged();
        }
    }
}
