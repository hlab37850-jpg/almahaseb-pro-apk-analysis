package androidx.compose.ui.node;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class OwnerSnapshotObserver$clearInvalidObservations$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final OwnerSnapshotObserver$clearInvalidObservations$1 INSTANCE = new OwnerSnapshotObserver$clearInvalidObservations$1();

    public OwnerSnapshotObserver$clearInvalidObservations$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        return Boolean.valueOf(!((OwnerScope) obj).isValidOwnerScope());
    }
}
