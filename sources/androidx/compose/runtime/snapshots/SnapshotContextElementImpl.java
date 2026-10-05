package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC4287xU;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeApi
final class SnapshotContextElementImpl implements SnapshotContextElement, InterfaceC4287xU {
    private final Snapshot snapshot;

    public SnapshotContextElementImpl(Snapshot snapshot) {
        AbstractC4492zt.h(snapshot, "snapshot");
        this.snapshot = snapshot;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, defpackage.InterfaceC0988Vf
    public <R> R fold(R r, InterfaceC0526Fp interfaceC0526Fp) {
        return (R) SnapshotContextElement.DefaultImpls.fold(this, r, interfaceC0526Fp);
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, defpackage.InterfaceC0988Vf.b, defpackage.InterfaceC0988Vf
    public <E extends InterfaceC0988Vf.b> E get(InterfaceC0988Vf.c cVar) {
        return (E) SnapshotContextElement.DefaultImpls.get(this, cVar);
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, defpackage.InterfaceC0988Vf.b
    public InterfaceC0988Vf.c getKey() {
        return SnapshotContextElement.Key;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar) {
        return SnapshotContextElement.DefaultImpls.minusKey(this, cVar);
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotContextElement, defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf) {
        return SnapshotContextElement.DefaultImpls.plus(this, interfaceC0988Vf);
    }

    @Override // defpackage.InterfaceC4287xU
    public void restoreThreadContext(InterfaceC0988Vf interfaceC0988Vf, Snapshot snapshot) {
        AbstractC4492zt.h(interfaceC0988Vf, "context");
        this.snapshot.unsafeLeave(snapshot);
    }

    @Override // defpackage.InterfaceC4287xU
    public Snapshot updateThreadContext(InterfaceC0988Vf interfaceC0988Vf) {
        AbstractC4492zt.h(interfaceC0988Vf, "context");
        return this.snapshot.unsafeEnter();
    }
}
