package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.MutableVector;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateObserver$readObserver$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ SnapshotStateObserver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotStateObserver$readObserver$1(SnapshotStateObserver snapshotStateObserver) {
        super(1);
        this.this$0 = snapshotStateObserver;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m2682invoke(obj);
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2682invoke(Object obj) {
        AbstractC4492zt.h(obj, "state");
        if (this.this$0.isPaused) {
            return;
        }
        MutableVector mutableVector = this.this$0.observedScopeMaps;
        SnapshotStateObserver snapshotStateObserver = this.this$0;
        synchronized (mutableVector) {
            SnapshotStateObserver.ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
            AbstractC4492zt.e(observedScopeMap);
            observedScopeMap.recordRead(obj);
            FW fw = FW.a;
        }
    }
}
