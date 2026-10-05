package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.internal.StabilityInferred;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C1182Zu;
import defpackage.C2020dG;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.Q5;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public class MutableSnapshot extends Snapshot {
    private boolean applied;
    private List<? extends StateObject> merged;
    private IdentityArraySet<StateObject> modified;
    private SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final InterfaceC3750qp readObserver;
    private int snapshots;
    private int writeCount;
    private final InterfaceC3750qp writeObserver;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final int[] EmptyIntArray = new int[0];

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableSnapshot(int i, SnapshotIdSet snapshotIdSet, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        super(i, snapshotIdSet, null);
        AbstractC4492zt.h(snapshotIdSet, "invalid");
        this.readObserver = interfaceC3750qp;
        this.writeObserver = interfaceC3750qp2;
        this.previousIds = SnapshotIdSet.Companion.getEMPTY();
        this.previousPinnedSnapshots = EmptyIntArray;
        this.snapshots = 1;
    }

    private final void abandon() {
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            validateNotApplied();
            setModified(null);
            int id = getId();
            Object[] values = modified$runtime_release.getValues();
            int size = modified$runtime_release.size();
            for (int i = 0; i < size; i++) {
                Object obj = values[i];
                AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                for (StateRecord firstStateRecord = ((StateObject) obj).getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
                    if (firstStateRecord.getSnapshotId$runtime_release() == id || AbstractC3240kc.U(this.previousIds, Integer.valueOf(firstStateRecord.getSnapshotId$runtime_release()))) {
                        firstStateRecord.setSnapshotId$runtime_release(0);
                    }
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        int length = this.previousPinnedSnapshots.length;
        for (int i = 0; i < length; i++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[i]);
        }
    }

    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
        }
        if ((i & 1) != 0) {
            interfaceC3750qp = null;
        }
        if ((i & 2) != 0) {
            interfaceC3750qp2 = null;
        }
        return mutableSnapshot.takeNestedMutableSnapshot(interfaceC3750qp, interfaceC3750qp2);
    }

    private final void validateNotApplied() {
        if (this.applied) {
            throw new IllegalStateException("Unsupported operation on a snapshot that has been applied");
        }
    }

    private final void validateNotAppliedOrPinned() {
        if (this.applied && ((Snapshot) this).pinningTrackingHandle < 0) {
            throw new IllegalStateException("Unsupported operation on a disposed or applied snapshot");
        }
    }

    public final <T> T advance$runtime_release(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        recordPrevious$runtime_release(getId());
        T t = (T) interfaceC3588op.invoke();
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id = getId();
            synchronized (SnapshotKt.getLock()) {
                try {
                    int i = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = i + 1;
                    setId$runtime_release(i);
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                    FW fw = FW.a;
                    AbstractC0703Ks.b(1);
                } catch (Throwable th) {
                    AbstractC0703Ks.b(1);
                    AbstractC0703Ks.a(1);
                    throw th;
                }
            }
            AbstractC0703Ks.a(1);
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
        }
        return t;
    }

    public SnapshotApplyResult apply() {
        Map<StateRecord, ? extends StateRecord> mapOptimisticMerges;
        IdentityArraySet<StateObject> modified$runtime_release;
        IdentityArraySet<StateObject> modified$runtime_release2 = getModified$runtime_release();
        if (modified$runtime_release2 != null) {
            Object obj = SnapshotKt.currentGlobalSnapshot.get();
            AbstractC4492zt.g(obj, "currentGlobalSnapshot.get()");
            mapOptimisticMerges = SnapshotKt.optimisticMerges((MutableSnapshot) obj, this, SnapshotKt.openSnapshots.clear(((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getId()));
        } else {
            mapOptimisticMerges = null;
        }
        List listM = AbstractC1886cc.m();
        synchronized (SnapshotKt.getLock()) {
            try {
                SnapshotKt.validateOpen(this);
                if (modified$runtime_release2 == null || modified$runtime_release2.size() == 0) {
                    closeLocked$runtime_release();
                    GlobalSnapshot globalSnapshot = (GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get();
                    AbstractC4492zt.g(globalSnapshot, "previousGlobalSnapshot");
                    SnapshotKt.takeNewGlobalSnapshot(globalSnapshot, SnapshotKt.emptyLambda);
                    modified$runtime_release = globalSnapshot.getModified$runtime_release();
                    if (modified$runtime_release == null || modified$runtime_release.isEmpty()) {
                        modified$runtime_release = null;
                    } else {
                        listM = AbstractC3240kc.F0(SnapshotKt.applyObservers);
                    }
                } else {
                    GlobalSnapshot globalSnapshot2 = (GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get();
                    SnapshotApplyResult snapshotApplyResultInnerApplyLocked$runtime_release = innerApplyLocked$runtime_release(SnapshotKt.nextSnapshotId, mapOptimisticMerges, SnapshotKt.openSnapshots.clear(globalSnapshot2.getId()));
                    if (!AbstractC4492zt.d(snapshotApplyResultInnerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                        return snapshotApplyResultInnerApplyLocked$runtime_release;
                    }
                    closeLocked$runtime_release();
                    AbstractC4492zt.g(globalSnapshot2, "previousGlobalSnapshot");
                    SnapshotKt.takeNewGlobalSnapshot(globalSnapshot2, SnapshotKt.emptyLambda);
                    modified$runtime_release = globalSnapshot2.getModified$runtime_release();
                    setModified(null);
                    globalSnapshot2.setModified(null);
                    listM = AbstractC3240kc.F0(SnapshotKt.applyObservers);
                }
                FW fw = FW.a;
                this.applied = true;
                if (modified$runtime_release != null && !modified$runtime_release.isEmpty()) {
                    AbstractC4492zt.e(modified$runtime_release);
                    int size = listM.size();
                    for (int i = 0; i < size; i++) {
                        ((InterfaceC0526Fp) listM.get(i)).mo13invoke(modified$runtime_release, this);
                    }
                }
                if (modified$runtime_release2 != null && !modified$runtime_release2.isEmpty()) {
                    int size2 = listM.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((InterfaceC0526Fp) listM.get(i2)).mo13invoke(modified$runtime_release2, this);
                    }
                }
                synchronized (SnapshotKt.getLock()) {
                    try {
                        releasePinnedSnapshotsForCloseLocked$runtime_release();
                        SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
                        if (modified$runtime_release != null) {
                            Object[] values = modified$runtime_release.getValues();
                            int size3 = modified$runtime_release.size();
                            for (int i3 = 0; i3 < size3; i3++) {
                                Object obj2 = values[i3];
                                AbstractC4492zt.f(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                SnapshotKt.processForUnusedRecordsLocked((StateObject) obj2);
                            }
                        }
                        if (modified$runtime_release2 != null) {
                            Object[] values2 = modified$runtime_release2.getValues();
                            int size4 = modified$runtime_release2.size();
                            for (int i4 = 0; i4 < size4; i4++) {
                                Object obj3 = values2[i4];
                                AbstractC4492zt.f(obj3, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                SnapshotKt.processForUnusedRecordsLocked((StateObject) obj3);
                            }
                        }
                        List<? extends StateObject> list = this.merged;
                        if (list != null) {
                            int size5 = list.size();
                            for (int i5 = 0; i5 < size5; i5++) {
                                SnapshotKt.processForUnusedRecordsLocked(list.get(i5));
                            }
                        }
                        this.merged = null;
                        FW fw2 = FW.a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return SnapshotApplyResult.Success.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release()) {
            return;
        }
        super.dispose();
        mo2676nestedDeactivated$runtime_release(this);
    }

    public final boolean getApplied$runtime_release() {
        return this.applied;
    }

    public final List<StateObject> getMerged$runtime_release() {
        return this.merged;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public IdentityArraySet<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    public final SnapshotIdSet getPreviousIds$runtime_release() {
        return this.previousIds;
    }

    public final int[] getPreviousPinnedSnapshots$runtime_release() {
        return this.previousPinnedSnapshots;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public InterfaceC3750qp getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public int getWriteCount$runtime_release() {
        return this.writeCount;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public InterfaceC3750qp getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && modified$runtime_release.isNotEmpty();
    }

    public final SnapshotApplyResult innerApplyLocked$runtime_release(int i, Map<StateRecord, ? extends StateRecord> map, SnapshotIdSet snapshotIdSet) {
        StateRecord stateRecord;
        StateRecord stateRecordMergeRecords;
        SnapshotIdSet snapshotIdSet2 = snapshotIdSet;
        AbstractC4492zt.h(snapshotIdSet2, "invalidSnapshots");
        SnapshotIdSet snapshotIdSetOr = getInvalid$runtime_release().set(getId()).or(this.previousIds);
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        AbstractC4492zt.e(modified$runtime_release);
        Object[] values = modified$runtime_release.getValues();
        int size = modified$runtime_release.size();
        ArrayList arrayList = null;
        List<? extends StateObject> listP0 = null;
        int i2 = 0;
        while (i2 < size) {
            Object obj = values[i2];
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            StateObject stateObject = (StateObject) obj;
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            StateRecord stateRecord2 = SnapshotKt.readable(firstStateRecord, i, snapshotIdSet2);
            if (stateRecord2 != null && (stateRecord = SnapshotKt.readable(firstStateRecord, getId(), snapshotIdSetOr)) != null && !AbstractC4492zt.d(stateRecord2, stateRecord)) {
                StateRecord stateRecord3 = SnapshotKt.readable(firstStateRecord, getId(), getInvalid$runtime_release());
                if (stateRecord3 == null) {
                    SnapshotKt.readError();
                    throw new C1182Zu();
                }
                if (map == null || (stateRecordMergeRecords = map.get(stateRecord2)) == null) {
                    stateRecordMergeRecords = stateObject.mergeRecords(stateRecord, stateRecord2, stateRecord3);
                }
                if (stateRecordMergeRecords == null) {
                    return new SnapshotApplyResult.Failure(this);
                }
                if (!AbstractC4492zt.d(stateRecordMergeRecords, stateRecord3)) {
                    if (AbstractC4492zt.d(stateRecordMergeRecords, stateRecord2)) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(HV.a(stateObject, stateRecord2.create()));
                        if (listP0 == null) {
                            listP0 = new ArrayList<>();
                        }
                        listP0.add(stateObject);
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(!AbstractC4492zt.d(stateRecordMergeRecords, stateRecord) ? HV.a(stateObject, stateRecordMergeRecords) : HV.a(stateObject, stateRecord.create()));
                    }
                }
            }
            i2++;
            snapshotIdSet2 = snapshotIdSet;
        }
        if (arrayList != null) {
            advance$runtime_release();
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                C2020dG c2020dG = (C2020dG) arrayList.get(i3);
                StateObject stateObject2 = (StateObject) c2020dG.a();
                StateRecord stateRecord4 = (StateRecord) c2020dG.b();
                stateRecord4.setSnapshotId$runtime_release(getId());
                synchronized (SnapshotKt.getLock()) {
                    stateRecord4.setNext$runtime_release(stateObject2.getFirstStateRecord());
                    stateObject2.prependStateRecord(stateRecord4);
                    FW fw = FW.a;
                }
            }
        }
        if (listP0 != null) {
            int size3 = listP0.size();
            for (int i4 = 0; i4 < size3; i4++) {
                modified$runtime_release.remove(listP0.get(i4));
            }
            List<? extends StateObject> list = this.merged;
            if (list != null) {
                listP0 = AbstractC3240kc.p0(list, listP0);
            }
            this.merged = listP0;
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedActivated$runtime_release */
    public void mo2675nestedActivated$runtime_release(Snapshot snapshot) {
        AbstractC4492zt.h(snapshot, "snapshot");
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: nestedDeactivated$runtime_release */
    public void mo2676nestedDeactivated$runtime_release(Snapshot snapshot) {
        AbstractC4492zt.h(snapshot, "snapshot");
        int i = this.snapshots;
        if (i <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i2 = i - 1;
        this.snapshots = i2;
        if (i2 != 0 || this.applied) {
            return;
        }
        abandon();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied || getDisposed$runtime_release()) {
            return;
        }
        advance$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: recordModified$runtime_release */
    public void mo2678recordModified$runtime_release(StateObject stateObject) {
        AbstractC4492zt.h(stateObject, "state");
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = new IdentityArraySet<>();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(stateObject);
    }

    public final void recordPrevious$runtime_release(int i) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(i);
            FW fw = FW.a;
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshotIdSet) {
        AbstractC4492zt.h(snapshotIdSet, "snapshots");
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.or(snapshotIdSet);
            FW fw = FW.a;
        }
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int i) {
        if (i >= 0) {
            this.previousPinnedSnapshots = Q5.v(this.previousPinnedSnapshots, i);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        AbstractC4492zt.h(iArr, "handles");
        if (iArr.length == 0) {
            return;
        }
        int[] iArr2 = this.previousPinnedSnapshots;
        if (iArr2.length != 0) {
            iArr = Q5.w(iArr2, iArr);
        }
        this.previousPinnedSnapshots = iArr;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }

    public final void setMerged$runtime_release(List<? extends StateObject> list) {
        this.merged = list;
    }

    public void setModified(IdentityArraySet<StateObject> identityArraySet) {
        this.modified = identityArraySet;
    }

    public final void setPreviousIds$runtime_release(SnapshotIdSet snapshotIdSet) {
        AbstractC4492zt.h(snapshotIdSet, "<set-?>");
        this.previousIds = snapshotIdSet;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        AbstractC4492zt.h(iArr, "<set-?>");
        this.previousPinnedSnapshots = iArr;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime_release(int i) {
        this.writeCount = i;
    }

    public MutableSnapshot takeNestedMutableSnapshot(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        NestedMutableSnapshot nestedMutableSnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            int i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(i);
            SnapshotIdSet invalid$runtime_release = getInvalid$runtime_release();
            setInvalid$runtime_release(invalid$runtime_release.set(i));
            nestedMutableSnapshot = new NestedMutableSnapshot(i, SnapshotKt.addRange(invalid$runtime_release, getId() + 1, i), SnapshotKt.mergedReadObserver$default(interfaceC3750qp, getReadObserver$runtime_release(), false, 4, null), SnapshotKt.mergedWriteObserver(interfaceC3750qp2, getWriteObserver$runtime_release()), this);
        }
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id = getId();
            synchronized (SnapshotKt.getLock()) {
                int i2 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i2 + 1;
                setId$runtime_release(i2);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                FW fw = FW.a;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
        }
        return nestedMutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(InterfaceC3750qp interfaceC3750qp) {
        NestedReadonlySnapshot nestedReadonlySnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        int id = getId();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            int i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(i);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(i, SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, i), interfaceC3750qp, this);
        }
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id2 = getId();
            synchronized (SnapshotKt.getLock()) {
                int i2 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i2 + 1;
                setId$runtime_release(i2);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                FW fw = FW.a;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id2 + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }

    public final void advance$runtime_release() {
        recordPrevious$runtime_release(getId());
        FW fw = FW.a;
        if (getApplied$runtime_release() || getDisposed$runtime_release()) {
            return;
        }
        int id = getId();
        synchronized (SnapshotKt.getLock()) {
            int i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            setId$runtime_release(i);
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
    }
}
