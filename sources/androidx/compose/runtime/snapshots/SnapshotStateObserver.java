package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC1805bc;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C1182Zu;
import defpackage.FC;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.NV;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private final InterfaceC0526Fp applyObserver;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final MutableVector<ObservedScopeMap> observedScopeMaps;
    private final InterfaceC3750qp onChangedExecutor;
    private final AtomicReference<Object> pendingChanges;
    private final InterfaceC3750qp readObserver;
    private boolean sendingNotifications;

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotStateObserver$sendNotifications$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public AnonymousClass1() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m2683invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2683invoke() {
            do {
                MutableVector mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                synchronized (mutableVector) {
                    try {
                        if (!snapshotStateObserver.sendingNotifications) {
                            snapshotStateObserver.sendingNotifications = true;
                            try {
                                MutableVector mutableVector2 = snapshotStateObserver.observedScopeMaps;
                                int size = mutableVector2.getSize();
                                if (size > 0) {
                                    Object[] content = mutableVector2.getContent();
                                    int i = 0;
                                    do {
                                        ((ObservedScopeMap) content[i]).notifyInvalidatedScopes();
                                        i++;
                                    } while (i < size);
                                }
                                snapshotStateObserver.sendingNotifications = false;
                            } catch (Throwable th) {
                                snapshotStateObserver.sendingNotifications = false;
                                throw th;
                            }
                        }
                        FW fw = FW.a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } while (SnapshotStateObserver.this.drainChanges());
        }
    }

    public SnapshotStateObserver(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "onChangedExecutor");
        this.onChangedExecutor = interfaceC3750qp;
        this.pendingChanges = new AtomicReference<>(null);
        this.applyObserver = new SnapshotStateObserver$applyObserver$1(this);
        this.readObserver = new SnapshotStateObserver$readObserver$1(this);
        this.observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addChanges(Set<? extends Object> set) {
        Object obj;
        List listP0;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                listP0 = set;
            } else if (obj instanceof Set) {
                listP0 = AbstractC1886cc.p(obj, set);
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new C1182Zu();
                }
                listP0 = AbstractC3240kc.p0((Collection) obj, AbstractC1805bc.e(set));
            }
        } while (!FC.a(this.pendingChanges, obj, listP0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set<? extends Object> setRemoveChanges = removeChanges();
            if (setRemoveChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMaps) {
                try {
                    MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                    int size = mutableVector.getSize();
                    if (size > 0) {
                        ObservedScopeMap[] content = mutableVector.getContent();
                        int i = 0;
                        do {
                            z2 = content[i].recordInvalidation(setRemoveChanges) || z2;
                            i++;
                        } while (i < size);
                    }
                    FW fw = FW.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private final <T> ObservedScopeMap ensureMap(InterfaceC3750qp interfaceC3750qp) {
        ObservedScopeMap observedScopeMap;
        MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
        int size = mutableVector.getSize();
        if (size <= 0) {
            observedScopeMap = null;
            break;
        }
        ObservedScopeMap[] content = mutableVector.getContent();
        int i = 0;
        while (true) {
            observedScopeMap = content[i];
            if (observedScopeMap.getOnChanged() == interfaceC3750qp) {
                break;
            }
            i++;
            if (i >= size) {
                observedScopeMap = null;
                break;
            }
        }
        ObservedScopeMap observedScopeMap2 = observedScopeMap;
        if (observedScopeMap2 != null) {
            return observedScopeMap2;
        }
        AbstractC4492zt.f(interfaceC3750qp, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap observedScopeMap3 = new ObservedScopeMap((InterfaceC3750qp) NV.d(interfaceC3750qp, 1));
        this.observedScopeMaps.add(observedScopeMap3);
        return observedScopeMap3;
    }

    private final void forEachScopeMap(InterfaceC3750qp interfaceC3750qp) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        interfaceC3750qp.invoke(content[i]);
                        i++;
                    } while (i < size);
                }
                FW fw = FW.a;
                AbstractC0703Ks.b(1);
            } finally {
                AbstractC0703Ks.b(1);
                AbstractC0703Ks.a(1);
            }
        }
    }

    private final Set<Object> removeChanges() {
        Object obj;
        Object objSubList;
        Set<Object> set;
        do {
            obj = this.pendingChanges.get();
            objSubList = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new C1182Zu();
                }
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    objSubList = list.get(1);
                } else if (list.size() > 2) {
                    objSubList = list.subList(1, list.size());
                }
                set = set2;
            }
        } while (!FC.a(this.pendingChanges, obj, objSubList));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new C1182Zu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new AnonymousClass1());
    }

    public final void clear(Object obj) {
        AbstractC4492zt.h(obj, "scope");
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        content[i].clearScopeObservations(obj);
                        i++;
                    } while (i < size);
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void clearIf(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        content[i].removeScopeIf(interfaceC3750qp);
                        i++;
                    } while (i < size);
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void notifyChanges(Set<? extends Object> set, Snapshot snapshot) {
        AbstractC4492zt.h(set, "changes");
        AbstractC4492zt.h(snapshot, "snapshot");
        this.applyObserver.mo13invoke(set, snapshot);
    }

    public final <T> void observeReads(T t, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op) {
        ObservedScopeMap observedScopeMapEnsureMap;
        AbstractC4492zt.h(t, "scope");
        AbstractC4492zt.h(interfaceC3750qp, "onValueChangedForScope");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        synchronized (this.observedScopeMaps) {
            observedScopeMapEnsureMap = ensureMap(interfaceC3750qp);
        }
        boolean z = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        try {
            this.isPaused = false;
            this.currentMap = observedScopeMapEnsureMap;
            observedScopeMapEnsureMap.observe(t, this.readObserver, interfaceC3588op);
        } finally {
            this.currentMap = observedScopeMap;
            this.isPaused = z;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void withNoObservations(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        boolean z = this.isPaused;
        this.isPaused = true;
        try {
            interfaceC3588op.invoke();
        } finally {
            this.isPaused = z;
        }
    }

    public static final class ObservedScopeMap {
        private Object currentScope;
        private IdentityArrayIntMap currentScopeReads;
        private int currentToken;
        private final IdentityScopeMap<DerivedState<?>> dependencyToDerivedStates;
        private int deriveStateScopeCount;
        private final DerivedStateObserver derivedStateObserver;
        private final IdentityArraySet<Object> invalidated;
        private final InterfaceC3750qp onChanged;
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues;
        private final IdentityArrayMap<Object, IdentityArrayIntMap> scopeToValues;
        private final MutableVector<DerivedState<?>> statesToReread;
        private final IdentityScopeMap<Object> valueToScopes;

        public ObservedScopeMap(InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "onChanged");
            this.onChanged = interfaceC3750qp;
            this.currentToken = -1;
            this.valueToScopes = new IdentityScopeMap<>();
            this.scopeToValues = new IdentityArrayMap<>(0, 1, null);
            this.invalidated = new IdentityArraySet<>();
            this.statesToReread = new MutableVector<>(new DerivedState[16], 0);
            this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
                @Override // androidx.compose.runtime.DerivedStateObserver
                public void done(DerivedState<?> derivedState) {
                    AbstractC4492zt.h(derivedState, "derivedState");
                    this.this$0.deriveStateScopeCount--;
                }

                @Override // androidx.compose.runtime.DerivedStateObserver
                public void start(DerivedState<?> derivedState) {
                    AbstractC4492zt.h(derivedState, "derivedState");
                    this.this$0.deriveStateScopeCount++;
                }
            };
            this.dependencyToDerivedStates = new IdentityScopeMap<>();
            this.recordedDerivedStateValues = new HashMap<>();
        }

        private final void clearObsoleteStateReads(Object obj) {
            int i = this.currentToken;
            IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
            if (identityArrayIntMap != null) {
                Object[] keys = identityArrayIntMap.getKeys();
                int[] values = identityArrayIntMap.getValues();
                int size = identityArrayIntMap.getSize();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    Object obj2 = keys[i3];
                    AbstractC4492zt.f(obj2, "null cannot be cast to non-null type kotlin.Any");
                    int i4 = values[i3];
                    boolean z = i4 != i;
                    if (z) {
                        removeObservation(obj, obj2);
                    }
                    if (!z) {
                        if (i2 != i3) {
                            keys[i2] = obj2;
                            values[i2] = i4;
                        }
                        i2++;
                    }
                }
                for (int i5 = i2; i5 < size; i5++) {
                    keys[i5] = null;
                }
                identityArrayIntMap.size = i2;
            }
        }

        private final void removeObservation(Object obj, Object obj2) {
            this.valueToScopes.remove(obj2, obj);
            if (!(obj2 instanceof DerivedState) || this.valueToScopes.contains(obj2)) {
                return;
            }
            this.dependencyToDerivedStates.removeScope(obj2);
            this.recordedDerivedStateValues.remove(obj2);
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        public final void clearScopeObservations(Object obj) {
            AbstractC4492zt.h(obj, "scope");
            IdentityArrayIntMap identityArrayIntMapRemove = this.scopeToValues.remove(obj);
            if (identityArrayIntMapRemove == null) {
                return;
            }
            Object[] keys = identityArrayIntMapRemove.getKeys();
            int[] values = identityArrayIntMapRemove.getValues();
            int size = identityArrayIntMapRemove.getSize();
            for (int i = 0; i < size; i++) {
                Object obj2 = keys[i];
                AbstractC4492zt.f(obj2, "null cannot be cast to non-null type kotlin.Any");
                int i2 = values[i];
                removeObservation(obj, obj2);
            }
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final InterfaceC3750qp getOnChanged() {
            return this.onChanged;
        }

        public final void notifyInvalidatedScopes() {
            IdentityArraySet<Object> identityArraySet = this.invalidated;
            InterfaceC3750qp interfaceC3750qp = this.onChanged;
            Object[] values = identityArraySet.getValues();
            int size = identityArraySet.size();
            for (int i = 0; i < size; i++) {
                Object obj = values[i];
                AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                interfaceC3750qp.invoke(obj);
            }
            identityArraySet.clear();
        }

        public final void observe(Object obj, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op) {
            AbstractC4492zt.h(obj, "scope");
            AbstractC4492zt.h(interfaceC3750qp, "readObserver");
            AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
            Object obj2 = this.currentScope;
            IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
            int i = this.currentToken;
            this.currentScope = obj;
            this.currentScopeReads = this.scopeToValues.get(obj);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver derivedStateObserver = this.derivedStateObserver;
            MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                mutableVectorDerivedStateObservers.add(derivedStateObserver);
                Snapshot.Companion.observe(interfaceC3750qp, null, interfaceC3588op);
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                Object obj3 = this.currentScope;
                AbstractC4492zt.e(obj3);
                clearObsoleteStateReads(obj3);
                this.currentScope = obj2;
                this.currentScopeReads = identityArrayIntMap;
                this.currentToken = i;
            } catch (Throwable th) {
                mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                throw th;
            }
        }

        public final boolean recordInvalidation(Set<? extends Object> set) {
            boolean z;
            int iFind;
            int i;
            Object[] objArr;
            int iFind2;
            AbstractC4492zt.h(set, "changes");
            IdentityScopeMap<DerivedState<?>> identityScopeMap = this.dependencyToDerivedStates;
            HashMap<DerivedState<?>, Object> map = this.recordedDerivedStateValues;
            IdentityScopeMap<Object> identityScopeMap2 = this.valueToScopes;
            IdentityArraySet<Object> identityArraySet = this.invalidated;
            if (set instanceof IdentityArraySet) {
                IdentityArraySet identityArraySet2 = (IdentityArraySet) set;
                Object[] values = identityArraySet2.getValues();
                int size = identityArraySet2.size();
                int i2 = 0;
                z = false;
                while (i2 < size) {
                    Object obj = values[i2];
                    AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    if (!identityScopeMap.contains(obj) || (iFind2 = identityScopeMap.find(obj)) < 0) {
                        i = size;
                        objArr = values;
                    } else {
                        IdentityArraySet identityArraySetScopeSetAt = identityScopeMap.scopeSetAt(iFind2);
                        Object[] values2 = identityArraySetScopeSetAt.getValues();
                        int size2 = identityArraySetScopeSetAt.size();
                        int i3 = 0;
                        while (i3 < size2) {
                            Object obj2 = values2[i3];
                            AbstractC4492zt.f(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            DerivedState<?> derivedState = (DerivedState) obj2;
                            AbstractC4492zt.f(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                            int i4 = size;
                            Object obj3 = map.get(derivedState);
                            SnapshotMutationPolicy<?> policy = derivedState.getPolicy();
                            if (policy == null) {
                                policy = SnapshotStateKt.structuralEqualityPolicy();
                            }
                            Object[] objArr2 = values;
                            boolean z2 = z;
                            if (policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), obj3)) {
                                this.statesToReread.add(derivedState);
                            } else {
                                int iFind3 = identityScopeMap2.find(derivedState);
                                if (iFind3 >= 0) {
                                    IdentityArraySet identityArraySetScopeSetAt2 = identityScopeMap2.scopeSetAt(iFind3);
                                    Object[] values3 = identityArraySetScopeSetAt2.getValues();
                                    int size3 = identityArraySetScopeSetAt2.size();
                                    z = z2;
                                    int i5 = 0;
                                    while (i5 < size3) {
                                        Object obj4 = values3[i5];
                                        AbstractC4492zt.f(obj4, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                        identityArraySet.add(obj4);
                                        i5++;
                                        z = true;
                                    }
                                }
                                i3++;
                                size = i4;
                                values = objArr2;
                            }
                            z = z2;
                            i3++;
                            size = i4;
                            values = objArr2;
                        }
                        i = size;
                        objArr = values;
                    }
                    int iFind4 = identityScopeMap2.find(obj);
                    if (iFind4 >= 0) {
                        IdentityArraySet identityArraySetScopeSetAt3 = identityScopeMap2.scopeSetAt(iFind4);
                        Object[] values4 = identityArraySetScopeSetAt3.getValues();
                        int size4 = identityArraySetScopeSetAt3.size();
                        int i6 = 0;
                        while (i6 < size4) {
                            Object obj5 = values4[i6];
                            AbstractC4492zt.f(obj5, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            identityArraySet.add(obj5);
                            i6++;
                            z = true;
                        }
                    }
                    i2++;
                    size = i;
                    values = objArr;
                }
            } else {
                Iterator it = set.iterator();
                z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (identityScopeMap.contains(next) && (iFind = identityScopeMap.find(next)) >= 0) {
                        IdentityArraySet identityArraySetScopeSetAt4 = identityScopeMap.scopeSetAt(iFind);
                        Object[] values5 = identityArraySetScopeSetAt4.getValues();
                        int size5 = identityArraySetScopeSetAt4.size();
                        int i7 = 0;
                        while (i7 < size5) {
                            Object obj6 = values5[i7];
                            AbstractC4492zt.f(obj6, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            DerivedState<?> derivedState2 = (DerivedState) obj6;
                            AbstractC4492zt.f(derivedState2, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                            Object obj7 = map.get(derivedState2);
                            SnapshotMutationPolicy<?> policy2 = derivedState2.getPolicy();
                            if (policy2 == null) {
                                policy2 = SnapshotStateKt.structuralEqualityPolicy();
                            }
                            Iterator it2 = it;
                            if (policy2.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), obj7)) {
                                this.statesToReread.add(derivedState2);
                            } else {
                                int iFind5 = identityScopeMap2.find(derivedState2);
                                if (iFind5 >= 0) {
                                    IdentityArraySet identityArraySetScopeSetAt5 = identityScopeMap2.scopeSetAt(iFind5);
                                    Object[] values6 = identityArraySetScopeSetAt5.getValues();
                                    int size6 = identityArraySetScopeSetAt5.size();
                                    int i8 = 0;
                                    while (i8 < size6) {
                                        Object obj8 = values6[i8];
                                        AbstractC4492zt.f(obj8, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                        identityArraySet.add(obj8);
                                        i8++;
                                        z = true;
                                    }
                                }
                            }
                            i7++;
                            it = it2;
                        }
                    }
                    Iterator it3 = it;
                    int iFind6 = identityScopeMap2.find(next);
                    if (iFind6 >= 0) {
                        IdentityArraySet identityArraySetScopeSetAt6 = identityScopeMap2.scopeSetAt(iFind6);
                        Object[] values7 = identityArraySetScopeSetAt6.getValues();
                        int size7 = identityArraySetScopeSetAt6.size();
                        int i9 = 0;
                        while (i9 < size7) {
                            Object obj9 = values7[i9];
                            AbstractC4492zt.f(obj9, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            identityArraySet.add(obj9);
                            i9++;
                            z = true;
                        }
                    }
                    it = it3;
                }
            }
            if (this.statesToReread.isNotEmpty()) {
                MutableVector<DerivedState<?>> mutableVector = this.statesToReread;
                int size8 = mutableVector.getSize();
                if (size8 > 0) {
                    DerivedState<?>[] content = mutableVector.getContent();
                    int i10 = 0;
                    do {
                        rereadDerivedState(content[i10]);
                        i10++;
                    } while (i10 < size8);
                }
                this.statesToReread.clear();
            }
            return z;
        }

        public final void recordRead(Object obj) {
            AbstractC4492zt.h(obj, "value");
            Object obj2 = this.currentScope;
            AbstractC4492zt.e(obj2);
            int i = this.currentToken;
            IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
            if (identityArrayIntMap == null) {
                identityArrayIntMap = new IdentityArrayIntMap();
                this.currentScopeReads = identityArrayIntMap;
                this.scopeToValues.set(obj2, identityArrayIntMap);
                FW fw = FW.a;
            }
            recordRead(obj, i, obj2, identityArrayIntMap);
        }

        public final void removeScopeIf(InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            IdentityArrayMap<Object, IdentityArrayIntMap> identityArrayMap = this.scopeToValues;
            int size = identityArrayMap.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = identityArrayMap.getKeys()[i2];
                AbstractC4492zt.f(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                IdentityArrayIntMap identityArrayIntMap = (IdentityArrayIntMap) identityArrayMap.getValues()[i2];
                Boolean bool = (Boolean) interfaceC3750qp.invoke(obj);
                if (bool.booleanValue()) {
                    Object[] keys = identityArrayIntMap.getKeys();
                    int[] values = identityArrayIntMap.getValues();
                    int size2 = identityArrayIntMap.getSize();
                    for (int i3 = 0; i3 < size2; i3++) {
                        Object obj2 = keys[i3];
                        AbstractC4492zt.f(obj2, "null cannot be cast to non-null type kotlin.Any");
                        int i4 = values[i3];
                        removeObservation(obj, obj2);
                    }
                }
                if (!bool.booleanValue()) {
                    if (i != i2) {
                        identityArrayMap.getKeys()[i] = obj;
                        identityArrayMap.getValues()[i] = identityArrayMap.getValues()[i2];
                    }
                    i++;
                }
            }
            if (identityArrayMap.getSize() > i) {
                int size3 = identityArrayMap.getSize();
                for (int i5 = i; i5 < size3; i5++) {
                    identityArrayMap.getKeys()[i5] = null;
                    identityArrayMap.getValues()[i5] = null;
                }
                ((IdentityArrayMap) identityArrayMap).size = i;
            }
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            AbstractC4492zt.h(derivedState, "derivedState");
            IdentityArrayMap<Object, IdentityArrayIntMap> identityArrayMap = this.scopeToValues;
            int id = SnapshotKt.currentSnapshot().getId();
            IdentityScopeMap<Object> identityScopeMap = this.valueToScopes;
            int iFind = identityScopeMap.find(derivedState);
            if (iFind >= 0) {
                IdentityArraySet identityArraySetScopeSetAt = identityScopeMap.scopeSetAt(iFind);
                Object[] values = identityArraySetScopeSetAt.getValues();
                int size = identityArraySetScopeSetAt.size();
                for (int i = 0; i < size; i++) {
                    Object obj = values[i];
                    AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    IdentityArrayIntMap identityArrayIntMap = identityArrayMap.get(obj);
                    if (identityArrayIntMap == null) {
                        identityArrayIntMap = new IdentityArrayIntMap();
                        identityArrayMap.set(obj, identityArrayIntMap);
                        FW fw = FW.a;
                    }
                    recordRead(derivedState, id, obj, identityArrayIntMap);
                }
            }
        }

        private final void recordRead(Object obj, int i, Object obj2, IdentityArrayIntMap identityArrayIntMap) {
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int iAdd = identityArrayIntMap.add(obj, i);
            if ((obj instanceof DerivedState) && iAdd != i) {
                DerivedState.Record currentRecord = ((DerivedState) obj).getCurrentRecord();
                this.recordedDerivedStateValues.put(obj, currentRecord.getCurrentValue());
                Object[] dependencies = currentRecord.getDependencies();
                IdentityScopeMap<DerivedState<?>> identityScopeMap = this.dependencyToDerivedStates;
                identityScopeMap.removeScope(obj);
                for (Object obj3 : dependencies) {
                    if (obj3 == null) {
                        break;
                    }
                    identityScopeMap.add(obj3, obj);
                }
            }
            if (iAdd == -1) {
                this.valueToScopes.add(obj, obj2);
            }
        }
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        content[i].clear();
                        i++;
                    } while (i < size);
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
