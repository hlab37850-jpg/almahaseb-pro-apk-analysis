package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C1182Zu;
import defpackage.C2020dG;
import defpackage.FC;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.Q5;
import defpackage.R5;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class CompositionImpl implements ControlledComposition, RecomposeScopeOwner {
    private final InterfaceC0988Vf _recomposeContext;
    private final HashSet<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final List<InterfaceC0552Gp> changes;
    private InterfaceC0526Fp composable;
    private final ComposerImpl composer;
    private final HashSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final IdentityScopeMap<DerivedState<?>> derivedStates;
    private boolean disposed;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidations;
    private final boolean isRoot;
    private final List<InterfaceC0552Gp> lateChanges;
    private final Object lock;
    private final IdentityScopeMap<RecomposeScopeImpl> observations;
    private final IdentityScopeMap<RecomposeScopeImpl> observationsProcessed;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    public static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private List<ComposeNodeLifecycleCallback> deactivating;
        private final List<RememberObserver> forgetting;
        private List<ComposeNodeLifecycleCallback> releasing;
        private final List<RememberObserver> remembering;
        private final List<InterfaceC3588op> sideEffects;

        public RememberEventDispatcher(Set<RememberObserver> set) {
            AbstractC4492zt.h(set, "abandoning");
            this.abandoning = set;
            this.remembering = new ArrayList();
            this.forgetting = new ArrayList();
            this.sideEffects = new ArrayList();
        }

        @Override // androidx.compose.runtime.RememberManager
        public void deactivating(ComposeNodeLifecycleCallback composeNodeLifecycleCallback) {
            AbstractC4492zt.h(composeNodeLifecycleCallback, "instance");
            List arrayList = this.deactivating;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.deactivating = arrayList;
            }
            arrayList.add(composeNodeLifecycleCallback);
        }

        public final void dispatchAbandons() {
            if (this.abandoning.isEmpty()) {
                return;
            }
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:abandons");
            try {
                Iterator<RememberObserver> it = this.abandoning.iterator();
                while (it.hasNext()) {
                    RememberObserver next = it.next();
                    it.remove();
                    next.onAbandoned();
                }
                FW fw = FW.a;
            } finally {
                Trace.INSTANCE.endSection(objBeginSection);
            }
        }

        public final void dispatchRememberObservers() {
            List<ComposeNodeLifecycleCallback> list = this.deactivating;
            List<ComposeNodeLifecycleCallback> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                Object objBeginSection = Trace.INSTANCE.beginSection("Compose:deactivations");
                try {
                    for (int size = list.size() - 1; -1 < size; size--) {
                        list.get(size).onDeactivate();
                    }
                    FW fw = FW.a;
                    Trace.INSTANCE.endSection(objBeginSection);
                    list.clear();
                } catch (Throwable th) {
                    Trace.INSTANCE.endSection(objBeginSection);
                    throw th;
                }
            }
            if (!this.forgetting.isEmpty()) {
                Object objBeginSection2 = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    for (int size2 = this.forgetting.size() - 1; -1 < size2; size2--) {
                        RememberObserver rememberObserver = this.forgetting.get(size2);
                        if (!this.abandoning.contains(rememberObserver)) {
                            rememberObserver.onForgotten();
                        }
                    }
                    FW fw2 = FW.a;
                    Trace.INSTANCE.endSection(objBeginSection2);
                } catch (Throwable th2) {
                    Trace.INSTANCE.endSection(objBeginSection2);
                    throw th2;
                }
            }
            if (!this.remembering.isEmpty()) {
                Object objBeginSection3 = Trace.INSTANCE.beginSection("Compose:onRemembered");
                try {
                    List<RememberObserver> list3 = this.remembering;
                    int size3 = list3.size();
                    for (int i = 0; i < size3; i++) {
                        RememberObserver rememberObserver2 = list3.get(i);
                        this.abandoning.remove(rememberObserver2);
                        rememberObserver2.onRemembered();
                    }
                    FW fw3 = FW.a;
                    Trace.INSTANCE.endSection(objBeginSection3);
                } catch (Throwable th3) {
                    Trace.INSTANCE.endSection(objBeginSection3);
                    throw th3;
                }
            }
            List<ComposeNodeLifecycleCallback> list4 = this.releasing;
            List<ComposeNodeLifecycleCallback> list5 = list4;
            if (list5 == null || list5.isEmpty()) {
                return;
            }
            Object objBeginSection4 = Trace.INSTANCE.beginSection("Compose:releases");
            try {
                for (int size4 = list4.size() - 1; -1 < size4; size4--) {
                    list4.get(size4).onRelease();
                }
                FW fw4 = FW.a;
                Trace.INSTANCE.endSection(objBeginSection4);
                list4.clear();
            } catch (Throwable th4) {
                Trace.INSTANCE.endSection(objBeginSection4);
                throw th4;
            }
        }

        public final void dispatchSideEffects() {
            if (this.sideEffects.isEmpty()) {
                return;
            }
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
            try {
                List<InterfaceC3588op> list = this.sideEffects;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).invoke();
                }
                this.sideEffects.clear();
                FW fw = FW.a;
            } finally {
                Trace.INSTANCE.endSection(objBeginSection);
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(RememberObserver rememberObserver) {
            AbstractC4492zt.h(rememberObserver, "instance");
            int iLastIndexOf = this.remembering.lastIndexOf(rememberObserver);
            if (iLastIndexOf < 0) {
                this.forgetting.add(rememberObserver);
            } else {
                this.remembering.remove(iLastIndexOf);
                this.abandoning.remove(rememberObserver);
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void releasing(ComposeNodeLifecycleCallback composeNodeLifecycleCallback) {
            AbstractC4492zt.h(composeNodeLifecycleCallback, "instance");
            List arrayList = this.releasing;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.releasing = arrayList;
            }
            arrayList.add(composeNodeLifecycleCallback);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(RememberObserver rememberObserver) {
            AbstractC4492zt.h(rememberObserver, "instance");
            int iLastIndexOf = this.forgetting.lastIndexOf(rememberObserver);
            if (iLastIndexOf < 0) {
                this.remembering.add(rememberObserver);
            } else {
                this.forgetting.remove(iLastIndexOf);
                this.abandoning.remove(rememberObserver);
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void sideEffect(InterfaceC3588op interfaceC3588op) {
            AbstractC4492zt.h(interfaceC3588op, "effect");
            this.sideEffects.add(interfaceC3588op);
        }
    }

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier, InterfaceC0988Vf interfaceC0988Vf) {
        AbstractC4492zt.h(compositionContext, "parent");
        AbstractC4492zt.h(applier, "applier");
        this.parent = compositionContext;
        this.applier = applier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        HashSet<RememberObserver> hashSet = new HashSet<>();
        this.abandonSet = hashSet;
        SlotTable slotTable = new SlotTable();
        this.slotTable = slotTable;
        this.observations = new IdentityScopeMap<>();
        this.conditionallyInvalidatedScopes = new HashSet<>();
        this.derivedStates = new IdentityScopeMap<>();
        ArrayList arrayList = new ArrayList();
        this.changes = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.lateChanges = arrayList2;
        this.observationsProcessed = new IdentityScopeMap<>();
        this.invalidations = new IdentityArrayMap<>(0, 1, null);
        ComposerImpl composerImpl = new ComposerImpl(applier, compositionContext, slotTable, hashSet, arrayList, arrayList2, this);
        compositionContext.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = interfaceC0988Vf;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m2627getLambda1$runtime_release();
    }

    private final void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        this.abandonSet.clear();
    }

    private final HashSet<RecomposeScopeImpl> addPendingInvalidationsLocked(HashSet<RecomposeScopeImpl> hashSet, Object obj, boolean z) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
        int iFind = identityScopeMap.find(obj);
        if (iFind >= 0) {
            IdentityArraySet identityArraySetScopeSetAt = identityScopeMap.scopeSetAt(iFind);
            Object[] values = identityArraySetScopeSetAt.getValues();
            int size = identityArraySetScopeSetAt.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = values[i];
                AbstractC4492zt.f(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
                if (!this.observationsProcessed.remove(obj, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                    if (!recomposeScopeImpl.isConditional() || z) {
                        if (hashSet == null) {
                            hashSet = new HashSet<>();
                        }
                        hashSet.add(recomposeScopeImpl);
                    } else {
                        this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                    }
                }
            }
        }
        return hashSet;
    }

    private final void applyChangesInLocked(List<InterfaceC0552Gp> list) {
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        try {
            if (list.isEmpty()) {
                if (this.lateChanges.isEmpty()) {
                    rememberEventDispatcher.dispatchAbandons();
                    return;
                }
                return;
            }
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:applyChanges");
            try {
                this.applier.onBeginChanges();
                SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                try {
                    Applier<?> applier = this.applier;
                    int size = list.size();
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        list.get(i2).invoke(applier, slotWriterOpenWriter, rememberEventDispatcher);
                    }
                    list.clear();
                    FW fw = FW.a;
                    slotWriterOpenWriter.close();
                    this.applier.onEndChanges();
                    Trace trace = Trace.INSTANCE;
                    trace.endSection(objBeginSection);
                    rememberEventDispatcher.dispatchRememberObservers();
                    rememberEventDispatcher.dispatchSideEffects();
                    if (this.pendingInvalidScopes) {
                        Object objBeginSection2 = trace.beginSection("Compose:unobserve");
                        try {
                            this.pendingInvalidScopes = false;
                            IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
                            int[] valueOrder = identityScopeMap.getValueOrder();
                            IdentityArraySet<RecomposeScopeImpl>[] scopeSets = identityScopeMap.getScopeSets();
                            Object[] values = identityScopeMap.getValues();
                            int size2 = identityScopeMap.getSize();
                            int i3 = 0;
                            int i4 = 0;
                            while (i3 < size2) {
                                int i5 = valueOrder[i3];
                                IdentityArraySet<RecomposeScopeImpl> identityArraySet = scopeSets[i5];
                                AbstractC4492zt.e(identityArraySet);
                                Object[] values2 = identityArraySet.getValues();
                                int size3 = identityArraySet.size();
                                int i6 = 0;
                                while (i < size3) {
                                    IdentityArraySet<RecomposeScopeImpl>[] identityArraySetArr = scopeSets;
                                    Object obj = values2[i];
                                    int i7 = size2;
                                    AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                    if (((RecomposeScopeImpl) obj).getValid()) {
                                        if (i6 != i) {
                                            values2[i6] = obj;
                                        }
                                        i6++;
                                    }
                                    i++;
                                    scopeSets = identityArraySetArr;
                                    size2 = i7;
                                }
                                IdentityArraySet<RecomposeScopeImpl>[] identityArraySetArr2 = scopeSets;
                                int i8 = size2;
                                for (int i9 = i6; i9 < size3; i9++) {
                                    values2[i9] = null;
                                }
                                ((IdentityArraySet) identityArraySet).size = i6;
                                if (identityArraySet.size() > 0) {
                                    if (i4 != i3) {
                                        int i10 = valueOrder[i4];
                                        valueOrder[i4] = i5;
                                        valueOrder[i3] = i10;
                                    }
                                    i4++;
                                }
                                i3++;
                                scopeSets = identityArraySetArr2;
                                size2 = i8;
                                i = 0;
                            }
                            int size4 = identityScopeMap.getSize();
                            for (int i11 = i4; i11 < size4; i11++) {
                                values[valueOrder[i11]] = null;
                            }
                            identityScopeMap.setSize(i4);
                            cleanUpDerivedStateObservations();
                            FW fw2 = FW.a;
                            Trace.INSTANCE.endSection(objBeginSection2);
                        } catch (Throwable th) {
                            Trace.INSTANCE.endSection(objBeginSection2);
                            throw th;
                        }
                    }
                    if (this.lateChanges.isEmpty()) {
                        rememberEventDispatcher.dispatchAbandons();
                    }
                } catch (Throwable th2) {
                    slotWriterOpenWriter.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                Trace.INSTANCE.endSection(objBeginSection);
                throw th3;
            }
        } catch (Throwable th4) {
            if (this.lateChanges.isEmpty()) {
                rememberEventDispatcher.dispatchAbandons();
            }
            throw th4;
        }
    }

    private final void cleanUpDerivedStateObservations() {
        IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
        int[] valueOrder = identityScopeMap.getValueOrder();
        IdentityArraySet<DerivedState<?>>[] scopeSets = identityScopeMap.getScopeSets();
        Object[] values = identityScopeMap.getValues();
        int size = identityScopeMap.getSize();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = valueOrder[i];
            IdentityArraySet<DerivedState<?>> identityArraySet = scopeSets[i3];
            AbstractC4492zt.e(identityArraySet);
            Object[] values2 = identityArraySet.getValues();
            int size2 = identityArraySet.size();
            int i4 = 0;
            int i5 = 0;
            while (i4 < size2) {
                Object obj = values2[i4];
                AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                IdentityArraySet<DerivedState<?>>[] identityArraySetArr = scopeSets;
                if (this.observations.contains((DerivedState) obj)) {
                    if (i5 != i4) {
                        values2[i5] = obj;
                    }
                    i5++;
                }
                i4++;
                scopeSets = identityArraySetArr;
            }
            IdentityArraySet<DerivedState<?>>[] identityArraySetArr2 = scopeSets;
            for (int i6 = i5; i6 < size2; i6++) {
                values2[i6] = null;
            }
            ((IdentityArraySet) identityArraySet).size = i5;
            if (identityArraySet.size() > 0) {
                if (i2 != i) {
                    int i7 = valueOrder[i2];
                    valueOrder[i2] = i3;
                    valueOrder[i] = i7;
                }
                i2++;
            }
            i++;
            scopeSets = identityArraySetArr2;
        }
        int size3 = identityScopeMap.getSize();
        for (int i8 = i2; i8 < size3; i8++) {
            values[valueOrder[i8]] = null;
        }
        identityScopeMap.setSize(i2);
        if (this.conditionallyInvalidatedScopes.isEmpty()) {
            return;
        }
        Iterator<RecomposeScopeImpl> it = this.conditionallyInvalidatedScopes.iterator();
        AbstractC4492zt.g(it, "iterator()");
        while (it.hasNext()) {
            if (!it.next().isConditional()) {
                it.remove();
            }
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet != null) {
            if (AbstractC4492zt.d(andSet, CompositionKt.PendingApplyNoModifications)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new C1182Zu();
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new C1182Zu();
            }
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, true);
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet(null);
        if (AbstractC4492zt.d(andSet, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        if (andSet == null) {
            ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new C1182Zu();
        }
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new C1182Zu();
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    private final <T> T guardChanges(InterfaceC3588op interfaceC3588op) throws Exception {
        try {
            try {
                T t = (T) interfaceC3588op.invoke();
                AbstractC0703Ks.b(1);
                return t;
            } finally {
                AbstractC0703Ks.b(1);
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                AbstractC0703Ks.a(1);
            }
        } catch (Exception e) {
            abandonChanges();
            throw e;
        }
    }

    private final <T> T guardInvalidationsLocked(InterfaceC3750qp interfaceC3750qp) throws Exception {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMapTakeInvalidations = takeInvalidations();
        try {
            return (T) interfaceC3750qp.invoke(identityArrayMapTakeInvalidations);
        } catch (Exception e) {
            this.invalidations = identityArrayMapTakeInvalidations;
            throw e;
        }
    }

    private final InvalidationResult invalidateChecked(RecomposeScopeImpl recomposeScopeImpl, Anchor anchor, Object obj) {
        synchronized (this.lock) {
            try {
                CompositionImpl compositionImpl = this.invalidationDelegate;
                if (compositionImpl == null || !this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                    compositionImpl = null;
                }
                if (compositionImpl == null) {
                    if (tryImminentInvalidation(recomposeScopeImpl, obj)) {
                        return InvalidationResult.IMMINENT;
                    }
                    if (obj == null) {
                        this.invalidations.set(recomposeScopeImpl, null);
                    } else {
                        CompositionKt.addValue(this.invalidations, recomposeScopeImpl, obj);
                    }
                }
                if (compositionImpl != null) {
                    return compositionImpl.invalidateChecked(recomposeScopeImpl, anchor, obj);
                }
                this.parent.invalidate$runtime_release(this);
                return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void invalidateScopeOfLocked(Object obj) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
        int iFind = identityScopeMap.find(obj);
        if (iFind >= 0) {
            IdentityArraySet identityArraySetScopeSetAt = identityScopeMap.scopeSetAt(iFind);
            Object[] values = identityArraySetScopeSetAt.getValues();
            int size = identityArraySetScopeSetAt.size();
            for (int i = 0; i < size; i++) {
                Object obj2 = values[i];
                AbstractC4492zt.f(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
                if (recomposeScopeImpl.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                    this.observationsProcessed.add(obj, recomposeScopeImpl);
                }
            }
        }
    }

    private final IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations() {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap = this.invalidations;
        this.invalidations = new IdentityArrayMap<>(0, 1, null);
        return identityArrayMap;
    }

    private final <T> T trackAbandonedValues(InterfaceC3588op interfaceC3588op) {
        try {
            T t = (T) interfaceC3588op.invoke();
            AbstractC0703Ks.b(1);
            return t;
        } finally {
            AbstractC0703Ks.b(1);
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            AbstractC0703Ks.a(1);
        }
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime_release(recomposeScopeImpl, obj);
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable) {
        Object[] slots = slotTable.getSlots();
        ArrayList arrayList = new ArrayList();
        for (Object obj : slots) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && !slotTable.slotsOf$runtime_release(anchor.toIndexFor(slotTable)).contains(recomposeScopeImpl2)) {
                throw new IllegalStateException(("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + R5.S(slotTable.getSlots(), recomposeScopeImpl2)).toString());
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                FW fw = FW.a;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e) {
                        abandonChanges();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (!this.lateChanges.isEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e) {
                        abandonChanges();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e) {
                        abandonChanges();
                        throw e;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(InterfaceC0526Fp interfaceC0526Fp) throws Exception {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMapTakeInvalidations = takeInvalidations();
                try {
                    this.composer.composeContent$runtime_release(identityArrayMapTakeInvalidations, interfaceC0526Fp);
                    FW fw = FW.a;
                } catch (Exception e) {
                    this.invalidations = identityArrayMapTakeInvalidations;
                    throw e;
                }
            }
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            } catch (Exception e2) {
                abandonChanges();
                throw e2;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition controlledComposition, int i, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        if (controlledComposition == null || AbstractC4492zt.d(controlledComposition, this) || i < 0) {
            return (R) interfaceC3588op.invoke();
        }
        this.invalidationDelegate = (CompositionImpl) controlledComposition;
        this.invalidationDelegateGroup = i;
        try {
            return (R) interfaceC3588op.invoke();
        } finally {
            this.invalidationDelegate = null;
            this.invalidationDelegateGroup = 0;
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            try {
                if (!this.disposed) {
                    boolean z = true;
                    this.disposed = true;
                    this.composable = ComposableSingletons$CompositionKt.INSTANCE.m2628getLambda2$runtime_release();
                    List<InterfaceC0552Gp> deferredChanges$runtime_release = this.composer.getDeferredChanges$runtime_release();
                    if (deferredChanges$runtime_release != null) {
                        applyChangesInLocked(deferredChanges$runtime_release);
                    }
                    if (this.slotTable.getGroupsSize() <= 0) {
                        z = false;
                    }
                    if (z || !this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                        if (z) {
                            this.applier.onBeginChanges();
                            SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                            try {
                                ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
                                FW fw = FW.a;
                                slotWriterOpenWriter.close();
                                this.applier.clear();
                                this.applier.onEndChanges();
                                rememberEventDispatcher.dispatchRememberObservers();
                            } catch (Throwable th) {
                                slotWriterOpenWriter.close();
                                throw th;
                            }
                        }
                        rememberEventDispatcher.dispatchAbandons();
                    }
                    this.composer.dispose$runtime_release();
                }
                FW fw2 = FW.a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState movableContentState) {
        AbstractC4492zt.h(movableContentState, "state");
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter slotWriterOpenWriter = movableContentState.getSlotTable$runtime_release().openWriter();
        try {
            ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
            FW fw = FW.a;
            slotWriterOpenWriter.close();
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th) {
            slotWriterOpenWriter.close();
            throw th;
        }
    }

    public final InterfaceC0526Fp getComposable() {
        return this.composable;
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return AbstractC3240kc.C0(this.conditionallyInvalidatedScopes);
    }

    public final List<Object> getDerivedStateDependencies$runtime_release() {
        return R5.H(this.derivedStates.getValues());
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = this.invalidations.getSize() > 0;
        }
        return z;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    public final List<Object> getObservedObjects$runtime_release() {
        return R5.H(this.observations.getValues());
    }

    public final boolean getPendingInvalidScopes$runtime_release() {
        return this.pendingInvalidScopes;
    }

    public final InterfaceC0988Vf getRecomposeContext() {
        InterfaceC0988Vf interfaceC0988Vf = this._recomposeContext;
        return interfaceC0988Vf == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : interfaceC0988Vf;
    }

    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<C2020dG> list) throws Exception {
        boolean z = true;
        AbstractC4492zt.h(list, "references");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!AbstractC4492zt.d(((MovableContentStateReference) list.get(i).c()).getComposition$runtime_release(), this)) {
                z = false;
                break;
            }
        }
        ComposerKt.runtimeCheck(z);
        try {
            this.composer.insertMovableContentReferences(list);
            FW fw = FW.a;
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            } catch (Exception e) {
                abandonChanges();
                throw e;
            }
        }
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        CompositionImpl compositionImpl;
        AbstractC4492zt.h(recomposeScopeImpl, "scope");
        if (recomposeScopeImpl.getDefaultsInScope()) {
            recomposeScopeImpl.setDefaultsInvalid(true);
        }
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (this.slotTable.ownsAnchor(anchor)) {
            return !recomposeScopeImpl.getCanRecompose() ? InvalidationResult.IGNORED : invalidateChecked(recomposeScopeImpl, anchor, obj);
        }
        synchronized (this.lock) {
            compositionImpl = this.invalidationDelegate;
        }
        return (compositionImpl == null || !compositionImpl.tryImminentInvalidation(recomposeScopeImpl, obj)) ? InvalidationResult.IGNORED : InvalidationResult.IMMINENT;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        synchronized (this.lock) {
            try {
                for (Object obj : this.slotTable.getSlots()) {
                    RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.invalidate();
                    }
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void invalidateGroupsWithKey(int i) {
        List<RecomposeScopeImpl> listInvalidateGroupsWithKey$runtime_release;
        synchronized (this.lock) {
            listInvalidateGroupsWithKey$runtime_release = this.slotTable.invalidateGroupsWithKey$runtime_release(i);
        }
        if (listInvalidateGroupsWithKey$runtime_release != null) {
            int size = listInvalidateGroupsWithKey$runtime_release.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (listInvalidateGroupsWithKey$runtime_release.get(i2).invalidateForResult(null) != InvalidationResult.IGNORED) {
                }
            }
            return;
        }
        if (this.composer.forceRecomposeScopes$runtime_release()) {
            this.parent.invalidate$runtime_release(this);
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.isComposing$runtime_release();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.disposed;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean observesAnyOf(Set<? extends Object> set) {
        AbstractC4492zt.h(set, "values");
        for (Object obj : set) {
            if (this.observations.contains(obj) || this.derivedStates.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        this.composer.prepareCompose$runtime_release(interfaceC3588op);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        boolean zRecompose$runtime_release;
        synchronized (this.lock) {
            try {
                drainPendingModificationsForCompositionLocked();
                try {
                    IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMapTakeInvalidations = takeInvalidations();
                    try {
                        zRecompose$runtime_release = this.composer.recompose$runtime_release(identityArrayMapTakeInvalidations);
                        if (!zRecompose$runtime_release) {
                            drainPendingModificationsLocked();
                        }
                    } catch (Exception e) {
                        this.invalidations = identityArrayMapTakeInvalidations;
                        throw e;
                    }
                } catch (Throwable th) {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e2) {
                        abandonChanges();
                        throw e2;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zRecompose$runtime_release;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl recomposeScopeImpl) {
        AbstractC4492zt.h(recomposeScopeImpl, "scope");
        this.pendingInvalidScopes = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> set) {
        Object obj;
        Object objX;
        AbstractC4492zt.h(set, "values");
        do {
            obj = this.pendingModifications.get();
            if (obj == null ? true : AbstractC4492zt.d(obj, CompositionKt.PendingApplyNoModifications)) {
                objX = set;
            } else if (obj instanceof Set) {
                objX = new Set[]{obj, set};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                AbstractC4492zt.f(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                objX = Q5.x((Set[]) obj, set);
            }
        } while (!FC.a(this.pendingModifications, obj, objX));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                FW fw = FW.a;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object obj) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        AbstractC4492zt.h(obj, "value");
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) == null) {
            return;
        }
        currentRecomposeScope$runtime_release.setUsed(true);
        if (currentRecomposeScope$runtime_release.recordRead(obj)) {
            return;
        }
        this.observations.add(obj, currentRecomposeScope$runtime_release);
        if (obj instanceof DerivedState) {
            this.derivedStates.removeScope(obj);
            for (Object obj2 : ((DerivedState) obj).getCurrentRecord().getDependencies()) {
                if (obj2 == null) {
                    return;
                }
                this.derivedStates.add(obj2, obj);
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(Object obj) {
        AbstractC4492zt.h(obj, "value");
        synchronized (this.lock) {
            try {
                invalidateScopeOfLocked(obj);
                IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
                int iFind = identityScopeMap.find(obj);
                if (iFind >= 0) {
                    IdentityArraySet identityArraySetScopeSetAt = identityScopeMap.scopeSetAt(iFind);
                    Object[] values = identityArraySetScopeSetAt.getValues();
                    int size = identityArraySetScopeSetAt.size();
                    for (int i = 0; i < size; i++) {
                        Object obj2 = values[i];
                        AbstractC4492zt.f(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                        invalidateScopeOfLocked((DerivedState) obj2);
                    }
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> derivedState) {
        AbstractC4492zt.h(derivedState, "state");
        if (this.observations.contains(derivedState)) {
            return;
        }
        this.derivedStates.removeScope(derivedState);
    }

    public final void removeObservation$runtime_release(Object obj, RecomposeScopeImpl recomposeScopeImpl) {
        AbstractC4492zt.h(obj, "instance");
        AbstractC4492zt.h(recomposeScopeImpl, "scope");
        this.observations.remove(obj, recomposeScopeImpl);
    }

    public final void setComposable(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "<set-?>");
        this.composable = interfaceC0526Fp;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        if (this.disposed) {
            throw new IllegalStateException("The composition is disposed");
        }
        this.composable = interfaceC0526Fp;
        this.parent.composeInitial$runtime_release(this, interfaceC0526Fp);
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z) {
        this.pendingInvalidScopes = z;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            try {
                if (!isComposing()) {
                    this.composer.verifyConsistent$runtime_release();
                    this.slotTable.verifyWellFormed();
                    validateRecomposeScopeAnchors(this.slotTable);
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void addPendingInvalidationsLocked(Set<? extends Object> set, boolean z) {
        HashSet<RecomposeScopeImpl> hashSetAddPendingInvalidationsLocked;
        String str = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet";
        if (set instanceof IdentityArraySet) {
            IdentityArraySet identityArraySet = (IdentityArraySet) set;
            Object[] values = identityArraySet.getValues();
            int size = identityArraySet.size();
            hashSetAddPendingInvalidationsLocked = null;
            for (int i = 0; i < size; i++) {
                Object obj = values[i];
                AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                if (obj instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj).invalidateForResult(null);
                } else {
                    hashSetAddPendingInvalidationsLocked = addPendingInvalidationsLocked(hashSetAddPendingInvalidationsLocked, obj, z);
                    IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
                    int iFind = identityScopeMap.find(obj);
                    if (iFind >= 0) {
                        IdentityArraySet identityArraySetScopeSetAt = identityScopeMap.scopeSetAt(iFind);
                        Object[] values2 = identityArraySetScopeSetAt.getValues();
                        int size2 = identityArraySetScopeSetAt.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            Object obj2 = values2[i2];
                            AbstractC4492zt.f(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            hashSetAddPendingInvalidationsLocked = addPendingInvalidationsLocked(hashSetAddPendingInvalidationsLocked, (DerivedState) obj2, z);
                        }
                    }
                }
            }
        } else {
            hashSetAddPendingInvalidationsLocked = null;
            for (Object obj3 : set) {
                if (obj3 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj3).invalidateForResult(null);
                } else {
                    HashSet<RecomposeScopeImpl> hashSetAddPendingInvalidationsLocked2 = addPendingInvalidationsLocked(hashSetAddPendingInvalidationsLocked, obj3, z);
                    IdentityScopeMap<DerivedState<?>> identityScopeMap2 = this.derivedStates;
                    int iFind2 = identityScopeMap2.find(obj3);
                    if (iFind2 >= 0) {
                        IdentityArraySet identityArraySetScopeSetAt2 = identityScopeMap2.scopeSetAt(iFind2);
                        Object[] values3 = identityArraySetScopeSetAt2.getValues();
                        int size3 = identityArraySetScopeSetAt2.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            Object obj4 = values3[i3];
                            AbstractC4492zt.f(obj4, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            hashSetAddPendingInvalidationsLocked2 = addPendingInvalidationsLocked(hashSetAddPendingInvalidationsLocked2, (DerivedState) obj4, z);
                        }
                    }
                    hashSetAddPendingInvalidationsLocked = hashSetAddPendingInvalidationsLocked2;
                }
            }
        }
        if (!z || this.conditionallyInvalidatedScopes.isEmpty()) {
            if (hashSetAddPendingInvalidationsLocked != null) {
                IdentityScopeMap<RecomposeScopeImpl> identityScopeMap3 = this.observations;
                int[] valueOrder = identityScopeMap3.getValueOrder();
                IdentityArraySet<RecomposeScopeImpl>[] scopeSets = identityScopeMap3.getScopeSets();
                Object[] values4 = identityScopeMap3.getValues();
                int size4 = identityScopeMap3.getSize();
                int i4 = 0;
                for (int i5 = 0; i5 < size4; i5++) {
                    int i6 = valueOrder[i5];
                    IdentityArraySet<RecomposeScopeImpl> identityArraySet2 = scopeSets[i6];
                    AbstractC4492zt.e(identityArraySet2);
                    Object[] values5 = identityArraySet2.getValues();
                    int size5 = identityArraySet2.size();
                    int i7 = 0;
                    for (int i8 = 0; i8 < size5; i8++) {
                        Object obj5 = values5[i8];
                        AbstractC4492zt.f(obj5, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                        if (!hashSetAddPendingInvalidationsLocked.contains((RecomposeScopeImpl) obj5)) {
                            if (i7 != i8) {
                                values5[i7] = obj5;
                            }
                            i7++;
                        }
                    }
                    for (int i9 = i7; i9 < size5; i9++) {
                        values5[i9] = null;
                    }
                    ((IdentityArraySet) identityArraySet2).size = i7;
                    if (identityArraySet2.size() > 0) {
                        if (i4 != i5) {
                            int i10 = valueOrder[i4];
                            valueOrder[i4] = i6;
                            valueOrder[i5] = i10;
                        }
                        i4++;
                    }
                }
                int size6 = identityScopeMap3.getSize();
                for (int i11 = i4; i11 < size6; i11++) {
                    values4[valueOrder[i11]] = null;
                }
                identityScopeMap3.setSize(i4);
                cleanUpDerivedStateObservations();
                return;
            }
            return;
        }
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap4 = this.observations;
        int[] valueOrder2 = identityScopeMap4.getValueOrder();
        IdentityArraySet<RecomposeScopeImpl>[] scopeSets2 = identityScopeMap4.getScopeSets();
        Object[] values6 = identityScopeMap4.getValues();
        int size7 = identityScopeMap4.getSize();
        int i12 = 0;
        int i13 = 0;
        while (i12 < size7) {
            int i14 = valueOrder2[i12];
            IdentityArraySet<RecomposeScopeImpl> identityArraySet3 = scopeSets2[i14];
            AbstractC4492zt.e(identityArraySet3);
            Object[] values7 = identityArraySet3.getValues();
            int size8 = identityArraySet3.size();
            int i15 = 0;
            int i16 = 0;
            while (i15 < size8) {
                IdentityArraySet<RecomposeScopeImpl>[] identityArraySetArr = scopeSets2;
                Object obj6 = values7[i15];
                AbstractC4492zt.f(obj6, str);
                int i17 = size7;
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj6;
                String str2 = str;
                if (!this.conditionallyInvalidatedScopes.contains(recomposeScopeImpl) && (hashSetAddPendingInvalidationsLocked == null || !hashSetAddPendingInvalidationsLocked.contains(recomposeScopeImpl))) {
                    if (i16 != i15) {
                        values7[i16] = obj6;
                    }
                    i16++;
                }
                i15++;
                scopeSets2 = identityArraySetArr;
                size7 = i17;
                str = str2;
            }
            IdentityArraySet<RecomposeScopeImpl>[] identityArraySetArr2 = scopeSets2;
            String str3 = str;
            int i18 = size7;
            for (int i19 = i16; i19 < size8; i19++) {
                values7[i19] = null;
            }
            ((IdentityArraySet) identityArraySet3).size = i16;
            if (identityArraySet3.size() > 0) {
                if (i13 != i12) {
                    int i20 = valueOrder2[i13];
                    valueOrder2[i13] = i14;
                    valueOrder2[i12] = i20;
                }
                i13++;
            }
            i12++;
            scopeSets2 = identityArraySetArr2;
            size7 = i18;
            str = str3;
        }
        int size9 = identityScopeMap4.getSize();
        for (int i21 = i13; i21 < size9; i21++) {
            values6[valueOrder2[i21]] = null;
        }
        identityScopeMap4.setSize(i13);
        this.conditionallyInvalidatedScopes.clear();
        cleanUpDerivedStateObservations();
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, InterfaceC0988Vf interfaceC0988Vf, int i, AbstractC0419Di abstractC0419Di) {
        this(compositionContext, applier, (i & 4) != 0 ? null : interfaceC0988Vf);
    }
}
