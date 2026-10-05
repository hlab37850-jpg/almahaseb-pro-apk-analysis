package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Recomposer$recompositionRunner$2$unregisterApplyObserver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recomposer$recompositionRunner$2$unregisterApplyObserver$1(Recomposer recomposer) {
        super(2);
        this.this$0 = recomposer;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Set<? extends Object>) obj, (Snapshot) obj2);
        return FW.a;
    }

    public final void invoke(Set<? extends Object> set, Snapshot snapshot) {
        InterfaceC4293xa interfaceC4293xaDeriveStateLocked;
        AbstractC4492zt.h(set, "changed");
        AbstractC4492zt.h(snapshot, "<anonymous parameter 1>");
        Object obj = this.this$0.stateLock;
        Recomposer recomposer = this.this$0;
        synchronized (obj) {
            if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.Idle) >= 0) {
                recomposer.snapshotInvalidations.addAll((Collection) set);
                interfaceC4293xaDeriveStateLocked = recomposer.deriveStateLocked();
            } else {
                interfaceC4293xaDeriveStateLocked = null;
            }
        }
        if (interfaceC4293xaDeriveStateLocked != null) {
            KL.a aVar = KL.a;
            interfaceC4293xaDeriveStateLocked.resumeWith(KL.a(FW.a));
        }
    }
}
