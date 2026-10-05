package androidx.compose.runtime.snapshots;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C1182Zu;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GlobalSnapshot extends MutableSnapshot {

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedMutableSnapshot$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $readObserver;
        final /* synthetic */ InterfaceC3750qp $writeObserver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
            super(1);
            this.$readObserver = interfaceC3750qp;
            this.$writeObserver = interfaceC3750qp2;
        }

        @Override // defpackage.InterfaceC3750qp
        public final MutableSnapshot invoke(SnapshotIdSet snapshotIdSet) {
            int i;
            AbstractC4492zt.h(snapshotIdSet, "invalid");
            synchronized (SnapshotKt.getLock()) {
                i = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i + 1;
            }
            return new MutableSnapshot(i, snapshotIdSet, this.$readObserver, this.$writeObserver);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedSnapshot$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16431 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $readObserver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16431(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$readObserver = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public final ReadonlySnapshot invoke(SnapshotIdSet snapshotIdSet) {
            int i;
            AbstractC4492zt.h(snapshotIdSet, "invalid");
            synchronized (SnapshotKt.getLock()) {
                i = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i + 1;
            }
            return new ReadonlySnapshot(i, snapshotIdSet, this.$readObserver);
        }
    }

    public GlobalSnapshot(int i, SnapshotIdSet snapshotIdSet) {
        InterfaceC3750qp globalSnapshot$1$1$1;
        AbstractC4492zt.h(snapshotIdSet, "invalid");
        synchronized (SnapshotKt.getLock()) {
            try {
                List listF0 = !SnapshotKt.globalWriteObservers.isEmpty() ? AbstractC3240kc.F0(SnapshotKt.globalWriteObservers) : null;
                if (listF0 != null) {
                    globalSnapshot$1$1$1 = (InterfaceC3750qp) AbstractC3240kc.u0(listF0);
                    if (globalSnapshot$1$1$1 == null) {
                        globalSnapshot$1$1$1 = new GlobalSnapshot$1$1$1(listF0);
                    }
                } else {
                    globalSnapshot$1$1$1 = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        super(i, snapshotIdSet, null, globalSnapshot$1$1$1);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public SnapshotApplyResult apply() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot");
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        synchronized (SnapshotKt.getLock()) {
            releasePinnedSnapshotLocked$runtime_release();
            FW fw = FW.a;
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        SnapshotKt.advanceGlobalSnapshot();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public MutableSnapshot takeNestedMutableSnapshot(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        return (MutableSnapshot) SnapshotKt.takeNewSnapshot(new AnonymousClass1(interfaceC3750qp, interfaceC3750qp2));
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(InterfaceC3750qp interfaceC3750qp) {
        return SnapshotKt.takeNewSnapshot(new C16431(interfaceC3750qp));
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedActivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo2675nestedActivated$runtime_release(Snapshot snapshot) {
        AbstractC4492zt.h(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new C1182Zu();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedDeactivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo2676nestedDeactivated$runtime_release(Snapshot snapshot) {
        AbstractC4492zt.h(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new C1182Zu();
    }
}
