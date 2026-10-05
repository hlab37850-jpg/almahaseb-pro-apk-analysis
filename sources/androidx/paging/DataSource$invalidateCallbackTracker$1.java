package androidx.paging;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class DataSource$invalidateCallbackTracker$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final DataSource$invalidateCallbackTracker$1 INSTANCE = new DataSource$invalidateCallbackTracker$1();

    public DataSource$invalidateCallbackTracker$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DataSource.InvalidatedCallback) obj);
        return FW.a;
    }

    public final void invoke(DataSource.InvalidatedCallback invalidatedCallback) {
        AbstractC4492zt.h(invalidatedCallback, "it");
        invalidatedCallback.onInvalidated();
    }
}
