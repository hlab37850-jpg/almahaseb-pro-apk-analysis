package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import androidx.compose.runtime.InternalComposeApi;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.internal.StabilityInferred;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class Snapshot {
    private boolean disposed;
    private int id;
    private SnapshotIdSet invalid;
    private int pinningTrackingHandle;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public static /* synthetic */ Object observe$default(Companion companion, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3588op interfaceC3588op, int i, Object obj) {
            if ((i & 1) != 0) {
                interfaceC3750qp = null;
            }
            if ((i & 2) != 0) {
                interfaceC3750qp2 = null;
            }
            return companion.observe(interfaceC3750qp, interfaceC3750qp2, interfaceC3588op);
        }

        public static /* synthetic */ MutableSnapshot takeMutableSnapshot$default(Companion companion, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, int i, Object obj) {
            if ((i & 1) != 0) {
                interfaceC3750qp = null;
            }
            if ((i & 2) != 0) {
                interfaceC3750qp2 = null;
            }
            return companion.takeMutableSnapshot(interfaceC3750qp, interfaceC3750qp2);
        }

        public static /* synthetic */ Snapshot takeSnapshot$default(Companion companion, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
            if ((i & 1) != 0) {
                interfaceC3750qp = null;
            }
            return companion.takeSnapshot(interfaceC3750qp);
        }

        public final Snapshot createNonObservableSnapshot() {
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default((Snapshot) SnapshotKt.threadSnapshot.get(), null, false, 6, null);
        }

        public final Snapshot getCurrent() {
            return SnapshotKt.currentSnapshot();
        }

        public final <T> T global(InterfaceC3588op interfaceC3588op) {
            AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
            Snapshot snapshotRemoveCurrent = removeCurrent();
            T t = (T) interfaceC3588op.invoke();
            Snapshot.Companion.restoreCurrent(snapshotRemoveCurrent);
            return t;
        }

        public final boolean isApplyObserverNotificationPending() {
            return SnapshotKt.pendingApplyObserverCount.get() > 0;
        }

        public final void notifyObjectsInitialized() {
            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime_release();
        }

        public final <T> T observe(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3588op interfaceC3588op) {
            Snapshot transparentObserverMutableSnapshot;
            AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
            if (interfaceC3750qp == null && interfaceC3750qp2 == null) {
                return (T) interfaceC3588op.invoke();
            }
            Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
            if (snapshot == null || (snapshot instanceof MutableSnapshot)) {
                transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, interfaceC3750qp, interfaceC3750qp2, true, false);
            } else {
                if (interfaceC3750qp == null) {
                    return (T) interfaceC3588op.invoke();
                }
                transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(interfaceC3750qp);
            }
            try {
                Snapshot snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                try {
                    T t = (T) interfaceC3588op.invoke();
                    transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    transparentObserverMutableSnapshot.dispose();
                    return t;
                } catch (Throwable th) {
                    transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            } catch (Throwable th2) {
                transparentObserverMutableSnapshot.dispose();
                throw th2;
            }
        }

        @InternalComposeApi
        public final int openSnapshotCount() {
            return AbstractC3240kc.C0(SnapshotKt.openSnapshots).size();
        }

        public final ObserverHandle registerApplyObserver(final InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, "observer");
            SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.applyObservers.add(interfaceC0526Fp);
            }
            return new ObserverHandle() { // from class: androidx.compose.runtime.snapshots.Snapshot$Companion$registerApplyObserver$2
                @Override // androidx.compose.runtime.snapshots.ObserverHandle
                public final void dispose() {
                    InterfaceC0526Fp interfaceC0526Fp2 = interfaceC0526Fp;
                    synchronized (SnapshotKt.getLock()) {
                        SnapshotKt.applyObservers.remove(interfaceC0526Fp2);
                        FW fw = FW.a;
                    }
                }
            };
        }

        public final ObserverHandle registerGlobalWriteObserver(final InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "observer");
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.globalWriteObservers.add(interfaceC3750qp);
            }
            SnapshotKt.advanceGlobalSnapshot();
            return new ObserverHandle() { // from class: androidx.compose.runtime.snapshots.Snapshot$Companion$registerGlobalWriteObserver$2
                @Override // androidx.compose.runtime.snapshots.ObserverHandle
                public final void dispose() {
                    InterfaceC3750qp interfaceC3750qp2 = interfaceC3750qp;
                    synchronized (SnapshotKt.getLock()) {
                        SnapshotKt.globalWriteObservers.remove(interfaceC3750qp2);
                    }
                    SnapshotKt.advanceGlobalSnapshot();
                }
            };
        }

        public final Snapshot removeCurrent() {
            Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
            if (snapshot != null) {
                SnapshotKt.threadSnapshot.set(null);
            }
            return snapshot;
        }

        public final void restoreCurrent(Snapshot snapshot) {
            if (snapshot != null) {
                SnapshotKt.threadSnapshot.set(snapshot);
            }
        }

        public final void sendApplyNotifications() {
            boolean z;
            synchronized (SnapshotKt.getLock()) {
                IdentityArraySet<StateObject> modified$runtime_release = ((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getModified$runtime_release();
                z = false;
                if (modified$runtime_release != null && modified$runtime_release.isNotEmpty()) {
                    z = true;
                }
            }
            if (z) {
                SnapshotKt.advanceGlobalSnapshot();
            }
        }

        public final MutableSnapshot takeMutableSnapshot(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
            MutableSnapshot mutableSnapshotTakeNestedMutableSnapshot;
            Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            MutableSnapshot mutableSnapshot = snapshotCurrentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshotCurrentSnapshot : null;
            if (mutableSnapshot == null || (mutableSnapshotTakeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(interfaceC3750qp, interfaceC3750qp2)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            return mutableSnapshotTakeNestedMutableSnapshot;
        }

        public final Snapshot takeSnapshot(InterfaceC3750qp interfaceC3750qp) {
            return SnapshotKt.currentSnapshot().takeNestedSnapshot(interfaceC3750qp);
        }

        public final <R> R withMutableSnapshot(InterfaceC3588op interfaceC3588op) {
            AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
            MutableSnapshot mutableSnapshotTakeMutableSnapshot$default = takeMutableSnapshot$default(this, null, null, 3, null);
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot$default.makeCurrent();
                try {
                    R r = (R) interfaceC3588op.invoke();
                    AbstractC0703Ks.b(1);
                    mutableSnapshotTakeMutableSnapshot$default.restoreCurrent(snapshotMakeCurrent);
                    AbstractC0703Ks.a(1);
                    mutableSnapshotTakeMutableSnapshot$default.apply().check();
                    AbstractC0703Ks.b(1);
                    mutableSnapshotTakeMutableSnapshot$default.dispose();
                    return r;
                } finally {
                    AbstractC0703Ks.b(1);
                    mutableSnapshotTakeMutableSnapshot$default.restoreCurrent(snapshotMakeCurrent);
                    AbstractC0703Ks.a(1);
                }
            } catch (Throwable th) {
                AbstractC0703Ks.b(1);
                mutableSnapshotTakeMutableSnapshot$default.dispose();
                AbstractC0703Ks.a(1);
                throw th;
            }
        }

        public final <T> T withoutReadObservation(InterfaceC3588op interfaceC3588op) {
            AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
            Snapshot snapshotCreateNonObservableSnapshot = createNonObservableSnapshot();
            try {
                Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                try {
                    T t = (T) interfaceC3588op.invoke();
                    AbstractC0703Ks.b(1);
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    AbstractC0703Ks.a(1);
                    AbstractC0703Ks.b(1);
                    snapshotCreateNonObservableSnapshot.dispose();
                    return t;
                } finally {
                    AbstractC0703Ks.b(1);
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    AbstractC0703Ks.a(1);
                }
            } catch (Throwable th) {
                AbstractC0703Ks.b(1);
                snapshotCreateNonObservableSnapshot.dispose();
                AbstractC0703Ks.a(1);
                throw th;
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ Snapshot(int i, SnapshotIdSet snapshotIdSet, AbstractC0419Di abstractC0419Di) {
        this(i, snapshotIdSet);
    }

    private static /* synthetic */ void getPinningTrackingHandle$annotations() {
    }

    public static /* synthetic */ Snapshot takeNestedSnapshot$default(Snapshot snapshot, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedSnapshot");
        }
        if ((i & 1) != 0) {
            interfaceC3750qp = null;
        }
        return snapshot.takeNestedSnapshot(interfaceC3750qp);
    }

    public final void closeAndReleasePinning$runtime_release() {
        synchronized (SnapshotKt.getLock()) {
            closeLocked$runtime_release();
            releasePinnedSnapshotsForCloseLocked$runtime_release();
            FW fw = FW.a;
        }
    }

    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId());
    }

    public void dispose() {
        this.disposed = true;
        synchronized (SnapshotKt.getLock()) {
            releasePinnedSnapshotLocked$runtime_release();
            FW fw = FW.a;
        }
    }

    public final <T> T enter(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        Snapshot snapshotMakeCurrent = makeCurrent();
        try {
            return (T) interfaceC3588op.invoke();
        } finally {
            AbstractC0703Ks.b(1);
            restoreCurrent(snapshotMakeCurrent);
            AbstractC0703Ks.a(1);
        }
    }

    public final boolean getDisposed$runtime_release() {
        return this.disposed;
    }

    public int getId() {
        return this.id;
    }

    public SnapshotIdSet getInvalid$runtime_release() {
        return this.invalid;
    }

    public abstract IdentityArraySet<StateObject> getModified$runtime_release();

    public abstract InterfaceC3750qp getReadObserver$runtime_release();

    public abstract boolean getReadOnly();

    public abstract Snapshot getRoot();

    public int getWriteCount$runtime_release() {
        return 0;
    }

    public abstract InterfaceC3750qp getWriteObserver$runtime_release();

    public abstract boolean hasPendingChanges();

    public final boolean isPinned$runtime_release() {
        return this.pinningTrackingHandle >= 0;
    }

    public Snapshot makeCurrent() {
        Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
        SnapshotKt.threadSnapshot.set(this);
        return snapshot;
    }

    /* JADX INFO: renamed from: nestedActivated$runtime_release */
    public abstract void mo2675nestedActivated$runtime_release(Snapshot snapshot);

    /* JADX INFO: renamed from: nestedDeactivated$runtime_release */
    public abstract void mo2676nestedDeactivated$runtime_release(Snapshot snapshot);

    public abstract void notifyObjectsInitialized$runtime_release();

    /* JADX INFO: renamed from: recordModified$runtime_release */
    public abstract void mo2678recordModified$runtime_release(StateObject stateObject);

    public final void releasePinnedSnapshotLocked$runtime_release() {
        int i = this.pinningTrackingHandle;
        if (i >= 0) {
            SnapshotKt.releasePinningLocked(i);
            this.pinningTrackingHandle = -1;
        }
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePinnedSnapshotLocked$runtime_release();
    }

    public void restoreCurrent(Snapshot snapshot) {
        SnapshotKt.threadSnapshot.set(snapshot);
    }

    public final void setDisposed$runtime_release(boolean z) {
        this.disposed = z;
    }

    public void setId$runtime_release(int i) {
        this.id = i;
    }

    public void setInvalid$runtime_release(SnapshotIdSet snapshotIdSet) {
        AbstractC4492zt.h(snapshotIdSet, "<set-?>");
        this.invalid = snapshotIdSet;
    }

    public void setWriteCount$runtime_release(int i) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }

    public abstract Snapshot takeNestedSnapshot(InterfaceC3750qp interfaceC3750qp);

    public final int takeoverPinnedSnapshot$runtime_release() {
        int i = this.pinningTrackingHandle;
        this.pinningTrackingHandle = -1;
        return i;
    }

    @ExperimentalComposeApi
    public final Snapshot unsafeEnter() {
        return makeCurrent();
    }

    @ExperimentalComposeApi
    public final void unsafeLeave(Snapshot snapshot) {
        if (SnapshotKt.threadSnapshot.get() == this) {
            restoreCurrent(snapshot);
            return;
        }
        throw new IllegalStateException(("Cannot leave snapshot; " + this + " is not the current snapshot").toString());
    }

    public final void validateNotDisposed$runtime_release() {
        if (this.disposed) {
            throw new IllegalArgumentException("Cannot use a disposed snapshot");
        }
    }

    private Snapshot(int i, SnapshotIdSet snapshotIdSet) {
        this.invalid = snapshotIdSet;
        this.id = i;
        this.pinningTrackingHandle = i != 0 ? SnapshotKt.trackPinning(i, getInvalid$runtime_release()) : -1;
    }
}
