package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC1009Wa;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ InterfaceC1009Wa $appliedChanges;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1(InterfaceC1009Wa interfaceC1009Wa) {
        super(2);
        this.$appliedChanges = interfaceC1009Wa;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Set<? extends Object>) obj, (Snapshot) obj2);
        return FW.a;
    }

    public final void invoke(Set<? extends Object> set, Snapshot snapshot) {
        AbstractC4492zt.h(set, "changed");
        AbstractC4492zt.h(snapshot, "<anonymous parameter 1>");
        this.$appliedChanges.mo0trySendJP2dKIU(set);
    }
}
