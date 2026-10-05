package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.WeakReference;
import androidx.compose.runtime.collection.IdentityArraySet;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C1182Zu;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotKt {
    private static final int INVALID_SNAPSHOT = 0;
    private static final List<InterfaceC0526Fp> applyObservers;
    private static final AtomicReference<GlobalSnapshot> currentGlobalSnapshot;
    private static final SnapshotWeakSet<StateObject> extraStateObjects;
    private static final List<InterfaceC3750qp> globalWriteObservers;
    private static int nextSnapshotId;
    private static SnapshotIdSet openSnapshots;
    private static AtomicInt pendingApplyObserverCount;
    private static final SnapshotDoubleIndexHeap pinningTable;
    private static final Snapshot snapshotInitializer;
    private static final InterfaceC3750qp emptyLambda = SnapshotKt$emptyLambda$1.INSTANCE;
    private static final SnapshotThreadLocal<Snapshot> threadSnapshot = new SnapshotThreadLocal<>();
    private static final Object lock = new Object();

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotKt$advanceGlobalSnapshot$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        public final void invoke(SnapshotIdSet snapshotIdSet) {
            AbstractC4492zt.h(snapshotIdSet, "it");
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SnapshotIdSet) obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotKt$mergedReadObserver$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $parentObserver;
        final /* synthetic */ InterfaceC3750qp $readObserver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
            super(1);
            this.$readObserver = interfaceC3750qp;
            this.$parentObserver = interfaceC3750qp2;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m2680invoke(obj);
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2680invoke(Object obj) {
            AbstractC4492zt.h(obj, "state");
            this.$readObserver.invoke(obj);
            this.$parentObserver.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotKt$mergedWriteObserver$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16441 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $parentObserver;
        final /* synthetic */ InterfaceC3750qp $writeObserver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16441(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
            super(1);
            this.$writeObserver = interfaceC3750qp;
            this.$parentObserver = interfaceC3750qp2;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m2681invoke(obj);
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2681invoke(Object obj) {
            AbstractC4492zt.h(obj, "state");
            this.$writeObserver.invoke(obj);
            this.$parentObserver.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotKt$takeNewSnapshot$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16451 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16451(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$block = interfaceC3750qp;
        }

        /* JADX WARN: Incorrect return type in method signature: (Landroidx/compose/runtime/snapshots/SnapshotIdSet;)TT; */
        @Override // defpackage.InterfaceC3750qp
        public final Snapshot invoke(SnapshotIdSet snapshotIdSet) {
            AbstractC4492zt.h(snapshotIdSet, "invalid");
            Snapshot snapshot = (Snapshot) this.$block.invoke(snapshotIdSet);
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(snapshot.getId());
                FW fw = FW.a;
            }
            return snapshot;
        }
    }

    static {
        SnapshotIdSet.Companion companion = SnapshotIdSet.Companion;
        openSnapshots = companion.getEMPTY();
        nextSnapshotId = 1;
        pinningTable = new SnapshotDoubleIndexHeap();
        extraStateObjects = new SnapshotWeakSet<>();
        applyObservers = new ArrayList();
        globalWriteObservers = new ArrayList();
        int i = nextSnapshotId;
        nextSnapshotId = i + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(i, companion.getEMPTY());
        openSnapshots = openSnapshots.set(globalSnapshot.getId());
        AtomicReference<GlobalSnapshot> atomicReference = new AtomicReference<>(globalSnapshot);
        currentGlobalSnapshot = atomicReference;
        GlobalSnapshot globalSnapshot2 = atomicReference.get();
        AbstractC4492zt.g(globalSnapshot2, "currentGlobalSnapshot.get()");
        snapshotInitializer = globalSnapshot2;
        pendingApplyObserverCount = new AtomicInt(0);
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet snapshotIdSet, int i, int i2) {
        AbstractC4492zt.h(snapshotIdSet, "<this>");
        while (i < i2) {
            snapshotIdSet = snapshotIdSet.set(i);
            i++;
        }
        return snapshotIdSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T advanceGlobalSnapshot(InterfaceC3750qp interfaceC3750qp) {
        GlobalSnapshot globalSnapshot;
        IdentityArraySet<StateObject> modified$runtime_release;
        T t;
        List listF0;
        Snapshot snapshot = snapshotInitializer;
        AbstractC4492zt.f(snapshot, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        synchronized (getLock()) {
            try {
                globalSnapshot = currentGlobalSnapshot.get();
                AbstractC4492zt.g(globalSnapshot, "currentGlobalSnapshot.get()");
                modified$runtime_release = globalSnapshot.getModified$runtime_release();
                if (modified$runtime_release != null) {
                    pendingApplyObserverCount.add(1);
                }
                t = (T) takeNewGlobalSnapshot(globalSnapshot, interfaceC3750qp);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (modified$runtime_release != null) {
            try {
                synchronized (getLock()) {
                    listF0 = AbstractC3240kc.F0(applyObservers);
                }
                int size = listF0.size();
                for (int i = 0; i < size; i++) {
                    ((InterfaceC0526Fp) listF0.get(i)).mo13invoke(modified$runtime_release, globalSnapshot);
                }
                pendingApplyObserverCount.add(-1);
            } catch (Throwable th2) {
                pendingApplyObserverCount.add(-1);
                throw th2;
            }
        }
        synchronized (getLock()) {
            try {
                checkAndOverwriteUnusedRecordsLocked();
                if (modified$runtime_release != null) {
                    Object[] values = modified$runtime_release.getValues();
                    int size2 = modified$runtime_release.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        Object obj = values[i2];
                        AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                        processForUnusedRecordsLocked((StateObject) obj);
                    }
                    FW fw = FW.a;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAndOverwriteUnusedRecordsLocked() {
        SnapshotWeakSet<StateObject> snapshotWeakSet = extraStateObjects;
        int size$runtime_release = snapshotWeakSet.getSize$runtime_release();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size$runtime_release) {
                break;
            }
            WeakReference<StateObject> weakReference = snapshotWeakSet.getValues$runtime_release()[i];
            StateObject stateObject = weakReference != null ? weakReference.get() : null;
            if (stateObject != null && overwriteUnusedRecordsLocked(stateObject)) {
                if (i2 != i) {
                    snapshotWeakSet.getValues$runtime_release()[i2] = weakReference;
                    snapshotWeakSet.getHashes$runtime_release()[i2] = snapshotWeakSet.getHashes$runtime_release()[i];
                }
                i2++;
            }
            i++;
        }
        for (int i3 = i2; i3 < size$runtime_release; i3++) {
            snapshotWeakSet.getValues$runtime_release()[i3] = null;
            snapshotWeakSet.getHashes$runtime_release()[i3] = 0;
        }
        if (i2 != size$runtime_release) {
            snapshotWeakSet.setSize$runtime_release(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot snapshot, InterfaceC3750qp interfaceC3750qp, boolean z) {
        boolean z2 = snapshot instanceof MutableSnapshot;
        if (z2 || snapshot == null) {
            return new TransparentObserverMutableSnapshot(z2 ? (MutableSnapshot) snapshot : null, interfaceC3750qp, null, false, z);
        }
        return new TransparentObserverSnapshot(snapshot, interfaceC3750qp, false, z);
    }

    public static /* synthetic */ Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot snapshot, InterfaceC3750qp interfaceC3750qp, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC3750qp = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return createTransparentSnapshotWithNoParentReadObserver(snapshot, interfaceC3750qp, z);
    }

    public static final <T extends StateRecord> T current(T t, Snapshot snapshot) {
        AbstractC4492zt.h(t, "r");
        AbstractC4492zt.h(snapshot, "snapshot");
        T t2 = (T) readable(t, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (t2 != null) {
            return t2;
        }
        readError();
        throw new C1182Zu();
    }

    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = threadSnapshot.get();
        if (snapshot != null) {
            return snapshot;
        }
        GlobalSnapshot globalSnapshot = currentGlobalSnapshot.get();
        AbstractC4492zt.g(globalSnapshot, "currentGlobalSnapshot.get()");
        return globalSnapshot;
    }

    private static final StateRecord findYoungestOr(StateRecord stateRecord, InterfaceC3750qp interfaceC3750qp) {
        StateRecord stateRecord2 = stateRecord;
        while (stateRecord != null) {
            if (((Boolean) interfaceC3750qp.invoke(stateRecord)).booleanValue()) {
                return stateRecord;
            }
            if (stateRecord2.getSnapshotId$runtime_release() < stateRecord.getSnapshotId$runtime_release()) {
                stateRecord2 = stateRecord;
            }
            stateRecord = stateRecord.getNext$runtime_release();
        }
        return stateRecord2;
    }

    public static final Object getLock() {
        return lock;
    }

    public static /* synthetic */ void getLock$annotations() {
    }

    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    public static /* synthetic */ void getSnapshotInitializer$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC3750qp mergedReadObserver(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, boolean z) {
        if (!z) {
            interfaceC3750qp2 = null;
        }
        if (interfaceC3750qp == null || interfaceC3750qp2 == null || AbstractC4492zt.d(interfaceC3750qp, interfaceC3750qp2)) {
            return interfaceC3750qp == null ? interfaceC3750qp2 : interfaceC3750qp;
        }
        return new AnonymousClass1(interfaceC3750qp, interfaceC3750qp2);
    }

    public static /* synthetic */ InterfaceC3750qp mergedReadObserver$default(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return mergedReadObserver(interfaceC3750qp, interfaceC3750qp2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC3750qp mergedWriteObserver(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        if (interfaceC3750qp == null || interfaceC3750qp2 == null || AbstractC4492zt.d(interfaceC3750qp, interfaceC3750qp2)) {
            return interfaceC3750qp == null ? interfaceC3750qp2 : interfaceC3750qp;
        }
        return new C16441(interfaceC3750qp, interfaceC3750qp2);
    }

    public static final <T extends StateRecord> T newOverwritableRecordLocked(T t, StateObject stateObject) {
        AbstractC4492zt.h(t, "<this>");
        AbstractC4492zt.h(stateObject, "state");
        T t2 = (T) usedLocked(stateObject);
        if (t2 != null) {
            t2.setSnapshotId$runtime_release(Integer.MAX_VALUE);
            return t2;
        }
        T t3 = (T) t.create();
        t3.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        t3.setNext$runtime_release(stateObject.getFirstStateRecord());
        AbstractC4492zt.f(t3, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked$lambda$15");
        stateObject.prependStateRecord(t3);
        AbstractC4492zt.f(t3, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return t3;
    }

    public static final <T extends StateRecord> T newWritableRecord(T t, StateObject stateObject, Snapshot snapshot) {
        T t2;
        AbstractC4492zt.h(t, "<this>");
        AbstractC4492zt.h(stateObject, "state");
        AbstractC4492zt.h(snapshot, "snapshot");
        synchronized (getLock()) {
            t2 = (T) newWritableRecordLocked(t, stateObject, snapshot);
        }
        return t2;
    }

    private static final <T extends StateRecord> T newWritableRecordLocked(T t, StateObject stateObject, Snapshot snapshot) {
        T t2 = (T) newOverwritableRecordLocked(t, stateObject);
        t2.assign(t);
        t2.setSnapshotId$runtime_release(snapshot.getId());
        return t2;
    }

    public static final void notifyWrite(Snapshot snapshot, StateObject stateObject) {
        AbstractC4492zt.h(snapshot, "snapshot");
        AbstractC4492zt.h(stateObject, "state");
        snapshot.setWriteCount$runtime_release(snapshot.getWriteCount$runtime_release() + 1);
        InterfaceC3750qp writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(stateObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<StateRecord, StateRecord> optimisticMerges(MutableSnapshot mutableSnapshot, MutableSnapshot mutableSnapshot2, SnapshotIdSet snapshotIdSet) {
        StateRecord stateRecord;
        IdentityArraySet<StateObject> modified$runtime_release = mutableSnapshot2.getModified$runtime_release();
        int id = mutableSnapshot.getId();
        if (modified$runtime_release == null) {
            return null;
        }
        SnapshotIdSet snapshotIdSetOr = mutableSnapshot2.getInvalid$runtime_release().set(mutableSnapshot2.getId()).or(mutableSnapshot2.getPreviousIds$runtime_release());
        Object[] values = modified$runtime_release.getValues();
        int size = modified$runtime_release.size();
        HashMap map = null;
        for (int i = 0; i < size; i++) {
            Object obj = values[i];
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            StateObject stateObject = (StateObject) obj;
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            StateRecord stateRecord2 = readable(firstStateRecord, id, snapshotIdSet);
            if (stateRecord2 != null && (stateRecord = readable(firstStateRecord, id, snapshotIdSetOr)) != null && !AbstractC4492zt.d(stateRecord2, stateRecord)) {
                StateRecord stateRecord3 = readable(firstStateRecord, mutableSnapshot2.getId(), mutableSnapshot2.getInvalid$runtime_release());
                if (stateRecord3 == null) {
                    readError();
                    throw new C1182Zu();
                }
                StateRecord stateRecordMergeRecords = stateObject.mergeRecords(stateRecord, stateRecord2, stateRecord3);
                if (stateRecordMergeRecords == null) {
                    return null;
                }
                if (map == null) {
                    map = new HashMap();
                }
                map.put(stateRecord2, stateRecordMergeRecords);
                map = map;
            }
        }
        return map;
    }

    public static final <T extends StateRecord, R> R overwritable(T t, StateObject stateObject, T t2, InterfaceC3750qp interfaceC3750qp) {
        Snapshot current;
        R r;
        AbstractC4492zt.h(t, "<this>");
        AbstractC4492zt.h(stateObject, "state");
        AbstractC4492zt.h(t2, "candidate");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                r = (R) interfaceC3750qp.invoke(overwritableRecord(t, stateObject, current, t2));
                AbstractC0703Ks.b(1);
            } catch (Throwable th) {
                AbstractC0703Ks.b(1);
                AbstractC0703Ks.a(1);
                throw th;
            }
        }
        AbstractC0703Ks.a(1);
        notifyWrite(current, stateObject);
        return r;
    }

    public static final <T extends StateRecord> T overwritableRecord(T t, StateObject stateObject, Snapshot snapshot, T t2) {
        T t3;
        AbstractC4492zt.h(t, "<this>");
        AbstractC4492zt.h(stateObject, "state");
        AbstractC4492zt.h(snapshot, "snapshot");
        AbstractC4492zt.h(t2, "candidate");
        if (snapshot.getReadOnly()) {
            snapshot.mo2678recordModified$runtime_release(stateObject);
        }
        int id = snapshot.getId();
        if (t2.getSnapshotId$runtime_release() == id) {
            return t2;
        }
        synchronized (getLock()) {
            t3 = (T) newOverwritableRecordLocked(t, stateObject);
        }
        t3.setSnapshotId$runtime_release(id);
        snapshot.mo2678recordModified$runtime_release(stateObject);
        return t3;
    }

    private static final boolean overwriteUnusedRecordsLocked(StateObject stateObject) {
        StateRecord stateRecord;
        int iLowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId);
        StateRecord stateRecord2 = null;
        StateRecord firstStateRecord = null;
        int i = 0;
        for (StateRecord firstStateRecord2 = stateObject.getFirstStateRecord(); firstStateRecord2 != null; firstStateRecord2 = firstStateRecord2.getNext$runtime_release()) {
            int snapshotId$runtime_release = firstStateRecord2.getSnapshotId$runtime_release();
            if (snapshotId$runtime_release != 0) {
                if (snapshotId$runtime_release >= iLowestOrDefault) {
                    i++;
                } else if (stateRecord2 == null) {
                    i++;
                    stateRecord2 = firstStateRecord2;
                } else {
                    if (firstStateRecord2.getSnapshotId$runtime_release() < stateRecord2.getSnapshotId$runtime_release()) {
                        stateRecord = stateRecord2;
                        stateRecord2 = firstStateRecord2;
                    } else {
                        stateRecord = firstStateRecord2;
                    }
                    if (firstStateRecord == null) {
                        firstStateRecord = stateObject.getFirstStateRecord();
                        StateRecord stateRecord3 = firstStateRecord;
                        while (true) {
                            if (firstStateRecord == null) {
                                firstStateRecord = stateRecord3;
                                break;
                            }
                            if (firstStateRecord.getSnapshotId$runtime_release() >= iLowestOrDefault) {
                                break;
                            }
                            if (stateRecord3.getSnapshotId$runtime_release() < firstStateRecord.getSnapshotId$runtime_release()) {
                                stateRecord3 = firstStateRecord;
                            }
                            firstStateRecord = firstStateRecord.getNext$runtime_release();
                        }
                    }
                    stateRecord2.setSnapshotId$runtime_release(0);
                    stateRecord2.assign(firstStateRecord);
                    stateRecord2 = stateRecord;
                }
            }
        }
        return i > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processForUnusedRecordsLocked(StateObject stateObject) {
        if (overwriteUnusedRecordsLocked(stateObject)) {
            extraStateObjects.add(stateObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends StateRecord> T readable(T t, int i, SnapshotIdSet snapshotIdSet) {
        T t2 = null;
        while (t != null) {
            if (valid(t, i, snapshotIdSet) && (t2 == null || t2.getSnapshotId$runtime_release() < t.getSnapshotId$runtime_release())) {
                t2 = t;
            }
            t = (T) t.getNext$runtime_release();
        }
        if (t2 != null) {
            return t2;
        }
        return null;
    }

    public static final void releasePinningLocked(int i) {
        pinningTable.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    public static final <T> T sync(InterfaceC3588op interfaceC3588op) {
        T t;
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        synchronized (getLock()) {
            try {
                t = (T) interfaceC3588op.invoke();
                AbstractC0703Ks.b(1);
            } finally {
                AbstractC0703Ks.b(1);
                AbstractC0703Ks.a(1);
            }
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T takeNewGlobalSnapshot(Snapshot snapshot, InterfaceC3750qp interfaceC3750qp) {
        T t = (T) interfaceC3750qp.invoke(openSnapshots.clear(snapshot.getId()));
        synchronized (getLock()) {
            int i = nextSnapshotId;
            nextSnapshotId = i + 1;
            openSnapshots = openSnapshots.clear(snapshot.getId());
            currentGlobalSnapshot.set(new GlobalSnapshot(i, openSnapshots));
            snapshot.dispose();
            openSnapshots = openSnapshots.set(i);
            FW fw = FW.a;
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends Snapshot> T takeNewSnapshot(InterfaceC3750qp interfaceC3750qp) {
        return (T) advanceGlobalSnapshot(new C16451(interfaceC3750qp));
    }

    public static final int trackPinning(int i, SnapshotIdSet snapshotIdSet) {
        int iAdd;
        AbstractC4492zt.h(snapshotIdSet, "invalid");
        int iLowest = snapshotIdSet.lowest(i);
        synchronized (getLock()) {
            iAdd = pinningTable.add(iLowest);
        }
        return iAdd;
    }

    private static final StateRecord usedLocked(StateObject stateObject) {
        int iLowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId) - 1;
        SnapshotIdSet empty = SnapshotIdSet.Companion.getEMPTY();
        StateRecord stateRecord = null;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
            if (firstStateRecord.getSnapshotId$runtime_release() == 0) {
                return firstStateRecord;
            }
            if (valid(firstStateRecord, iLowestOrDefault, empty)) {
                if (stateRecord != null) {
                    return firstStateRecord.getSnapshotId$runtime_release() < stateRecord.getSnapshotId$runtime_release() ? firstStateRecord : stateRecord;
                }
                stateRecord = firstStateRecord;
            }
        }
        return null;
    }

    private static final boolean valid(int i, int i2, SnapshotIdSet snapshotIdSet) {
        return (i2 == 0 || i2 > i || snapshotIdSet.get(i2)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateOpen(Snapshot snapshot) {
        if (!openSnapshots.get(snapshot.getId())) {
            throw new IllegalStateException("Snapshot is not open");
        }
    }

    public static final <T extends StateRecord, R> R withCurrent(T t, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(t, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        return (R) interfaceC3750qp.invoke(current(t));
    }

    public static final <T extends StateRecord, R> R writable(T t, StateObject stateObject, InterfaceC3750qp interfaceC3750qp) {
        Snapshot current;
        R r;
        AbstractC4492zt.h(t, "<this>");
        AbstractC4492zt.h(stateObject, "state");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                r = (R) interfaceC3750qp.invoke(writableRecord(t, stateObject, current));
                AbstractC0703Ks.b(1);
            } catch (Throwable th) {
                AbstractC0703Ks.b(1);
                AbstractC0703Ks.a(1);
                throw th;
            }
        }
        AbstractC0703Ks.a(1);
        notifyWrite(current, stateObject);
        return r;
    }

    public static final <T extends StateRecord> T writableRecord(T t, StateObject stateObject, Snapshot snapshot) {
        AbstractC4492zt.h(t, "<this>");
        AbstractC4492zt.h(stateObject, "state");
        AbstractC4492zt.h(snapshot, "snapshot");
        if (snapshot.getReadOnly()) {
            snapshot.mo2678recordModified$runtime_release(stateObject);
        }
        T t2 = (T) readable(t, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (t2 == null) {
            readError();
            throw new C1182Zu();
        }
        if (t2.getSnapshotId$runtime_release() == snapshot.getId()) {
            return t2;
        }
        T t3 = (T) newWritableRecord(t2, stateObject, snapshot);
        snapshot.mo2678recordModified$runtime_release(stateObject);
        return t3;
    }

    public static final <T extends StateRecord> T current(T t) {
        T t2;
        AbstractC4492zt.h(t, "r");
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot current = companion.getCurrent();
        T t3 = (T) readable(t, current.getId(), current.getInvalid$runtime_release());
        if (t3 != null) {
            return t3;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            t2 = (T) readable(t, current2.getId(), current2.getInvalid$runtime_release());
        }
        if (t2 != null) {
            return t2;
        }
        readError();
        throw new C1182Zu();
    }

    private static final boolean valid(StateRecord stateRecord, int i, SnapshotIdSet snapshotIdSet) {
        return valid(i, stateRecord.getSnapshotId$runtime_release(), snapshotIdSet);
    }

    public static final <T extends StateRecord> T readable(T t, StateObject stateObject) {
        T t2;
        AbstractC4492zt.h(t, "<this>");
        AbstractC4492zt.h(stateObject, "state");
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot current = companion.getCurrent();
        InterfaceC3750qp readObserver$runtime_release = current.getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(stateObject);
        }
        T t3 = (T) readable(t, current.getId(), current.getInvalid$runtime_release());
        if (t3 != null) {
            return t3;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            AbstractC4492zt.f(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");
            t2 = (T) readable(firstStateRecord, current2.getId(), current2.getInvalid$runtime_release());
            if (t2 == null) {
                readError();
                throw new C1182Zu();
            }
        }
        return t2;
    }

    public static final <T extends StateRecord, R> R writable(T t, StateObject stateObject, Snapshot snapshot, InterfaceC3750qp interfaceC3750qp) {
        R r;
        AbstractC4492zt.h(t, "<this>");
        AbstractC4492zt.h(stateObject, "state");
        AbstractC4492zt.h(snapshot, "snapshot");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        synchronized (getLock()) {
            try {
                r = (R) interfaceC3750qp.invoke(writableRecord(t, stateObject, snapshot));
                AbstractC0703Ks.b(1);
            } catch (Throwable th) {
                AbstractC0703Ks.b(1);
                AbstractC0703Ks.a(1);
                throw th;
            }
        }
        AbstractC0703Ks.a(1);
        notifyWrite(snapshot, stateObject);
        return r;
    }

    public static final <T extends StateRecord> T readable(T t, StateObject stateObject, Snapshot snapshot) {
        AbstractC4492zt.h(t, "<this>");
        AbstractC4492zt.h(stateObject, "state");
        AbstractC4492zt.h(snapshot, "snapshot");
        InterfaceC3750qp readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(stateObject);
        }
        T t2 = (T) readable(t, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (t2 != null) {
            return t2;
        }
        readError();
        throw new C1182Zu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(AnonymousClass3.INSTANCE);
    }
}
