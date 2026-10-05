package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.HR;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class DerivedSnapshotState<T> implements StateObject, DerivedState<T> {
    private final InterfaceC3588op calculation;
    private ResultRecord<T> first;
    private final SnapshotMutationPolicy<T> policy;

    @StabilityInferred(parameters = 0)
    public static final class ResultRecord<T> extends StateRecord implements DerivedState.Record<T> {
        private IdentityArrayMap<StateObject, Integer> _dependencies;
        private Object result = Unset;
        private int resultHash;
        private int validSnapshotId;
        private int validSnapshotWriteCount;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Object Unset = new Object();

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                this();
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }

            private Companion() {
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord stateRecord) {
            AbstractC4492zt.h(stateRecord, "value");
            ResultRecord resultRecord = (ResultRecord) stateRecord;
            this._dependencies = resultRecord._dependencies;
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new ResultRecord();
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public T getCurrentValue() {
            return (T) this.result;
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public Object[] getDependencies() {
            Object[] keys;
            IdentityArrayMap<StateObject, Integer> identityArrayMap = this._dependencies;
            return (identityArrayMap == null || (keys = identityArrayMap.getKeys()) == null) ? new Object[0] : keys;
        }

        public final Object getResult() {
            return this.result;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final int getValidSnapshotId() {
            return this.validSnapshotId;
        }

        public final int getValidSnapshotWriteCount() {
            return this.validSnapshotWriteCount;
        }

        public final IdentityArrayMap<StateObject, Integer> get_dependencies() {
            return this._dependencies;
        }

        public final boolean isValid(DerivedState<?> derivedState, Snapshot snapshot) {
            boolean z;
            boolean z2;
            AbstractC4492zt.h(derivedState, "derivedState");
            AbstractC4492zt.h(snapshot, "snapshot");
            synchronized (SnapshotKt.getLock()) {
                z = true;
                z2 = (this.validSnapshotId == snapshot.getId() && this.validSnapshotWriteCount == snapshot.getWriteCount$runtime_release()) ? false : true;
            }
            if (this.result == Unset || (z2 && this.resultHash != readableHash(derivedState, snapshot))) {
                z = false;
            }
            if (z && z2) {
                synchronized (SnapshotKt.getLock()) {
                    this.validSnapshotId = snapshot.getId();
                    this.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                    FW fw = FW.a;
                }
            }
            return z;
        }

        public final int readableHash(DerivedState<?> derivedState, Snapshot snapshot) {
            IdentityArrayMap<StateObject, Integer> identityArrayMap;
            AbstractC4492zt.h(derivedState, "derivedState");
            AbstractC4492zt.h(snapshot, "snapshot");
            synchronized (SnapshotKt.getLock()) {
                identityArrayMap = this._dependencies;
            }
            int iIdentityHashCode = 7;
            if (identityArrayMap != null) {
                MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
                int size = mutableVectorDerivedStateObservers.getSize();
                int i = 0;
                if (size > 0) {
                    DerivedStateObserver[] content = mutableVectorDerivedStateObservers.getContent();
                    int i2 = 0;
                    do {
                        content[i2].start(derivedState);
                        i2++;
                    } while (i2 < size);
                }
                try {
                    int size2 = identityArrayMap.getSize();
                    for (int i3 = 0; i3 < size2; i3++) {
                        Object obj = identityArrayMap.getKeys()[i3];
                        AbstractC4492zt.f(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                        StateObject stateObject = (StateObject) obj;
                        if (((Number) identityArrayMap.getValues()[i3]).intValue() == 1) {
                            StateRecord stateRecordCurrent = stateObject instanceof DerivedSnapshotState ? ((DerivedSnapshotState) stateObject).current(snapshot) : SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot);
                            iIdentityHashCode = (((iIdentityHashCode * 31) + ActualJvm_jvmKt.identityHashCode(stateRecordCurrent)) * 31) + stateRecordCurrent.getSnapshotId$runtime_release();
                        }
                    }
                    FW fw = FW.a;
                    int size3 = mutableVectorDerivedStateObservers.getSize();
                    if (size3 > 0) {
                        DerivedStateObserver[] content2 = mutableVectorDerivedStateObservers.getContent();
                        do {
                            content2[i].done(derivedState);
                            i++;
                        } while (i < size3);
                    }
                } catch (Throwable th) {
                    int size4 = mutableVectorDerivedStateObservers.getSize();
                    if (size4 > 0) {
                        DerivedStateObserver[] content3 = mutableVectorDerivedStateObservers.getContent();
                        do {
                            content3[i].done(derivedState);
                            i++;
                        } while (i < size4);
                    }
                    throw th;
                }
            }
            return iIdentityHashCode;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        public final void setValidSnapshotId(int i) {
            this.validSnapshotId = i;
        }

        public final void setValidSnapshotWriteCount(int i) {
            this.validSnapshotWriteCount = i;
        }

        public final void set_dependencies(IdentityArrayMap<StateObject, Integer> identityArrayMap) {
            this._dependencies = identityArrayMap;
        }
    }

    public DerivedSnapshotState(InterfaceC3588op interfaceC3588op, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        AbstractC4492zt.h(interfaceC3588op, "calculation");
        this.calculation = interfaceC3588op;
        this.policy = snapshotMutationPolicy;
        this.first = new ResultRecord<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ResultRecord<T> currentRecord(ResultRecord<T> resultRecord, Snapshot snapshot, boolean z, InterfaceC3588op interfaceC3588op) {
        Snapshot.Companion companion;
        SnapshotMutationPolicy<T> policy;
        int i = 0;
        if (resultRecord.isValid(this, snapshot)) {
            if (z) {
                MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
                int size = mutableVectorDerivedStateObservers.getSize();
                if (size > 0) {
                    DerivedStateObserver[] content = mutableVectorDerivedStateObservers.getContent();
                    int i2 = 0;
                    do {
                        content[i2].start(this);
                        i2++;
                    } while (i2 < size);
                }
                try {
                    IdentityArrayMap<StateObject, Integer> identityArrayMap = resultRecord.get_dependencies();
                    Integer num = (Integer) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
                    int iIntValue = num != null ? num.intValue() : 0;
                    if (identityArrayMap != null) {
                        int size2 = identityArrayMap.getSize();
                        for (int i3 = 0; i3 < size2; i3++) {
                            Object obj = identityArrayMap.getKeys()[i3];
                            AbstractC4492zt.f(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                            StateObject stateObject = (StateObject) obj;
                            SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(((Number) identityArrayMap.getValues()[i3]).intValue() + iIntValue));
                            InterfaceC3750qp readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
                            if (readObserver$runtime_release != null) {
                                readObserver$runtime_release.invoke(stateObject);
                            }
                        }
                    }
                    SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(iIntValue));
                    FW fw = FW.a;
                    int size3 = mutableVectorDerivedStateObservers.getSize();
                    if (size3 > 0) {
                        DerivedStateObserver[] content2 = mutableVectorDerivedStateObservers.getContent();
                        do {
                            content2[i].done(this);
                            i++;
                        } while (i < size3);
                    }
                } catch (Throwable th) {
                    int size4 = mutableVectorDerivedStateObservers.getSize();
                    if (size4 > 0) {
                        DerivedStateObserver[] content3 = mutableVectorDerivedStateObservers.getContent();
                        do {
                            content3[i].done(this);
                            i++;
                        } while (i < size4);
                    }
                    throw th;
                }
            }
            return resultRecord;
        }
        Integer num2 = (Integer) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
        int iIntValue2 = num2 != null ? num2.intValue() : 0;
        IdentityArrayMap<StateObject, Integer> identityArrayMap2 = new IdentityArrayMap<>(0, 1, null);
        MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers2 = SnapshotStateKt.derivedStateObservers();
        int size5 = mutableVectorDerivedStateObservers2.getSize();
        if (size5 > 0) {
            DerivedStateObserver[] content4 = mutableVectorDerivedStateObservers2.getContent();
            int i4 = 0;
            do {
                content4[i4].start(this);
                i4++;
            } while (i4 < size5);
        }
        try {
            SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(iIntValue2 + 1));
            Object objObserve = Snapshot.Companion.observe(new DerivedSnapshotState$currentRecord$result$1$result$1(this, identityArrayMap2, iIntValue2), null, interfaceC3588op);
            SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(iIntValue2));
            int size6 = mutableVectorDerivedStateObservers2.getSize();
            if (size6 > 0) {
                DerivedStateObserver[] content5 = mutableVectorDerivedStateObservers2.getContent();
                do {
                    content5[i].done(this);
                    i++;
                } while (i < size6);
            }
            synchronized (SnapshotKt.getLock()) {
                try {
                    companion = Snapshot.Companion;
                    Snapshot current = companion.getCurrent();
                    if (resultRecord.getResult() == ResultRecord.Companion.getUnset() || (policy = getPolicy()) == 0 || !policy.equivalent(objObserve, resultRecord.getResult())) {
                        resultRecord = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
                        resultRecord.set_dependencies(identityArrayMap2);
                        resultRecord.setResultHash(resultRecord.readableHash(this, current));
                        resultRecord.setValidSnapshotId(snapshot.getId());
                        resultRecord.setValidSnapshotWriteCount(snapshot.getWriteCount$runtime_release());
                        resultRecord.setResult(objObserve);
                    } else {
                        resultRecord.set_dependencies(identityArrayMap2);
                        resultRecord.setResultHash(resultRecord.readableHash(this, current));
                        resultRecord.setValidSnapshotId(snapshot.getId());
                        resultRecord.setValidSnapshotWriteCount(snapshot.getWriteCount$runtime_release());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (iIntValue2 == 0) {
                companion.notifyObjectsInitialized();
            }
            return resultRecord;
        } catch (Throwable th3) {
            int size7 = mutableVectorDerivedStateObservers2.getSize();
            if (size7 > 0) {
                DerivedStateObserver[] content6 = mutableVectorDerivedStateObservers2.getContent();
                do {
                    content6[i].done(this);
                    i++;
                } while (i < size7);
            }
            throw th3;
        }
    }

    private final String displayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        return resultRecord.isValid(this, Snapshot.Companion.getCurrent()) ? String.valueOf(resultRecord.getResult()) : "<Not calculated>";
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public final StateRecord current(Snapshot snapshot) {
        AbstractC4492zt.h(snapshot, "snapshot");
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    @Override // androidx.compose.runtime.DerivedState
    public DerivedState.Record<T> getCurrentRecord() {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), false, this.calculation);
    }

    public final T getDebuggerDisplayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.Companion.getCurrent())) {
            return (T) resultRecord.getResult();
        }
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.DerivedState
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        Snapshot.Companion companion = Snapshot.Companion;
        InterfaceC3750qp readObserver$runtime_release = companion.getCurrent().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return (T) currentRecord((ResultRecord) SnapshotKt.current(this.first), companion.getCurrent(), true, this.calculation).getResult();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return HR.a(this, stateRecord, stateRecord2, stateRecord3);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord stateRecord) {
        AbstractC4492zt.h(stateRecord, "value");
        this.first = (ResultRecord) stateRecord;
    }

    public String toString() {
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }
}
