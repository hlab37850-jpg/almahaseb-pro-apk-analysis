package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import defpackage.AbstractC4492zt;
import defpackage.C1182Zu;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class NestedReadonlySnapshot extends Snapshot {
    private final Snapshot parent;
    private final InterfaceC3750qp readObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedReadonlySnapshot(int i, SnapshotIdSet snapshotIdSet, InterfaceC3750qp interfaceC3750qp, Snapshot snapshot) {
        super(i, snapshotIdSet, null);
        AbstractC4492zt.h(snapshotIdSet, "invalid");
        AbstractC4492zt.h(snapshot, "parent");
        this.parent = snapshot;
        snapshot.mo2675nestedActivated$runtime_release(this);
        if (interfaceC3750qp != null) {
            InterfaceC3750qp readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
            if (readObserver$runtime_release != null) {
                interfaceC3750qp = new NestedReadonlySnapshot$readObserver$1$1$1(interfaceC3750qp, readObserver$runtime_release);
            }
        } else {
            interfaceC3750qp = snapshot.getReadObserver$runtime_release();
        }
        this.readObserver = interfaceC3750qp;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release()) {
            return;
        }
        if (getId() != this.parent.getId()) {
            closeAndReleasePinning$runtime_release();
        }
        this.parent.mo2676nestedDeactivated$runtime_release(this);
        super.dispose();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public IdentityArraySet<StateObject> getModified$runtime_release() {
        return null;
    }

    public final Snapshot getParent() {
        return this.parent;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public InterfaceC3750qp getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return true;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this.parent.getRoot();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public InterfaceC3750qp getWriteObserver$runtime_release() {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedActivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo2675nestedActivated$runtime_release(Snapshot snapshot) {
        AbstractC4492zt.h(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new C1182Zu();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedDeactivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo2676nestedDeactivated$runtime_release(Snapshot snapshot) {
        AbstractC4492zt.h(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new C1182Zu();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: recordModified$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo2678recordModified$runtime_release(StateObject stateObject) {
        AbstractC4492zt.h(stateObject, "state");
        SnapshotKt.reportReadonlySnapshotWrite();
        throw new C1182Zu();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public NestedReadonlySnapshot takeNestedSnapshot(InterfaceC3750qp interfaceC3750qp) {
        return new NestedReadonlySnapshot(getId(), getInvalid$runtime_release(), interfaceC3750qp, this.parent);
    }
}
