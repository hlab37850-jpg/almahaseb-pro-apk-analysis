package androidx.compose.runtime.snapshots;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateObserver$applyObserver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ SnapshotStateObserver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotStateObserver$applyObserver$1(SnapshotStateObserver snapshotStateObserver) {
        super(2);
        this.this$0 = snapshotStateObserver;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Set<? extends Object>) obj, (Snapshot) obj2);
        return FW.a;
    }

    public final void invoke(Set<? extends Object> set, Snapshot snapshot) {
        AbstractC4492zt.h(set, "applied");
        AbstractC4492zt.h(snapshot, "<anonymous parameter 1>");
        this.this$0.addChanges(set);
        if (this.this$0.drainChanges()) {
            this.this$0.sendNotifications();
        }
    }
}
