package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IntMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC0956Ud;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2289gc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C1182Zu;
import defpackage.C2020dG;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.MJ;
import defpackage.NV;
import defpackage.Q5;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ComposerImpl implements Composer {
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private List<InterfaceC0552Gp> changes;
    private int childrenComposing;
    private final ControlledComposition composition;
    private int compositionToken;
    private int compoundKeyHash;
    private List<InterfaceC0552Gp> deferredChanges;
    private final ComposerImpl$derivedStateObserver$1 derivedStateObserver;
    private Stack<Object> downNodes;
    private final IntStack entersStack;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private IntStack groupNodeCountStack;
    private boolean implicitRootStart;
    private Anchor insertAnchor;
    private final List<InterfaceC0552Gp> insertFixups;
    private SlotTable insertTable;
    private final Stack<InterfaceC0552Gp> insertUpFixups;
    private boolean inserting;
    private final Stack<RecomposeScopeImpl> invalidateStack;
    private final List<Invalidation> invalidations;
    private boolean isComposing;
    private boolean isDisposed;
    private List<InterfaceC0552Gp> lateChanges;
    private int[] nodeCountOverrides;
    private HashMap<Integer, Integer> nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private IntStack nodeIndexStack;
    private final CompositionContext parentContext;
    private PersistentCompositionLocalMap parentProvider;
    private Pending pending;
    private final Stack<Pending> pendingStack;
    private int pendingUps;
    private int previousCount;
    private int previousMoveFrom;
    private int previousMoveTo;
    private int previousRemove;
    private PersistentCompositionLocalMap providerCache;
    private final IntMap<PersistentCompositionLocalMap> providerUpdates;
    private boolean providersInvalid;
    private final IntStack providersInvalidStack;
    private SlotReader reader;
    private boolean reusing;
    private int reusingGroup;
    private final SlotTable slotTable;
    private boolean sourceInformationEnabled;
    private boolean startedGroup;
    private final IntStack startedGroups;
    private SlotWriter writer;
    private boolean writerHasAProvider;
    private int writersReaderDelta;

    public static final class CompositionContextHolder implements RememberObserver {
        private final CompositionContextImpl ref;

        public CompositionContextHolder(CompositionContextImpl compositionContextImpl) {
            AbstractC4492zt.h(compositionContextImpl, "ref");
            this.ref = compositionContextImpl;
        }

        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onAbandoned() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onForgotten() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onRemembered() {
        }
    }

    public final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final Set<ComposerImpl> composers = new LinkedHashSet();
        private final MutableState compositionLocalScope$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf(), null, 2, null);
        private final int compoundHashKey;
        private Set<Set<CompositionData>> inspectionTables;

        public CompositionContextImpl(int i, boolean z) {
            this.compoundHashKey = i;
            this.collectingParameterInformation = z;
        }

        private final PersistentCompositionLocalMap getCompositionLocalScope() {
            return (PersistentCompositionLocalMap) this.compositionLocalScope$delegate.getValue();
        }

        public static /* synthetic */ void getRecomposeCoroutineContext$runtime_release$annotations() {
        }

        private final void setCompositionLocalScope(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            this.compositionLocalScope$delegate.setValue(persistentCompositionLocalMap);
        }

        @Override // androidx.compose.runtime.CompositionContext
        @ComposableInferredTarget(scheme = "[0[0]]")
        public void composeInitial$runtime_release(ControlledComposition controlledComposition, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(controlledComposition, "composition");
            AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
            ComposerImpl.this.parentContext.composeInitial$runtime_release(controlledComposition, interfaceC0526Fp);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void deletedMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
            AbstractC4492zt.h(movableContentStateReference, "reference");
            ComposerImpl.this.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
        }

        public final void dispose() {
            if (this.composers.isEmpty()) {
                return;
            }
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                for (ComposerImpl composerImpl : this.composers) {
                    Iterator<Set<CompositionData>> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().remove(composerImpl.slotTable);
                    }
                }
            }
            this.composers.clear();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void doneComposing$runtime_release() {
            ComposerImpl.this.childrenComposing--;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingParameterInformation$runtime_release() {
            return this.collectingParameterInformation;
        }

        public final Set<ComposerImpl> getComposers() {
            return this.composers;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public PersistentCompositionLocalMap getCompositionLocalScope$runtime_release() {
            return getCompositionLocalScope();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public int getCompoundHashKey$runtime_release() {
            return this.compoundHashKey;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public InterfaceC0988Vf getEffectCoroutineContext() {
            return ComposerImpl.this.parentContext.getEffectCoroutineContext();
        }

        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public InterfaceC0988Vf getRecomposeCoroutineContext$runtime_release() {
            return CompositionKt.getRecomposeCoroutineContext(ComposerImpl.this.getComposition());
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void insertMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
            AbstractC4492zt.h(movableContentStateReference, "reference");
            ComposerImpl.this.parentContext.insertMovableContent$runtime_release(movableContentStateReference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidate$runtime_release(ControlledComposition controlledComposition) {
            AbstractC4492zt.h(controlledComposition, "composition");
            ComposerImpl.this.parentContext.invalidate$runtime_release(ComposerImpl.this.getComposition());
            ComposerImpl.this.parentContext.invalidate$runtime_release(controlledComposition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidateScope$runtime_release(RecomposeScopeImpl recomposeScopeImpl) {
            AbstractC4492zt.h(recomposeScopeImpl, "scope");
            ComposerImpl.this.parentContext.invalidateScope$runtime_release(recomposeScopeImpl);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void movableContentStateReleased$runtime_release(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState) {
            AbstractC4492zt.h(movableContentStateReference, "reference");
            AbstractC4492zt.h(movableContentState, "data");
            ComposerImpl.this.parentContext.movableContentStateReleased$runtime_release(movableContentStateReference, movableContentState);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference movableContentStateReference) {
            AbstractC4492zt.h(movableContentStateReference, "reference");
            return ComposerImpl.this.parentContext.movableContentStateResolve$runtime_release(movableContentStateReference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void recordInspectionTable$runtime_release(Set<CompositionData> set) {
            AbstractC4492zt.h(set, "table");
            Set hashSet = this.inspectionTables;
            if (hashSet == null) {
                hashSet = new HashSet();
                this.inspectionTables = hashSet;
            }
            hashSet.add(set);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposer$runtime_release(Composer composer) {
            AbstractC4492zt.h(composer, "composer");
            super.registerComposer$runtime_release((ComposerImpl) composer);
            this.composers.add(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposition$runtime_release(ControlledComposition controlledComposition) {
            AbstractC4492zt.h(controlledComposition, "composition");
            ComposerImpl.this.parentContext.registerComposition$runtime_release(controlledComposition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportRemovedComposition$runtime_release(ControlledComposition controlledComposition) {
            AbstractC4492zt.h(controlledComposition, "composition");
            ComposerImpl.this.parentContext.reportRemovedComposition$runtime_release(controlledComposition);
        }

        public final void setInspectionTables(Set<Set<CompositionData>> set) {
            this.inspectionTables = set;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void startComposing$runtime_release() {
            ComposerImpl.this.childrenComposing++;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposer$runtime_release(Composer composer) {
            AbstractC4492zt.h(composer, "composer");
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    ((Set) it.next()).remove(((ComposerImpl) composer).slotTable);
                }
            }
            NV.a(this.composers).remove(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposition$runtime_release(ControlledComposition controlledComposition) {
            AbstractC4492zt.h(controlledComposition, "composition");
            ComposerImpl.this.parentContext.unregisterComposition$runtime_release(controlledComposition);
        }

        public final void updateCompositionLocalScope(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            AbstractC4492zt.h(persistentCompositionLocalMap, "scope");
            setCompositionLocalScope(persistentCompositionLocalMap);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$createNode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ InterfaceC3588op $factory;
        final /* synthetic */ Anchor $groupAnchor;
        final /* synthetic */ int $insertIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3588op interfaceC3588op, Anchor anchor, int i) {
            super(3);
            this.$factory = interfaceC3588op;
            this.$groupAnchor = anchor;
            this.$insertIndex = i;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "applier");
            AbstractC4492zt.h(slotWriter, "slots");
            AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
            Object objInvoke = this.$factory.invoke();
            slotWriter.updateNode(this.$groupAnchor, objInvoke);
            applier.insertTopDown(this.$insertIndex, objInvoke);
            applier.down(objInvoke);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$createNode$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ Anchor $groupAnchor;
        final /* synthetic */ int $insertIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Anchor anchor, int i) {
            super(3);
            this.$groupAnchor = anchor;
            this.$insertIndex = i;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "applier");
            AbstractC4492zt.h(slotWriter, "slots");
            AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
            Object objNode = slotWriter.node(this.$groupAnchor);
            applier.up();
            applier.insertBottomUp(this.$insertIndex, objNode);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16132 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ Object $node;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16132(Object obj) {
            super(3);
            this.$node = obj;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "<anonymous parameter 0>");
            AbstractC4492zt.h(slotWriter, "<anonymous parameter 1>");
            AbstractC4492zt.h(rememberManager, "rememberManager");
            rememberManager.deactivating((ComposeNodeLifecycleCallback) this.$node);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$3, reason: invalid class name and case insensitive filesystem */
    public static final class C16143 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $group;

        /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0552Gp {
            final /* synthetic */ Object $data;
            final /* synthetic */ int $index;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Object obj, int i) {
                super(3);
                this.$data = obj;
                this.$index = i;
            }

            @Override // defpackage.InterfaceC0552Gp
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
                return FW.a;
            }

            public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                AbstractC4492zt.h(applier, "<anonymous parameter 0>");
                AbstractC4492zt.h(slotWriter, "slots");
                AbstractC4492zt.h(rememberManager, "rememberManager");
                if (!AbstractC4492zt.d(this.$data, slotWriter.slot(slotWriter.getCurrentGroup(), this.$index))) {
                    ComposerKt.composeRuntimeError("Slot table is out of sync");
                    throw new C1182Zu();
                }
                rememberManager.forgetting((RememberObserver) this.$data);
                slotWriter.set(this.$index, Composer.Companion.getEmpty());
            }
        }

        /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$3$2, reason: invalid class name */
        public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
            final /* synthetic */ Object $data;
            final /* synthetic */ int $index;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Object obj, int i) {
                super(3);
                this.$data = obj;
                this.$index = i;
            }

            @Override // defpackage.InterfaceC0552Gp
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
                return FW.a;
            }

            public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                AbstractC4492zt.h(applier, "<anonymous parameter 0>");
                AbstractC4492zt.h(slotWriter, "slots");
                AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
                if (AbstractC4492zt.d(this.$data, slotWriter.slot(slotWriter.getCurrentGroup(), this.$index))) {
                    slotWriter.set(this.$index, Composer.Companion.getEmpty());
                } else {
                    ComposerKt.composeRuntimeError("Slot table is out of sync");
                    throw new C1182Zu();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16143(int i) {
            super(2);
            this.$group = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), obj2);
            return FW.a;
        }

        public final void invoke(int i, Object obj) {
            if (obj instanceof RememberObserver) {
                ComposerImpl.this.reader.reposition(this.$group);
                ComposerImpl.recordSlotTableOperation$default(ComposerImpl.this, false, new AnonymousClass1(obj, i), 1, null);
            } else if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).release();
                ComposerImpl.this.reader.reposition(this.$group);
                ComposerImpl.recordSlotTableOperation$default(ComposerImpl.this, false, new AnonymousClass2(obj, i), 1, null);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$invokeMovableContentLambda$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ MovableContent<Object> $content;
        final /* synthetic */ Object $parameter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MovableContent<Object> movableContent, Object obj) {
            super(2);
            this.$content = movableContent;
            this.$parameter = obj;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        @Composable
        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(316014703, i, -1, "androidx.compose.runtime.ComposerImpl.invokeMovableContentLambda.<anonymous> (Composer.kt:2946)");
            }
            this.$content.getContent().invoke(this.$parameter, composer, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$realizeDowns$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16151 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ Object[] $nodes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16151(Object[] objArr) {
            super(3);
            this.$nodes = objArr;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "applier");
            AbstractC4492zt.h(slotWriter, "<anonymous parameter 1>");
            AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
            int length = this.$nodes.length;
            for (int i = 0; i < length; i++) {
                applier.down(this.$nodes[i]);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$realizeMovement$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16161 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $count;
        final /* synthetic */ int $removeIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16161(int i, int i2) {
            super(3);
            this.$removeIndex = i;
            this.$count = i2;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "applier");
            AbstractC4492zt.h(slotWriter, "<anonymous parameter 1>");
            AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
            applier.remove(this.$removeIndex, this.$count);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$realizeMovement$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16172 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $count;
        final /* synthetic */ int $from;
        final /* synthetic */ int $to;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16172(int i, int i2, int i3) {
            super(3);
            this.$from = i;
            this.$to = i2;
            this.$count = i3;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "applier");
            AbstractC4492zt.h(slotWriter, "<anonymous parameter 1>");
            AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
            applier.move(this.$from, this.$to, this.$count);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$realizeOperationLocation$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16182 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $distance;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16182(int i) {
            super(3);
            this.$distance = i;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "<anonymous parameter 0>");
            AbstractC4492zt.h(slotWriter, "slots");
            AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
            slotWriter.advanceBy(this.$distance);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$realizeUps$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16191 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $count;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16191(int i) {
            super(3);
            this.$count = i;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "applier");
            AbstractC4492zt.h(slotWriter, "<anonymous parameter 1>");
            AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
            int i = this.$count;
            for (int i2 = 0; i2 < i; i2++) {
                applier.up();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$recordInsert$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16201 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ Anchor $anchor;
        final /* synthetic */ SlotTable $insertTable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16201(SlotTable slotTable, Anchor anchor) {
            super(3);
            this.$insertTable = slotTable;
            this.$anchor = anchor;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "<anonymous parameter 0>");
            AbstractC4492zt.h(slotWriter, "slots");
            AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
            slotWriter.beginInsert();
            SlotTable slotTable = this.$insertTable;
            slotWriter.moveFrom(slotTable, this.$anchor.toIndexFor(slotTable), false);
            slotWriter.endInsert();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$recordInsert$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16212 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ Anchor $anchor;
        final /* synthetic */ List<InterfaceC0552Gp> $fixups;
        final /* synthetic */ SlotTable $insertTable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16212(SlotTable slotTable, Anchor anchor, List<InterfaceC0552Gp> list) {
            super(3);
            this.$insertTable = slotTable;
            this.$anchor = anchor;
            this.$fixups = list;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "applier");
            AbstractC4492zt.h(slotWriter, "slots");
            AbstractC4492zt.h(rememberManager, "rememberManager");
            SlotTable slotTable = this.$insertTable;
            List<InterfaceC0552Gp> list = this.$fixups;
            SlotWriter slotWriterOpenWriter = slotTable.openWriter();
            try {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).invoke(applier, slotWriterOpenWriter, rememberManager);
                }
                FW fw = FW.a;
                slotWriterOpenWriter.close();
                slotWriter.beginInsert();
                SlotTable slotTable2 = this.$insertTable;
                slotWriter.moveFrom(slotTable2, this.$anchor.toIndexFor(slotTable2), false);
                slotWriter.endInsert();
            } catch (Throwable th) {
                slotWriterOpenWriter.close();
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$recordSideEffect$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16221 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ InterfaceC3588op $effect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16221(InterfaceC3588op interfaceC3588op) {
            super(3);
            this.$effect = interfaceC3588op;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "<anonymous parameter 0>");
            AbstractC4492zt.h(slotWriter, "<anonymous parameter 1>");
            AbstractC4492zt.h(rememberManager, "rememberManager");
            rememberManager.sideEffect(this.$effect);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$recordSlotEditing$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16231 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ Anchor $anchor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16231(Anchor anchor) {
            super(3);
            this.$anchor = anchor;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "<anonymous parameter 0>");
            AbstractC4492zt.h(slotWriter, "slots");
            AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
            slotWriter.ensureStarted(this.$anchor);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$startReaderGroup$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16241 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ Object $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16241(Object obj) {
            super(3);
            this.$data = obj;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "<anonymous parameter 0>");
            AbstractC4492zt.h(slotWriter, "slots");
            AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
            slotWriter.updateAux(this.$data);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$updateValue$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16251 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ Object $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16251(Object obj) {
            super(3);
            this.$value = obj;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "<anonymous parameter 0>");
            AbstractC4492zt.h(slotWriter, "<anonymous parameter 1>");
            AbstractC4492zt.h(rememberManager, "rememberManager");
            rememberManager.remembering((RememberObserver) this.$value);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$updateValue$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16262 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $groupSlotIndex;
        final /* synthetic */ Object $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16262(Object obj, int i) {
            super(3);
            this.$value = obj;
            this.$groupSlotIndex = i;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "<anonymous parameter 0>");
            AbstractC4492zt.h(slotWriter, "slots");
            AbstractC4492zt.h(rememberManager, "rememberManager");
            Object obj = this.$value;
            if (obj instanceof RememberObserver) {
                rememberManager.remembering((RememberObserver) obj);
            }
            Object obj2 = slotWriter.set(this.$groupSlotIndex, this.$value);
            if (obj2 instanceof RememberObserver) {
                rememberManager.forgetting((RememberObserver) obj2);
            } else if (obj2 instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj2).release();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.ComposerImpl$useNode$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16272 extends AbstractC2233fv implements InterfaceC0552Gp {
        public static final C16272 INSTANCE = new C16272();

        public C16272() {
            super(3);
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
            return FW.a;
        }

        public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            AbstractC4492zt.h(applier, "applier");
            AbstractC4492zt.h(slotWriter, "<anonymous parameter 1>");
            AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
            Object current = applier.getCurrent();
            AbstractC4492zt.f(current, "null cannot be cast to non-null type androidx.compose.runtime.ComposeNodeLifecycleCallback");
            ((ComposeNodeLifecycleCallback) current).onReuse();
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.runtime.ComposerImpl$derivedStateObserver$1] */
    public ComposerImpl(Applier<?> applier, CompositionContext compositionContext, SlotTable slotTable, Set<RememberObserver> set, List<InterfaceC0552Gp> list, List<InterfaceC0552Gp> list2, ControlledComposition controlledComposition) {
        AbstractC4492zt.h(applier, "applier");
        AbstractC4492zt.h(compositionContext, "parentContext");
        AbstractC4492zt.h(slotTable, "slotTable");
        AbstractC4492zt.h(set, "abandonSet");
        AbstractC4492zt.h(list, "changes");
        AbstractC4492zt.h(list2, "lateChanges");
        AbstractC4492zt.h(controlledComposition, "composition");
        this.applier = applier;
        this.parentContext = compositionContext;
        this.slotTable = slotTable;
        this.abandonSet = set;
        this.changes = list;
        this.lateChanges = list2;
        this.composition = controlledComposition;
        this.pendingStack = new Stack<>();
        this.nodeIndexStack = new IntStack();
        this.groupNodeCountStack = new IntStack();
        this.invalidations = new ArrayList();
        this.entersStack = new IntStack();
        this.parentProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
        this.providerUpdates = new IntMap<>(0, 1, null);
        this.providersInvalidStack = new IntStack();
        this.reusingGroup = -1;
        this.sourceInformationEnabled = true;
        this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.ComposerImpl$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                AbstractC4492zt.h(derivedState, "derivedState");
                this.this$0.childrenComposing--;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                AbstractC4492zt.h(derivedState, "derivedState");
                this.this$0.childrenComposing++;
            }
        };
        this.invalidateStack = new Stack<>();
        SlotReader slotReaderOpenReader = slotTable.openReader();
        slotReaderOpenReader.close();
        this.reader = slotReaderOpenReader;
        SlotTable slotTable2 = new SlotTable();
        this.insertTable = slotTable2;
        SlotWriter slotWriterOpenWriter = slotTable2.openWriter();
        slotWriterOpenWriter.close();
        this.writer = slotWriterOpenWriter;
        SlotReader slotReaderOpenReader2 = this.insertTable.openReader();
        try {
            Anchor anchor = slotReaderOpenReader2.anchor(0);
            slotReaderOpenReader2.close();
            this.insertAnchor = anchor;
            this.insertFixups = new ArrayList();
            this.downNodes = new Stack<>();
            this.implicitRootStart = true;
            this.startedGroups = new IntStack();
            this.insertUpFixups = new Stack<>();
            this.previousRemove = -1;
            this.previousMoveFrom = -1;
            this.previousMoveTo = -1;
        } catch (Throwable th) {
            slotReaderOpenReader2.close();
            throw th;
        }
    }

    private final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.clear();
        this.nodeIndexStack.clear();
        this.groupNodeCountStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates.clear();
        if (!this.reader.getClosed()) {
            this.reader.close();
        }
        if (!this.writer.getClosed()) {
            this.writer.close();
        }
        this.insertFixups.clear();
        createFreshInsertTable();
        this.compoundKeyHash = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
        this.reusingGroup = -1;
    }

    private final void addRecomposeScope() {
        RecomposeScopeImpl recomposeScopeImpl;
        if (getInserting()) {
            ControlledComposition composition = getComposition();
            AbstractC4492zt.f(composition, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            RecomposeScopeImpl recomposeScopeImpl2 = new RecomposeScopeImpl((CompositionImpl) composition);
            this.invalidateStack.push(recomposeScopeImpl2);
            updateValue(recomposeScopeImpl2);
            recomposeScopeImpl2.start(this.compositionToken);
            return;
        }
        Invalidation invalidationRemoveLocation = ComposerKt.removeLocation(this.invalidations, this.reader.getParent());
        Object next = this.reader.next();
        if (AbstractC4492zt.d(next, Composer.Companion.getEmpty())) {
            ControlledComposition composition2 = getComposition();
            AbstractC4492zt.f(composition2, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            recomposeScopeImpl = new RecomposeScopeImpl((CompositionImpl) composition2);
            updateValue(recomposeScopeImpl);
        } else {
            AbstractC4492zt.f(next, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
            recomposeScopeImpl = (RecomposeScopeImpl) next;
        }
        recomposeScopeImpl.setRequiresRecompose(invalidationRemoveLocation != null);
        this.invalidateStack.push(recomposeScopeImpl);
        recomposeScopeImpl.start(this.compositionToken);
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.writersReaderDelta = 0;
        this.compoundKeyHash = 0;
        this.nodeExpected = false;
        this.startedGroup = false;
        this.startedGroups.clear();
        this.invalidateStack.clear();
        clearUpdatedNodeCounts();
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final int compoundKeyOf(int i, int i2, int i3) {
        if (i == i2) {
            return i3;
        }
        int iGroupCompoundKeyPart = groupCompoundKeyPart(this.reader, i);
        return iGroupCompoundKeyPart == 126665345 ? iGroupCompoundKeyPart : Integer.rotateLeft(compoundKeyOf(this.reader.parent(i), i2, i3), 3) ^ iGroupCompoundKeyPart;
    }

    private final void createFreshInsertTable() {
        ComposerKt.runtimeCheck(this.writer.getClosed());
        SlotTable slotTable = new SlotTable();
        this.insertTable = slotTable;
        SlotWriter slotWriterOpenWriter = slotTable.openWriter();
        slotWriterOpenWriter.close();
        this.writer = slotWriterOpenWriter;
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap persistentCompositionLocalMap = this.providerCache;
        return persistentCompositionLocalMap != null ? persistentCompositionLocalMap : currentCompositionLocalScope(this.reader.getParent());
    }

    private final void doCompose(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap, InterfaceC0526Fp interfaceC0526Fp) {
        if (this.isComposing) {
            ComposerKt.composeRuntimeError("Reentrant composition is not supported");
            throw new C1182Zu();
        }
        Object objBeginSection = Trace.INSTANCE.beginSection("Compose:recompose");
        try {
            this.compositionToken = SnapshotKt.currentSnapshot().getId();
            this.providerUpdates.clear();
            int size = identityArrayMap.getSize();
            for (int i = 0; i < size; i++) {
                Object obj = identityArrayMap.getKeys()[i];
                AbstractC4492zt.f(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                IdentityArraySet identityArraySet = (IdentityArraySet) identityArrayMap.getValues()[i];
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                Anchor anchor = recomposeScopeImpl.getAnchor();
                if (anchor == null) {
                    Trace.INSTANCE.endSection(objBeginSection);
                    return;
                }
                this.invalidations.add(new Invalidation(recomposeScopeImpl, anchor.getLocation$runtime_release(), identityArraySet));
            }
            List<Invalidation> list = this.invalidations;
            if (list.size() > 1) {
                AbstractC2289gc.B(list, new Comparator() { // from class: androidx.compose.runtime.ComposerImpl$doCompose$lambda$38$$inlined$sortBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return AbstractC0956Ud.d(Integer.valueOf(((Invalidation) t).getLocation()), Integer.valueOf(((Invalidation) t2).getLocation()));
                    }
                });
            }
            this.nodeIndex = 0;
            this.isComposing = true;
            try {
                startRoot();
                Object objNextSlot = nextSlot();
                if (objNextSlot != interfaceC0526Fp && interfaceC0526Fp != null) {
                    updateValue(interfaceC0526Fp);
                }
                ComposerImpl$derivedStateObserver$1 composerImpl$derivedStateObserver$1 = this.derivedStateObserver;
                MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
                try {
                    mutableVectorDerivedStateObservers.add(composerImpl$derivedStateObserver$1);
                    if (interfaceC0526Fp != null) {
                        startGroup(200, ComposerKt.getInvocation());
                        ActualJvm_jvmKt.invokeComposable(this, interfaceC0526Fp);
                        endGroup();
                    } else if (!(this.forciblyRecompose || this.providersInvalid) || objNextSlot == null || AbstractC4492zt.d(objNextSlot, Composer.Companion.getEmpty())) {
                        skipCurrentGroup();
                    } else {
                        startGroup(200, ComposerKt.getInvocation());
                        ActualJvm_jvmKt.invokeComposable(this, (InterfaceC0526Fp) NV.d(objNextSlot, 2));
                        endGroup();
                    }
                    mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                    endRoot();
                    this.isComposing = false;
                    this.invalidations.clear();
                    FW fw = FW.a;
                    Trace.INSTANCE.endSection(objBeginSection);
                } catch (Throwable th) {
                    mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                    throw th;
                }
            } catch (Throwable th2) {
                this.isComposing = false;
                this.invalidations.clear();
                abortRoot();
                throw th2;
            }
        } catch (Throwable th3) {
            Trace.INSTANCE.endSection(objBeginSection);
            throw th3;
        }
    }

    private final void doRecordDownsFor(int i, int i2) {
        if (i <= 0 || i == i2) {
            return;
        }
        doRecordDownsFor(this.reader.parent(i), i2);
        if (this.reader.isNode(i)) {
            recordDown(nodeAt(this.reader, i));
        }
    }

    private final void end(boolean z) {
        if (getInserting()) {
            int parent = this.writer.getParent();
            updateCompoundKeyWhenWeExitGroup(this.writer.groupKey(parent), this.writer.groupObjectKey(parent), this.writer.groupAux(parent));
        } else {
            int parent2 = this.reader.getParent();
            updateCompoundKeyWhenWeExitGroup(this.reader.groupKey(parent2), this.reader.groupObjectKey(parent2), this.reader.groupAux(parent2));
        }
        int i = this.groupNodeCount;
        Pending pending = this.pending;
        int i2 = 0;
        if (pending != null && pending.getKeyInfos().size() > 0) {
            List<KeyInfo> keyInfos = pending.getKeyInfos();
            List<KeyInfo> used = pending.getUsed();
            Set setFastToSet = ListUtilsKt.fastToSet(used);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = used.size();
            int size2 = keyInfos.size();
            int i3 = 0;
            int i4 = 0;
            int iUpdatedNodeCountOf = 0;
            while (i3 < size2) {
                KeyInfo keyInfo = keyInfos.get(i3);
                if (setFastToSet.contains(keyInfo)) {
                    if (!linkedHashSet.contains(keyInfo)) {
                        if (i4 < size) {
                            KeyInfo keyInfo2 = used.get(i4);
                            if (keyInfo2 != keyInfo) {
                                int iNodePositionOf = pending.nodePositionOf(keyInfo2);
                                linkedHashSet.add(keyInfo2);
                                if (iNodePositionOf != iUpdatedNodeCountOf) {
                                    int iUpdatedNodeCountOf2 = pending.updatedNodeCountOf(keyInfo2);
                                    recordMoveNode(pending.getStartIndex() + iNodePositionOf, iUpdatedNodeCountOf + pending.getStartIndex(), iUpdatedNodeCountOf2);
                                    pending.registerMoveNode(iNodePositionOf, iUpdatedNodeCountOf, iUpdatedNodeCountOf2);
                                }
                            } else {
                                i3++;
                            }
                            i4++;
                            iUpdatedNodeCountOf += pending.updatedNodeCountOf(keyInfo2);
                            used = used;
                        }
                    }
                    i2 = 0;
                } else {
                    recordRemoveNode(pending.nodePositionOf(keyInfo) + pending.getStartIndex(), keyInfo.getNodes());
                    pending.updateNodeCount(keyInfo.getLocation(), i2);
                    recordReaderMoving(keyInfo.getLocation());
                    this.reader.reposition(keyInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    ComposerKt.removeRange(this.invalidations, keyInfo.getLocation(), keyInfo.getLocation() + this.reader.groupSize(keyInfo.getLocation()));
                }
                i3++;
                i2 = 0;
            }
            realizeMovement();
            if (keyInfos.size() > 0) {
                recordReaderMoving(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        int i5 = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int currentGroup = this.reader.getCurrentGroup();
            recordDelete();
            recordRemoveNode(i5, this.reader.skipGroup());
            ComposerKt.removeRange(this.invalidations, currentGroup, this.reader.getCurrentGroup());
        }
        boolean inserting = getInserting();
        if (inserting) {
            if (z) {
                registerInsertUpFixup();
                i = 1;
            }
            this.reader.endEmpty();
            int parent3 = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int iInsertedGroupVirtualIndex = insertedGroupVirtualIndex(parent3);
                this.writer.endInsert();
                this.writer.close();
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(iInsertedGroupVirtualIndex, 0);
                    updateNodeCountOverrides(iInsertedGroupVirtualIndex, i);
                }
            }
        } else {
            if (z) {
                recordUp();
            }
            recordEndGroup();
            int parent4 = this.reader.getParent();
            if (i != updatedNodeCount(parent4)) {
                updateNodeCountOverrides(parent4, i);
            }
            if (z) {
                i = 1;
            }
            this.reader.endGroup();
            realizeMovement();
        }
        exitGroup(i, inserting);
    }

    private final void endGroup() {
        end(false);
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime_release();
        endGroup();
        recordEndRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            SlotWriter slotWriterOpenWriter = this.insertTable.openWriter();
            this.writer = slotWriterOpenWriter;
            slotWriterOpenWriter.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void enterGroup(boolean z, Pending pending) {
        this.pendingStack.push(this.pending);
        this.pending = pending;
        this.nodeIndexStack.push(this.nodeIndex);
        if (z) {
            this.nodeIndex = 0;
        }
        this.groupNodeCountStack.push(this.groupNodeCount);
        this.groupNodeCount = 0;
    }

    private final void exitGroup(int i, boolean z) {
        Pending pendingPop = this.pendingStack.pop();
        if (pendingPop != null && !z) {
            pendingPop.setGroupIndex(pendingPop.getGroupIndex() + 1);
        }
        this.pending = pendingPop;
        this.nodeIndex = this.nodeIndexStack.pop() + i;
        this.groupNodeCount = this.groupNodeCountStack.pop() + i;
    }

    private final void finalizeCompose() {
        realizeUps();
        if (!this.pendingStack.isEmpty()) {
            ComposerKt.composeRuntimeError("Start/end imbalance");
            throw new C1182Zu();
        }
        if (this.startedGroups.isEmpty()) {
            cleanUpCompose();
        } else {
            ComposerKt.composeRuntimeError("Missed recording an endGroup()");
            throw new C1182Zu();
        }
    }

    @InternalComposeApi
    public static /* synthetic */ void getCompoundKeyHash$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    private final Object getNode(SlotReader slotReader) {
        return slotReader.node(slotReader.getParent());
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    private final int groupCompoundKeyPart(SlotReader slotReader, int i) {
        Object objGroupAux;
        if (slotReader.hasObjectKey(i)) {
            Object objGroupObjectKey = slotReader.groupObjectKey(i);
            if (objGroupObjectKey == null) {
                return 0;
            }
            if (objGroupObjectKey instanceof Enum) {
                return ((Enum) objGroupObjectKey).ordinal();
            }
            return objGroupObjectKey instanceof MovableContent ? MovableContentKt.movableContentKey : objGroupObjectKey.hashCode();
        }
        int iGroupKey = slotReader.groupKey(i);
        if (iGroupKey == 207 && (objGroupAux = slotReader.groupAux(i)) != null && !AbstractC4492zt.d(objGroupAux, Composer.Companion.getEmpty())) {
            iGroupKey = objGroupAux.hashCode();
        }
        return iGroupKey;
    }

    private final void insertMovableContentGuarded(List<C2020dG> list) {
        SlotTable slotTable$runtime_release;
        Anchor anchor$runtime_release;
        List list2;
        SlotTable slotTable$runtime_release2;
        List<InterfaceC0552Gp> list3 = this.lateChanges;
        List list4 = this.changes;
        try {
            this.changes = list3;
            record(ComposerKt.resetSlotsInstance);
            int size = list.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                C2020dG c2020dG = list.get(i2);
                MovableContentStateReference movableContentStateReference = (MovableContentStateReference) c2020dG.a();
                MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) c2020dG.b();
                Anchor anchor$runtime_release2 = movableContentStateReference.getAnchor$runtime_release();
                int iAnchorIndex = movableContentStateReference.getSlotTable$runtime_release().anchorIndex(anchor$runtime_release2);
                MJ mj = new MJ();
                realizeUps();
                record(new ComposerImpl$insertMovableContentGuarded$1$1$1(mj, anchor$runtime_release2));
                if (movableContentStateReference2 == null) {
                    if (AbstractC4492zt.d(movableContentStateReference.getSlotTable$runtime_release(), this.insertTable)) {
                        createFreshInsertTable();
                    }
                    SlotReader slotReaderOpenReader = movableContentStateReference.getSlotTable$runtime_release().openReader();
                    try {
                        slotReaderOpenReader.reposition(iAnchorIndex);
                        this.writersReaderDelta = iAnchorIndex;
                        ArrayList arrayList = new ArrayList();
                        recomposeMovableContent$default(this, null, null, null, null, new ComposerImpl$insertMovableContentGuarded$1$1$2$1(this, arrayList, slotReaderOpenReader, movableContentStateReference), 15, null);
                        if (!arrayList.isEmpty()) {
                            record(new ComposerImpl$insertMovableContentGuarded$1$1$2$2(mj, arrayList));
                        }
                        FW fw = FW.a;
                        slotReaderOpenReader.close();
                    } catch (Throwable th) {
                        slotReaderOpenReader.close();
                        throw th;
                    }
                } else {
                    MovableContentState movableContentStateMovableContentStateResolve$runtime_release = this.parentContext.movableContentStateResolve$runtime_release(movableContentStateReference2);
                    if (movableContentStateMovableContentStateResolve$runtime_release == null || (slotTable$runtime_release = movableContentStateMovableContentStateResolve$runtime_release.getSlotTable$runtime_release()) == null) {
                        slotTable$runtime_release = movableContentStateReference2.getSlotTable$runtime_release();
                    }
                    if (movableContentStateMovableContentStateResolve$runtime_release == null || (slotTable$runtime_release2 = movableContentStateMovableContentStateResolve$runtime_release.getSlotTable$runtime_release()) == null || (anchor$runtime_release = slotTable$runtime_release2.anchor(i)) == null) {
                        anchor$runtime_release = movableContentStateReference2.getAnchor$runtime_release();
                    }
                    List listCollectNodesFrom = ComposerKt.collectNodesFrom(slotTable$runtime_release, anchor$runtime_release);
                    if (!listCollectNodesFrom.isEmpty()) {
                        record(new ComposerImpl$insertMovableContentGuarded$1$1$3(mj, listCollectNodesFrom));
                        if (AbstractC4492zt.d(movableContentStateReference.getSlotTable$runtime_release(), this.slotTable)) {
                            int iAnchorIndex2 = this.slotTable.anchorIndex(anchor$runtime_release2);
                            updateNodeCount(iAnchorIndex2, updatedNodeCount(iAnchorIndex2) + listCollectNodesFrom.size());
                        }
                    }
                    record(new ComposerImpl$insertMovableContentGuarded$1$1$4(movableContentStateMovableContentStateResolve$runtime_release, this, movableContentStateReference2, movableContentStateReference));
                    SlotReader slotReaderOpenReader2 = slotTable$runtime_release.openReader();
                    try {
                        SlotReader slotReader = this.reader;
                        int[] iArr = this.nodeCountOverrides;
                        this.nodeCountOverrides = null;
                        try {
                            this.reader = slotReaderOpenReader2;
                            int iAnchorIndex3 = slotTable$runtime_release.anchorIndex(anchor$runtime_release);
                            slotReaderOpenReader2.reposition(iAnchorIndex3);
                            this.writersReaderDelta = iAnchorIndex3;
                            ArrayList arrayList2 = new ArrayList();
                            List list5 = this.changes;
                            try {
                                this.changes = arrayList2;
                                list2 = list5;
                                try {
                                    recomposeMovableContent(movableContentStateReference2.getComposition$runtime_release(), movableContentStateReference.getComposition$runtime_release(), Integer.valueOf(slotReaderOpenReader2.getCurrentGroup()), movableContentStateReference2.getInvalidations$runtime_release(), new ComposerImpl$insertMovableContentGuarded$1$1$5$1$1$1(this, movableContentStateReference));
                                    FW fw2 = FW.a;
                                    this.changes = list2;
                                    if (!arrayList2.isEmpty()) {
                                        record(new ComposerImpl$insertMovableContentGuarded$1$1$5$1$2(mj, arrayList2));
                                    }
                                    this.reader = slotReader;
                                    this.nodeCountOverrides = iArr;
                                    slotReaderOpenReader2.close();
                                } catch (Throwable th2) {
                                    th = th2;
                                    this.changes = list2;
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                list2 = list5;
                            }
                        } catch (Throwable th4) {
                            this.reader = slotReader;
                            this.nodeCountOverrides = iArr;
                            throw th4;
                        }
                    } catch (Throwable th5) {
                        slotReaderOpenReader2.close();
                        throw th5;
                    }
                }
                record(ComposerKt.skipToGroupEndInstance);
                i2++;
                i = 0;
            }
            record(ComposerImpl$insertMovableContentGuarded$1$2.INSTANCE);
            this.writersReaderDelta = 0;
            FW fw3 = FW.a;
            this.changes = list4;
        } catch (Throwable th6) {
            this.changes = list4;
            throw th6;
        }
    }

    private static final int insertMovableContentGuarded$currentNodeIndex(SlotWriter slotWriter) {
        int currentGroup = slotWriter.getCurrentGroup();
        int parent = slotWriter.getParent();
        while (parent >= 0 && !slotWriter.isNode(parent)) {
            parent = slotWriter.parent(parent);
        }
        int iGroupSize = parent + 1;
        int iNodeCount = 0;
        while (iGroupSize < currentGroup) {
            if (slotWriter.indexInGroup(currentGroup, iGroupSize)) {
                if (slotWriter.isNode(iGroupSize)) {
                    iNodeCount = 0;
                }
                iGroupSize++;
            } else {
                iNodeCount += slotWriter.isNode(iGroupSize) ? 1 : slotWriter.nodeCount(iGroupSize);
                iGroupSize += slotWriter.groupSize(iGroupSize);
            }
        }
        return iNodeCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int insertMovableContentGuarded$positionToInsert(SlotWriter slotWriter, Anchor anchor, Applier<Object> applier) {
        int iAnchorIndex = slotWriter.anchorIndex(anchor);
        ComposerKt.runtimeCheck(slotWriter.getCurrentGroup() < iAnchorIndex);
        insertMovableContentGuarded$positionToParentOf(slotWriter, applier, iAnchorIndex);
        int iInsertMovableContentGuarded$currentNodeIndex = insertMovableContentGuarded$currentNodeIndex(slotWriter);
        while (slotWriter.getCurrentGroup() < iAnchorIndex) {
            if (slotWriter.indexInCurrentGroup(iAnchorIndex)) {
                if (slotWriter.isNode()) {
                    applier.down(slotWriter.node(slotWriter.getCurrentGroup()));
                    iInsertMovableContentGuarded$currentNodeIndex = 0;
                }
                slotWriter.startGroup();
            } else {
                iInsertMovableContentGuarded$currentNodeIndex += slotWriter.skipGroup();
            }
        }
        ComposerKt.runtimeCheck(slotWriter.getCurrentGroup() == iAnchorIndex);
        return iInsertMovableContentGuarded$currentNodeIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertMovableContentGuarded$positionToParentOf(SlotWriter slotWriter, Applier<Object> applier, int i) {
        while (!slotWriter.indexInParent(i)) {
            slotWriter.skipToGroupEnd();
            if (slotWriter.isNode(slotWriter.getParent())) {
                applier.up();
            }
            slotWriter.endGroup();
        }
    }

    private final int insertedGroupVirtualIndex(int i) {
        return (-2) - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeMovableContentLambda(MovableContent<Object> movableContent, PersistentCompositionLocalMap persistentCompositionLocalMap, Object obj, boolean z) {
        startMovableGroup(MovableContentKt.movableContentKey, movableContent);
        changed(obj);
        int compoundKeyHash = getCompoundKeyHash();
        try {
            this.compoundKeyHash = MovableContentKt.movableContentKey;
            boolean z2 = false;
            if (getInserting()) {
                SlotWriter.markGroup$default(this.writer, 0, 1, null);
            }
            if (!getInserting() && !AbstractC4492zt.d(this.reader.getGroupAux(), persistentCompositionLocalMap)) {
                z2 = true;
            }
            if (z2) {
                this.providerUpdates.set(this.reader.getCurrentGroup(), persistentCompositionLocalMap);
            }
            m2630startBaiHCIY(202, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m2643getGroupULZAiWs(), persistentCompositionLocalMap);
            if (!getInserting() || z) {
                boolean z3 = this.providersInvalid;
                this.providersInvalid = z2;
                ActualJvm_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(316014703, true, new AnonymousClass1(movableContent, obj)));
                this.providersInvalid = z3;
            } else {
                this.writerHasAProvider = true;
                this.providerCache = null;
                SlotWriter slotWriter = this.writer;
                this.parentContext.insertMovableContent$runtime_release(new MovableContentStateReference(movableContent, obj, getComposition(), this.insertTable, slotWriter.anchor(slotWriter.parent(slotWriter.getParent())), AbstractC1886cc.m(), currentCompositionLocalScope()));
            }
        } finally {
            endGroup();
            this.compoundKeyHash = compoundKeyHash;
            endMovableGroup();
        }
    }

    private final Object nodeAt(SlotReader slotReader, int i) {
        return slotReader.node(i);
    }

    private final int nodeIndexOf(int i, int i2, int i3, int i4) {
        int iParent = this.reader.parent(i2);
        while (iParent != i3 && !this.reader.isNode(iParent)) {
            iParent = this.reader.parent(iParent);
        }
        if (this.reader.isNode(iParent)) {
            i4 = 0;
        }
        if (iParent == i2) {
            return i4;
        }
        int iUpdatedNodeCount = (updatedNodeCount(iParent) - this.reader.nodeCount(i2)) + i4;
        loop1: while (i4 < iUpdatedNodeCount && iParent != i) {
            iParent++;
            while (iParent < i) {
                int iGroupSize = this.reader.groupSize(iParent) + iParent;
                if (i >= iGroupSize) {
                    i4 += updatedNodeCount(iParent);
                    iParent = iGroupSize;
                }
            }
            break loop1;
        }
        return i4;
    }

    private final void realizeDowns(Object[] objArr) {
        record(new C16151(objArr));
    }

    private final void realizeMovement() {
        int i = this.previousCount;
        this.previousCount = 0;
        if (i > 0) {
            int i2 = this.previousRemove;
            if (i2 >= 0) {
                this.previousRemove = -1;
                recordApplierOperation(new C16161(i2, i));
                return;
            }
            int i3 = this.previousMoveFrom;
            this.previousMoveFrom = -1;
            int i4 = this.previousMoveTo;
            this.previousMoveTo = -1;
            recordApplierOperation(new C16172(i3, i4, i));
        }
    }

    private final void realizeOperationLocation(boolean z) {
        int parent = z ? this.reader.getParent() : this.reader.getCurrentGroup();
        int i = parent - this.writersReaderDelta;
        if (!(i >= 0)) {
            ComposerKt.composeRuntimeError("Tried to seek backward");
            throw new C1182Zu();
        }
        if (i > 0) {
            record(new C16182(i));
            this.writersReaderDelta = parent;
        }
    }

    public static /* synthetic */ void realizeOperationLocation$default(ComposerImpl composerImpl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerImpl.realizeOperationLocation(z);
    }

    private final void realizeUps() {
        int i = this.pendingUps;
        if (i > 0) {
            this.pendingUps = 0;
            record(new C16191(i));
        }
    }

    private final <R> R recomposeMovableContent(ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List<C2020dG> list, InterfaceC3588op interfaceC3588op) {
        R r;
        boolean z = this.implicitRootStart;
        boolean z2 = this.isComposing;
        int i = this.nodeIndex;
        try {
            this.implicitRootStart = false;
            this.isComposing = true;
            this.nodeIndex = 0;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                C2020dG c2020dG = list.get(i2);
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) c2020dG.a();
                IdentityArraySet identityArraySet = (IdentityArraySet) c2020dG.b();
                if (identityArraySet != null) {
                    Object[] values = identityArraySet.getValues();
                    int size2 = identityArraySet.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        Object obj = values[i3];
                        AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                        tryImminentInvalidation$runtime_release(recomposeScopeImpl, obj);
                    }
                } else {
                    tryImminentInvalidation$runtime_release(recomposeScopeImpl, null);
                }
            }
            if (controlledComposition != null) {
                r = (R) controlledComposition.delegateInvalidations(controlledComposition2, num != null ? num.intValue() : -1, interfaceC3588op);
                if (r == null) {
                }
                return r;
            }
            r = (R) interfaceC3588op.invoke();
            return r;
        } finally {
            this.implicitRootStart = z;
            this.isComposing = z2;
            this.nodeIndex = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object recomposeMovableContent$default(ComposerImpl composerImpl, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, InterfaceC3588op interfaceC3588op, int i, Object obj) {
        ControlledComposition controlledComposition3 = (i & 1) != 0 ? null : controlledComposition;
        ControlledComposition controlledComposition4 = (i & 2) != 0 ? null : controlledComposition2;
        Integer num2 = (i & 4) != 0 ? null : num;
        if ((i & 8) != 0) {
            list = AbstractC1886cc.m();
        }
        return composerImpl.recomposeMovableContent(controlledComposition3, controlledComposition4, num2, list, interfaceC3588op);
    }

    private final void recomposeToGroupEnd() {
        boolean z = this.isComposing;
        this.isComposing = true;
        int parent = this.reader.getParent();
        int iGroupSize = this.reader.groupSize(parent) + parent;
        int i = this.nodeIndex;
        int compoundKeyHash = getCompoundKeyHash();
        int i2 = this.groupNodeCount;
        Invalidation invalidationFirstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), iGroupSize);
        boolean z2 = false;
        int i3 = parent;
        while (invalidationFirstInRange != null) {
            int location = invalidationFirstInRange.getLocation();
            ComposerKt.removeLocation(this.invalidations, location);
            if (invalidationFirstInRange.isInvalid()) {
                this.reader.reposition(location);
                int currentGroup = this.reader.getCurrentGroup();
                recordUpsAndDowns(i3, currentGroup, parent);
                this.nodeIndex = nodeIndexOf(location, currentGroup, parent, i);
                this.compoundKeyHash = compoundKeyOf(this.reader.parent(currentGroup), parent, compoundKeyHash);
                this.providerCache = null;
                invalidationFirstInRange.getScope().compose(this);
                this.providerCache = null;
                this.reader.restoreParent(parent);
                i3 = currentGroup;
                z2 = true;
            } else {
                this.invalidateStack.push(invalidationFirstInRange.getScope());
                invalidationFirstInRange.getScope().rereadTrackedInstances();
                this.invalidateStack.pop();
            }
            invalidationFirstInRange = ComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), iGroupSize);
        }
        if (z2) {
            recordUpsAndDowns(i3, parent, parent);
            this.reader.skipToGroupEnd();
            int iUpdatedNodeCount = updatedNodeCount(parent);
            this.nodeIndex = i + iUpdatedNodeCount;
            this.groupNodeCount = i2 + iUpdatedNodeCount;
        } else {
            skipReaderToGroupEnd();
        }
        this.compoundKeyHash = compoundKeyHash;
        this.isComposing = z;
    }

    private final void record(InterfaceC0552Gp interfaceC0552Gp) {
        this.changes.add(interfaceC0552Gp);
    }

    private final void recordApplierOperation(InterfaceC0552Gp interfaceC0552Gp) {
        realizeUps();
        realizeDowns();
        record(interfaceC0552Gp);
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrentGroup());
        recordSlotEditingOperation(ComposerKt.removeCurrentGroupInstance);
        this.writersReaderDelta += this.reader.getGroupSize();
    }

    private final void recordDown(Object obj) {
        this.downNodes.push(obj);
    }

    private final void recordEndGroup() {
        int parent = this.reader.getParent();
        if (!(this.startedGroups.peekOr(-1) <= parent)) {
            ComposerKt.composeRuntimeError("Missed recording an endGroup");
            throw new C1182Zu();
        }
        if (this.startedGroups.peekOr(-1) == parent) {
            this.startedGroups.pop();
            recordSlotTableOperation$default(this, false, ComposerKt.endGroupInstance, 1, null);
        }
    }

    private final void recordEndRoot() {
        if (this.startedGroup) {
            recordSlotTableOperation$default(this, false, ComposerKt.endGroupInstance, 1, null);
            this.startedGroup = false;
        }
    }

    private final void recordFixup(InterfaceC0552Gp interfaceC0552Gp) {
        this.insertFixups.add(interfaceC0552Gp);
    }

    private final void recordInsert(Anchor anchor) {
        if (this.insertFixups.isEmpty()) {
            recordSlotEditingOperation(new C16201(this.insertTable, anchor));
            return;
        }
        List listF0 = AbstractC3240kc.F0(this.insertFixups);
        this.insertFixups.clear();
        realizeUps();
        realizeDowns();
        recordSlotEditingOperation(new C16212(this.insertTable, anchor, listF0));
    }

    private final void recordInsertUpFixup(InterfaceC0552Gp interfaceC0552Gp) {
        this.insertUpFixups.push(interfaceC0552Gp);
    }

    private final void recordMoveNode(int i, int i2, int i3) {
        if (i3 > 0) {
            int i4 = this.previousCount;
            if (i4 > 0 && this.previousMoveFrom == i - i4 && this.previousMoveTo == i2 - i4) {
                this.previousCount = i4 + i3;
                return;
            }
            realizeMovement();
            this.previousMoveFrom = i;
            this.previousMoveTo = i2;
            this.previousCount = i3;
        }
    }

    private final void recordReaderMoving(int i) {
        this.writersReaderDelta = i - (this.reader.getCurrentGroup() - this.writersReaderDelta);
    }

    private final void recordRemoveNode(int i, int i2) {
        if (i2 > 0) {
            if (!(i >= 0)) {
                ComposerKt.composeRuntimeError(("Invalid remove index " + i).toString());
                throw new C1182Zu();
            }
            if (this.previousRemove == i) {
                this.previousCount += i2;
                return;
            }
            realizeMovement();
            this.previousRemove = i;
            this.previousCount = i2;
        }
    }

    private final void recordSlotEditing() {
        SlotReader slotReader;
        int parent;
        if (this.reader.getSize() <= 0 || this.startedGroups.peekOr(-2) == (parent = (slotReader = this.reader).getParent())) {
            return;
        }
        if (!this.startedGroup && this.implicitRootStart) {
            recordSlotTableOperation$default(this, false, ComposerKt.startRootGroup, 1, null);
            this.startedGroup = true;
        }
        if (parent > 0) {
            Anchor anchor = slotReader.anchor(parent);
            this.startedGroups.push(parent);
            recordSlotTableOperation$default(this, false, new C16231(anchor), 1, null);
        }
    }

    private final void recordSlotEditingOperation(InterfaceC0552Gp interfaceC0552Gp) {
        realizeOperationLocation$default(this, false, 1, null);
        recordSlotEditing();
        record(interfaceC0552Gp);
    }

    private final void recordSlotTableOperation(boolean z, InterfaceC0552Gp interfaceC0552Gp) {
        realizeOperationLocation(z);
        record(interfaceC0552Gp);
    }

    public static /* synthetic */ void recordSlotTableOperation$default(ComposerImpl composerImpl, boolean z, InterfaceC0552Gp interfaceC0552Gp, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        composerImpl.recordSlotTableOperation(z, interfaceC0552Gp);
    }

    private final void recordUp() {
        if (this.downNodes.isNotEmpty()) {
            this.downNodes.pop();
        } else {
            this.pendingUps++;
        }
    }

    private final void recordUpsAndDowns(int i, int i2, int i3) {
        SlotReader slotReader = this.reader;
        int iNearestCommonRootOf = ComposerKt.nearestCommonRootOf(slotReader, i, i2, i3);
        while (i > 0 && i != iNearestCommonRootOf) {
            if (slotReader.isNode(i)) {
                recordUp();
            }
            i = slotReader.parent(i);
        }
        doRecordDownsFor(i2, iNearestCommonRootOf);
    }

    private final void registerInsertUpFixup() {
        this.insertFixups.add(this.insertUpFixups.pop());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseMovableGroupAtCurrent(final MovableContentStateReference movableContentStateReference, SlotWriter slotWriter) {
        SlotTable slotTable = new SlotTable();
        SlotWriter slotWriterOpenWriter = slotTable.openWriter();
        try {
            slotWriterOpenWriter.beginInsert();
            slotWriterOpenWriter.startGroup(MovableContentKt.movableContentKey, movableContentStateReference.getContent$runtime_release());
            SlotWriter.markGroup$default(slotWriterOpenWriter, 0, 1, null);
            slotWriterOpenWriter.update(movableContentStateReference.getParameter$runtime_release());
            List<Anchor> listMoveTo = slotWriter.moveTo(movableContentStateReference.getAnchor$runtime_release(), 1, slotWriterOpenWriter);
            slotWriterOpenWriter.skipGroup();
            slotWriterOpenWriter.endGroup();
            slotWriterOpenWriter.endInsert();
            slotWriterOpenWriter.close();
            MovableContentState movableContentState = new MovableContentState(slotTable);
            RecomposeScopeImpl.Companion companion = RecomposeScopeImpl.Companion;
            if (companion.hasAnchoredRecomposeScopes$runtime_release(slotTable, listMoveTo)) {
                final ControlledComposition composition = getComposition();
                RecomposeScopeOwner recomposeScopeOwner = new RecomposeScopeOwner() { // from class: androidx.compose.runtime.ComposerImpl$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1
                    @Override // androidx.compose.runtime.RecomposeScopeOwner
                    public InvalidationResult invalidate(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
                        InvalidationResult invalidationResultInvalidate;
                        AbstractC4492zt.h(recomposeScopeImpl, "scope");
                        ControlledComposition controlledComposition = composition;
                        IdentityArraySet identityArraySet = null;
                        RecomposeScopeOwner recomposeScopeOwner2 = controlledComposition instanceof RecomposeScopeOwner ? (RecomposeScopeOwner) controlledComposition : null;
                        if (recomposeScopeOwner2 == null || (invalidationResultInvalidate = recomposeScopeOwner2.invalidate(recomposeScopeImpl, obj)) == null) {
                            invalidationResultInvalidate = InvalidationResult.IGNORED;
                        }
                        if (invalidationResultInvalidate != InvalidationResult.IGNORED) {
                            return invalidationResultInvalidate;
                        }
                        MovableContentStateReference movableContentStateReference2 = movableContentStateReference;
                        List<C2020dG> invalidations$runtime_release = movableContentStateReference2.getInvalidations$runtime_release();
                        if (obj != null) {
                            identityArraySet = new IdentityArraySet();
                            identityArraySet.add(identityArraySet);
                        }
                        movableContentStateReference2.setInvalidations$runtime_release(AbstractC3240kc.q0(invalidations$runtime_release, HV.a(recomposeScopeImpl, identityArraySet)));
                        return InvalidationResult.SCHEDULED;
                    }

                    @Override // androidx.compose.runtime.RecomposeScopeOwner
                    public void recomposeScopeReleased(RecomposeScopeImpl recomposeScopeImpl) {
                        AbstractC4492zt.h(recomposeScopeImpl, "scope");
                    }

                    @Override // androidx.compose.runtime.RecomposeScopeOwner
                    public void recordReadOf(Object obj) {
                        AbstractC4492zt.h(obj, "value");
                    }
                };
                SlotWriter slotWriterOpenWriter2 = slotTable.openWriter();
                try {
                    companion.adoptAnchoredScopes$runtime_release(slotWriterOpenWriter2, listMoveTo, recomposeScopeOwner);
                    FW fw = FW.a;
                    slotWriterOpenWriter2.close();
                } catch (Throwable th) {
                    slotWriterOpenWriter2.close();
                    throw th;
                }
            }
            this.parentContext.movableContentStateReleased$runtime_release(movableContentStateReference, movableContentState);
        } catch (Throwable th2) {
            slotWriterOpenWriter.close();
            throw th2;
        }
    }

    private final void reportAllMovableContent() {
        if (this.slotTable.containsMark()) {
            ArrayList arrayList = new ArrayList();
            this.deferredChanges = arrayList;
            SlotReader slotReaderOpenReader = this.slotTable.openReader();
            try {
                this.reader = slotReaderOpenReader;
                List list = this.changes;
                try {
                    this.changes = arrayList;
                    reportFreeMovableContent(0);
                    realizeUps();
                    if (this.startedGroup) {
                        record(ComposerKt.skipToGroupEndInstance);
                        recordEndRoot();
                    }
                    FW fw = FW.a;
                    this.changes = list;
                    slotReaderOpenReader.close();
                } catch (Throwable th) {
                    this.changes = list;
                    throw th;
                }
            } catch (Throwable th2) {
                slotReaderOpenReader.close();
                throw th2;
            }
        }
    }

    private final void reportFreeMovableContent(int i) {
        reportFreeMovableContent$reportGroup(this, i, false, 0);
        realizeMovement();
    }

    private static final int reportFreeMovableContent$reportGroup(ComposerImpl composerImpl, int i, boolean z, int i2) {
        if (!composerImpl.reader.hasMark(i)) {
            if (!composerImpl.reader.containsMark(i)) {
                return composerImpl.reader.nodeCount(i);
            }
            int iGroupSize = composerImpl.reader.groupSize(i) + i;
            int iGroupSize2 = i + 1;
            int iReportFreeMovableContent$reportGroup = 0;
            while (iGroupSize2 < iGroupSize) {
                boolean zIsNode = composerImpl.reader.isNode(iGroupSize2);
                if (zIsNode) {
                    composerImpl.realizeMovement();
                    composerImpl.recordDown(composerImpl.reader.node(iGroupSize2));
                }
                iReportFreeMovableContent$reportGroup += reportFreeMovableContent$reportGroup(composerImpl, iGroupSize2, zIsNode || z, zIsNode ? 0 : i2 + iReportFreeMovableContent$reportGroup);
                if (zIsNode) {
                    composerImpl.realizeMovement();
                    composerImpl.recordUp();
                }
                iGroupSize2 += composerImpl.reader.groupSize(iGroupSize2);
            }
            return iReportFreeMovableContent$reportGroup;
        }
        int iGroupKey = composerImpl.reader.groupKey(i);
        Object objGroupObjectKey = composerImpl.reader.groupObjectKey(i);
        if (iGroupKey != 126665345 || !(objGroupObjectKey instanceof MovableContent)) {
            if (iGroupKey != 206 || !AbstractC4492zt.d(objGroupObjectKey, ComposerKt.getReference())) {
                return composerImpl.reader.nodeCount(i);
            }
            Object objGroupGet = composerImpl.reader.groupGet(i, 0);
            CompositionContextHolder compositionContextHolder = objGroupGet instanceof CompositionContextHolder ? (CompositionContextHolder) objGroupGet : null;
            if (compositionContextHolder != null) {
                for (ComposerImpl composerImpl2 : compositionContextHolder.getRef().getComposers()) {
                    composerImpl2.reportAllMovableContent();
                    composerImpl.parentContext.reportRemovedComposition$runtime_release(composerImpl2.getComposition());
                }
            }
            return composerImpl.reader.nodeCount(i);
        }
        MovableContent movableContent = (MovableContent) objGroupObjectKey;
        Object objGroupGet2 = composerImpl.reader.groupGet(i, 0);
        Anchor anchor = composerImpl.reader.anchor(i);
        List listFilterToRange = ComposerKt.filterToRange(composerImpl.invalidations, i, composerImpl.reader.groupSize(i) + i);
        ArrayList arrayList = new ArrayList(listFilterToRange.size());
        int size = listFilterToRange.size();
        for (int i3 = 0; i3 < size; i3++) {
            Invalidation invalidation = (Invalidation) listFilterToRange.get(i3);
            arrayList.add(HV.a(invalidation.getScope(), invalidation.getInstances()));
        }
        MovableContentStateReference movableContentStateReference = new MovableContentStateReference(movableContent, objGroupGet2, composerImpl.getComposition(), composerImpl.slotTable, anchor, arrayList, composerImpl.currentCompositionLocalScope(i));
        composerImpl.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
        composerImpl.recordSlotEditing();
        composerImpl.record(new ComposerImpl$reportFreeMovableContent$reportGroup$1(composerImpl, movableContentStateReference));
        if (!z) {
            return composerImpl.reader.nodeCount(i);
        }
        composerImpl.realizeMovement();
        composerImpl.realizeUps();
        composerImpl.realizeDowns();
        int iNodeCount = composerImpl.reader.isNode(i) ? 1 : composerImpl.reader.nodeCount(i);
        if (iNodeCount <= 0) {
            return 0;
        }
        composerImpl.recordRemoveNode(i2, iNodeCount);
        return 0;
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    /* JADX INFO: renamed from: start-BaiHCIY, reason: not valid java name */
    private final void m2630startBaiHCIY(int i, Object obj, int i2, Object obj2) {
        Object empty = obj;
        validateNodeNotExpected();
        updateCompoundKeyWhenWeEnterGroup(i, obj, obj2);
        GroupKind.Companion companion = GroupKind.Companion;
        boolean z = i2 != companion.m2643getGroupULZAiWs();
        Pending pending = null;
        if (getInserting()) {
            this.reader.beginEmpty();
            int currentGroup = this.writer.getCurrentGroup();
            if (z) {
                this.writer.startNode(i, Composer.Companion.getEmpty());
            } else if (obj2 != null) {
                SlotWriter slotWriter = this.writer;
                if (empty == null) {
                    empty = Composer.Companion.getEmpty();
                }
                slotWriter.startData(i, empty, obj2);
            } else {
                SlotWriter slotWriter2 = this.writer;
                if (empty == null) {
                    empty = Composer.Companion.getEmpty();
                }
                slotWriter2.startGroup(i, empty);
            }
            Pending pending2 = this.pending;
            if (pending2 != null) {
                KeyInfo keyInfo = new KeyInfo(i, -1, insertedGroupVirtualIndex(currentGroup), -1, 0);
                pending2.registerInsert(keyInfo, this.nodeIndex - pending2.getStartIndex());
                pending2.recordUsed(keyInfo);
            }
            enterGroup(z, null);
            return;
        }
        boolean z2 = i2 == companion.m2644getNodeULZAiWs() && this.reusing;
        if (this.pending == null) {
            int groupKey = this.reader.getGroupKey();
            if (!z2 && groupKey == i && AbstractC4492zt.d(obj, this.reader.getGroupObjectKey())) {
                startReaderGroup(z, obj2);
            } else {
                this.pending = new Pending(this.reader.extractKeys(), this.nodeIndex);
            }
        }
        Pending pending3 = this.pending;
        if (pending3 != null) {
            KeyInfo next = pending3.getNext(i, obj);
            if (z2 || next == null) {
                this.reader.beginEmpty();
                this.inserting = true;
                this.providerCache = null;
                ensureWriter();
                this.writer.beginInsert();
                int currentGroup2 = this.writer.getCurrentGroup();
                if (z) {
                    this.writer.startNode(i, Composer.Companion.getEmpty());
                } else if (obj2 != null) {
                    SlotWriter slotWriter3 = this.writer;
                    if (empty == null) {
                        empty = Composer.Companion.getEmpty();
                    }
                    slotWriter3.startData(i, empty, obj2);
                } else {
                    SlotWriter slotWriter4 = this.writer;
                    if (empty == null) {
                        empty = Composer.Companion.getEmpty();
                    }
                    slotWriter4.startGroup(i, empty);
                }
                this.insertAnchor = this.writer.anchor(currentGroup2);
                KeyInfo keyInfo2 = new KeyInfo(i, -1, insertedGroupVirtualIndex(currentGroup2), -1, 0);
                pending3.registerInsert(keyInfo2, this.nodeIndex - pending3.getStartIndex());
                pending3.recordUsed(keyInfo2);
                pending = new Pending(new ArrayList(), z ? 0 : this.nodeIndex);
            } else {
                pending3.recordUsed(next);
                int location = next.getLocation();
                this.nodeIndex = pending3.nodePositionOf(next) + pending3.getStartIndex();
                int iSlotPositionOf = pending3.slotPositionOf(next);
                int groupIndex = iSlotPositionOf - pending3.getGroupIndex();
                pending3.registerMoveSlot(iSlotPositionOf, pending3.getGroupIndex());
                recordReaderMoving(location);
                this.reader.reposition(location);
                if (groupIndex > 0) {
                    recordSlotEditingOperation(new ComposerImpl$start$2(groupIndex));
                }
                startReaderGroup(z, obj2);
            }
        }
        enterGroup(z, pending);
    }

    private final void startGroup(int i) {
        m2630startBaiHCIY(i, null, GroupKind.Companion.m2643getGroupULZAiWs(), null);
    }

    private final void startReaderGroup(boolean z, Object obj) {
        if (z) {
            this.reader.startNode();
            return;
        }
        if (obj != null && this.reader.getGroupAux() != obj) {
            recordSlotTableOperation$default(this, false, new C16241(obj), 1, null);
        }
        this.reader.startGroup();
    }

    private final void startRoot() {
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime_release();
        this.parentProvider = this.parentContext.getCompositionLocalScope$runtime_release();
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = changed(this.parentProvider);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation$runtime_release();
        }
        Set<CompositionData> set = (Set) CompositionLocalMapKt.read(this.parentProvider, InspectionTablesKt.getLocalInspectionTables());
        if (set != null) {
            set.add(this.slotTable);
            this.parentContext.recordInspectionTable$runtime_release(set);
        }
        startGroup(this.parentContext.getCompoundHashKey$runtime_release());
    }

    private final void updateCompoundKeyWhenWeEnterGroup(int i, Object obj, Object obj2) {
        if (obj != null) {
            if (obj instanceof Enum) {
                updateCompoundKeyWhenWeEnterGroupKeyHash(((Enum) obj).ordinal());
                return;
            } else {
                updateCompoundKeyWhenWeEnterGroupKeyHash(obj.hashCode());
                return;
            }
        }
        if (obj2 == null || i != 207 || AbstractC4492zt.d(obj2, Composer.Companion.getEmpty())) {
            updateCompoundKeyWhenWeEnterGroupKeyHash(i);
        } else {
            updateCompoundKeyWhenWeEnterGroupKeyHash(obj2.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroupKeyHash(int i) {
        this.compoundKeyHash = i ^ Integer.rotateLeft(getCompoundKeyHash(), 3);
    }

    private final void updateCompoundKeyWhenWeExitGroup(int i, Object obj, Object obj2) {
        if (obj != null) {
            if (obj instanceof Enum) {
                updateCompoundKeyWhenWeExitGroupKeyHash(((Enum) obj).ordinal());
                return;
            } else {
                updateCompoundKeyWhenWeExitGroupKeyHash(obj.hashCode());
                return;
            }
        }
        if (obj2 == null || i != 207 || AbstractC4492zt.d(obj2, Composer.Companion.getEmpty())) {
            updateCompoundKeyWhenWeExitGroupKeyHash(i);
        } else {
            updateCompoundKeyWhenWeExitGroupKeyHash(obj2.hashCode());
        }
    }

    private final void updateCompoundKeyWhenWeExitGroupKeyHash(int i) {
        this.compoundKeyHash = Integer.rotateRight(i ^ getCompoundKeyHash(), 3);
    }

    private final void updateNodeCount(int i, int i2) {
        if (updatedNodeCount(i) != i2) {
            if (i < 0) {
                HashMap<Integer, Integer> map = this.nodeCountVirtualOverrides;
                if (map == null) {
                    map = new HashMap<>();
                    this.nodeCountVirtualOverrides = map;
                }
                map.put(Integer.valueOf(i), Integer.valueOf(i2));
                return;
            }
            int[] iArr = this.nodeCountOverrides;
            if (iArr == null) {
                iArr = new int[this.reader.getSize()];
                Q5.t(iArr, -1, 0, 0, 6, null);
                this.nodeCountOverrides = iArr;
            }
            iArr[i] = i2;
        }
    }

    private final void updateNodeCountOverrides(int i, int i2) {
        int iUpdatedNodeCount = updatedNodeCount(i);
        if (iUpdatedNodeCount != i2) {
            int i3 = i2 - iUpdatedNodeCount;
            int size = this.pendingStack.getSize() - 1;
            while (i != -1) {
                int iUpdatedNodeCount2 = updatedNodeCount(i) + i3;
                updateNodeCount(i, iUpdatedNodeCount2);
                for (int i4 = size; -1 < i4; i4--) {
                    Pending pendingPeek = this.pendingStack.peek(i4);
                    if (pendingPeek != null && pendingPeek.updateNodeCount(i, iUpdatedNodeCount2)) {
                        size = i4 - 1;
                        break;
                    }
                }
                if (i < 0) {
                    i = this.reader.getParent();
                } else if (this.reader.isNode(i)) {
                    return;
                } else {
                    i = this.reader.parent(i);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.runtime.PersistentCompositionLocalMap, java.lang.Object] */
    private final PersistentCompositionLocalMap updateProviderMapGroup(PersistentCompositionLocalMap persistentCompositionLocalMap, PersistentCompositionLocalMap persistentCompositionLocalMap2) {
        PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builderBuilder2 = persistentCompositionLocalMap.builder2();
        builderBuilder2.putAll(persistentCompositionLocalMap2);
        ?? Build2 = builderBuilder2.build2();
        startGroup(204, ComposerKt.getProviderMaps());
        changed((Object) Build2);
        changed(persistentCompositionLocalMap2);
        endGroup();
        return Build2;
    }

    private final int updatedNodeCount(int i) {
        int i2;
        Integer num;
        if (i >= 0) {
            int[] iArr = this.nodeCountOverrides;
            return (iArr == null || (i2 = iArr[i]) < 0) ? this.reader.nodeCount(i) : i2;
        }
        HashMap<Integer, Integer> map = this.nodeCountVirtualOverrides;
        if (map == null || (num = map.get(Integer.valueOf(i))) == null) {
            return 0;
        }
        return num.intValue();
    }

    private final void validateNodeExpected() {
        if (this.nodeExpected) {
            this.nodeExpected = false;
        } else {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected");
            throw new C1182Zu();
        }
    }

    private final void validateNodeNotExpected() {
        if (this.nodeExpected) {
            ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected");
            throw new C1182Zu();
        }
    }

    private final <R> R withChanges(List<InterfaceC0552Gp> list, InterfaceC3588op interfaceC3588op) {
        List list2 = this.changes;
        try {
            this.changes = list;
            return (R) interfaceC3588op.invoke();
        } finally {
            AbstractC0703Ks.b(1);
            this.changes = list2;
            AbstractC0703Ks.a(1);
        }
    }

    private final <R> R withReader(SlotReader slotReader, InterfaceC3588op interfaceC3588op) {
        SlotReader slotReader2 = this.reader;
        int[] iArr = this.nodeCountOverrides;
        this.nodeCountOverrides = null;
        try {
            this.reader = slotReader;
            return (R) interfaceC3588op.invoke();
        } finally {
            AbstractC0703Ks.b(1);
            this.reader = slotReader2;
            this.nodeCountOverrides = iArr;
            AbstractC0703Ks.a(1);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public <V, T> void apply(V v, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        ComposerImpl$apply$operation$1 composerImpl$apply$operation$1 = new ComposerImpl$apply$operation$1(interfaceC0526Fp, v);
        if (getInserting()) {
            recordFixup(composerImpl$apply$operation$1);
        } else {
            recordApplierOperation(composerImpl$apply$operation$1);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionContext buildContext() {
        startGroup(ComposerKt.referenceKey, ComposerKt.getReference());
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, null);
        }
        Object objNextSlot = nextSlot();
        CompositionContextHolder compositionContextHolder = objNextSlot instanceof CompositionContextHolder ? (CompositionContextHolder) objNextSlot : null;
        if (compositionContextHolder == null) {
            compositionContextHolder = new CompositionContextHolder(new CompositionContextImpl(getCompoundKeyHash(), this.forceRecomposeScopes));
            updateValue(compositionContextHolder);
        }
        compositionContextHolder.getRef().updateCompositionLocalScope(currentCompositionLocalScope());
        endGroup();
        return compositionContextHolder.getRef();
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean z, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        T t = (T) nextSlot();
        if (t != Composer.Companion.getEmpty() && !z) {
            return t;
        }
        T t2 = (T) interfaceC3588op.invoke();
        updateValue(t2);
        return t2;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(Object obj) {
        if (AbstractC4492zt.d(nextSlot(), obj)) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changedInstance(Object obj) {
        if (nextSlot() == obj) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    public final void changesApplied$runtime_release() {
        createFreshInsertTable();
        this.providerUpdates.clear();
    }

    @Override // androidx.compose.runtime.Composer
    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
    }

    public final void composeContent$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(identityArrayMap, "invalidationsRequested");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        if (this.changes.isEmpty()) {
            doCompose(identityArrayMap, interfaceC0526Fp);
        } else {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called");
            throw new C1182Zu();
        }
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public <T> T consume(CompositionLocal<T> compositionLocal) {
        AbstractC4492zt.h(compositionLocal, "key");
        return (T) CompositionLocalMapKt.read(currentCompositionLocalScope(), compositionLocal);
    }

    @Override // androidx.compose.runtime.Composer
    public <T> void createNode(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "factory");
        validateNodeExpected();
        if (!getInserting()) {
            ComposerKt.composeRuntimeError("createNode() can only be called when inserting");
            throw new C1182Zu();
        }
        int iPeek = this.nodeIndexStack.peek();
        SlotWriter slotWriter = this.writer;
        Anchor anchor = slotWriter.anchor(slotWriter.getParent());
        this.groupNodeCount++;
        recordFixup(new AnonymousClass2(interfaceC3588op, anchor, iPeek));
        recordInsertUpFixup(new AnonymousClass3(anchor, iPeek));
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean z) {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeRuntimeError("No nodes can be emitted before calling dactivateToEndGroup");
            throw new C1182Zu();
        }
        if (getInserting()) {
            return;
        }
        if (!z) {
            skipReaderToGroupEnd();
            return;
        }
        int currentGroup = this.reader.getCurrentGroup();
        int currentEnd = this.reader.getCurrentEnd();
        for (int i = currentGroup; i < currentEnd; i++) {
            if (this.reader.isNode(i)) {
                Object objNode = this.reader.node(i);
                if (objNode instanceof ComposeNodeLifecycleCallback) {
                    record(new C16132(objNode));
                }
            }
            this.reader.forEachData$runtime_release(i, new C16143(i));
        }
        ComposerKt.removeRange(this.invalidations, currentGroup, currentEnd);
        this.reader.reposition(currentGroup);
        this.reader.skipToGroupEnd();
    }

    @Override // androidx.compose.runtime.Composer
    public void disableReusing() {
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void disableSourceInformation() {
        this.sourceInformationEnabled = false;
    }

    public final void dispose$runtime_release() {
        Object objBeginSection = Trace.INSTANCE.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime_release(this);
            this.invalidateStack.clear();
            this.invalidations.clear();
            this.changes.clear();
            this.providerUpdates.clear();
            getApplier().clear();
            this.isDisposed = true;
            FW fw = FW.a;
        } finally {
            Trace.INSTANCE.endSection(objBeginSection);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release == null || !currentRecomposeScope$runtime_release.getUsed()) {
            return;
        }
        currentRecomposeScope$runtime_release.setDefaultsInScope(true);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void endNode() {
        end(true);
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public ScopeUpdateScope endRestartGroup() {
        Anchor anchor;
        InterfaceC3750qp interfaceC3750qpEnd;
        RecomposeScopeImpl recomposeScopeImpl = null;
        RecomposeScopeImpl recomposeScopeImplPop = this.invalidateStack.isNotEmpty() ? this.invalidateStack.pop() : null;
        if (recomposeScopeImplPop != null) {
            recomposeScopeImplPop.setRequiresRecompose(false);
        }
        if (recomposeScopeImplPop != null && (interfaceC3750qpEnd = recomposeScopeImplPop.end(this.compositionToken)) != null) {
            record(new ComposerImpl$endRestartGroup$1$1(interfaceC3750qpEnd, this));
        }
        if (recomposeScopeImplPop != null && !recomposeScopeImplPop.getSkipped$runtime_release() && (recomposeScopeImplPop.getUsed() || this.forceRecomposeScopes)) {
            if (recomposeScopeImplPop.getAnchor() == null) {
                if (getInserting()) {
                    SlotWriter slotWriter = this.writer;
                    anchor = slotWriter.anchor(slotWriter.getParent());
                } else {
                    SlotReader slotReader = this.reader;
                    anchor = slotReader.anchor(slotReader.getParent());
                }
                recomposeScopeImplPop.setAnchor(anchor);
            }
            recomposeScopeImplPop.setDefaultsInvalid(false);
            recomposeScopeImpl = recomposeScopeImplPop;
        }
        end(false);
        return recomposeScopeImpl;
    }

    @Override // androidx.compose.runtime.Composer
    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    @Override // androidx.compose.runtime.Composer
    public void endToMarker(int i) {
        if (i < 0) {
            int i2 = -i;
            SlotWriter slotWriter = this.writer;
            while (true) {
                int parent = slotWriter.getParent();
                if (parent <= i2) {
                    return;
                } else {
                    end(slotWriter.isNode(parent));
                }
            }
        } else {
            if (getInserting()) {
                SlotWriter slotWriter2 = this.writer;
                while (getInserting()) {
                    end(slotWriter2.isNode(slotWriter2.getParent()));
                }
            }
            SlotReader slotReader = this.reader;
            while (true) {
                int parent2 = slotReader.getParent();
                if (parent2 <= i) {
                    return;
                } else {
                    end(slotReader.isNode(parent2));
                }
            }
        }
    }

    public final boolean forceRecomposeScopes$runtime_release() {
        if (this.forceRecomposeScopes) {
            return false;
        }
        this.forceRecomposeScopes = true;
        this.forciblyRecompose = true;
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public Applier<?> getApplier() {
        return this.applier;
    }

    @Override // androidx.compose.runtime.Composer
    public InterfaceC0988Vf getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext();
    }

    public final boolean getAreChildrenComposing$runtime_release() {
        return this.childrenComposing > 0;
    }

    public final int getChangeCount$runtime_release() {
        return this.changes.size();
    }

    @Override // androidx.compose.runtime.Composer
    public ControlledComposition getComposition() {
        return this.composition;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionData getCompositionData() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.Composer
    public int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return currentCompositionLocalScope();
    }

    @Override // androidx.compose.runtime.Composer
    public int getCurrentMarker() {
        return getInserting() ? -this.writer.getParent() : this.reader.getParent();
    }

    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        Stack<RecomposeScopeImpl> stack = this.invalidateStack;
        if (this.childrenComposing == 0 && stack.isNotEmpty()) {
            return stack.peek();
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getDefaultsInvalid() {
        if (this.providersInvalid) {
            return true;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        return currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getDefaultsInvalid();
    }

    public final List<InterfaceC0552Gp> getDeferredChanges$runtime_release() {
        return this.deferredChanges;
    }

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    public final boolean getHasPendingChanges$runtime_release() {
        return !this.changes.isEmpty();
    }

    public final SlotTable getInsertTable$runtime_release() {
        return this.insertTable;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getInserting() {
        return this.inserting;
    }

    @Override // androidx.compose.runtime.Composer
    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime_release();
    }

    @Override // androidx.compose.runtime.Composer
    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            return currentRecomposeScope$runtime_release.getAnchor();
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getSkipping() {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        return (getInserting() || this.reusing || this.providersInvalid || (currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release()) == null || currentRecomposeScope$runtime_release.getRequiresRecompose() || this.forciblyRecompose) ? false : true;
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void insertMovableContent(MovableContent<?> movableContent, Object obj) {
        AbstractC4492zt.h(movableContent, "value");
        invokeMovableContentLambda(movableContent, currentCompositionLocalScope(), obj, false);
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void insertMovableContentReferences(List<C2020dG> list) {
        AbstractC4492zt.h(list, "references");
        try {
            insertMovableContentGuarded(list);
            cleanUpCompose();
        } catch (Throwable th) {
            abortRoot();
            throw th;
        }
    }

    public final boolean isComposing$runtime_release() {
        return this.isComposing;
    }

    public final boolean isDisposed$runtime_release() {
        return this.isDisposed;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public Object joinKey(Object obj, Object obj2) {
        Object key = ComposerKt.getKey(this.reader.getGroupObjectKey(), obj, obj2);
        return key == null ? new JoinedKey(obj, obj2) : key;
    }

    public final Object nextSlot() {
        if (!getInserting()) {
            return this.reusing ? Composer.Companion.getEmpty() : this.reader.next();
        }
        validateNodeNotExpected();
        return Composer.Companion.getEmpty();
    }

    public final int parentKey$runtime_release() {
        if (getInserting()) {
            SlotWriter slotWriter = this.writer;
            return slotWriter.groupKey(slotWriter.getParent());
        }
        SlotReader slotReader = this.reader;
        return slotReader.groupKey(slotReader.getParent());
    }

    public final void prepareCompose$runtime_release(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        if (this.isComposing) {
            ComposerKt.composeRuntimeError("Preparing a composition while composing is not supported");
            throw new C1182Zu();
        }
        this.isComposing = true;
        try {
            interfaceC3588op.invoke();
        } finally {
            this.isComposing = false;
        }
    }

    public final boolean recompose$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap) {
        AbstractC4492zt.h(identityArrayMap, "invalidationsRequested");
        if (!this.changes.isEmpty()) {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called");
            throw new C1182Zu();
        }
        if (!identityArrayMap.isNotEmpty() && this.invalidations.isEmpty() && !this.forciblyRecompose) {
            return false;
        }
        doCompose(identityArrayMap, null);
        return !this.changes.isEmpty();
    }

    @Override // androidx.compose.runtime.Composer
    public void recordSideEffect(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "effect");
        record(new C16221(interfaceC3588op));
    }

    @Override // androidx.compose.runtime.Composer
    public void recordUsed(RecomposeScope recomposeScope) {
        AbstractC4492zt.h(recomposeScope, "scope");
        RecomposeScopeImpl recomposeScopeImpl = recomposeScope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) recomposeScope : null;
        if (recomposeScopeImpl == null) {
            return;
        }
        recomposeScopeImpl.setUsed(true);
    }

    @Override // androidx.compose.runtime.Composer
    public Object rememberedValue() {
        return nextSlot();
    }

    public final void setDeferredChanges$runtime_release(List<InterfaceC0552Gp> list) {
        this.deferredChanges = list;
    }

    public final void setInsertTable$runtime_release(SlotTable slotTable) {
        AbstractC4492zt.h(slotTable, "<set-?>");
        this.insertTable = slotTable;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void skipCurrentGroup() {
        if (this.invalidations.isEmpty()) {
            skipGroup();
            return;
        }
        SlotReader slotReader = this.reader;
        int groupKey = slotReader.getGroupKey();
        Object groupObjectKey = slotReader.getGroupObjectKey();
        Object groupAux = slotReader.getGroupAux();
        updateCompoundKeyWhenWeEnterGroup(groupKey, groupObjectKey, groupAux);
        startReaderGroup(slotReader.isNode(), null);
        recomposeToGroupEnd();
        slotReader.endGroup();
        updateCompoundKeyWhenWeExitGroup(groupKey, groupObjectKey, groupAux);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void skipToGroupEnd() {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeRuntimeError("No nodes can be emitted before calling skipAndEndGroup");
            throw new C1182Zu();
        }
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            currentRecomposeScope$runtime_release.scopeSkipped();
        }
        if (this.invalidations.isEmpty()) {
            skipReaderToGroupEnd();
        } else {
            recomposeToGroupEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformation(String str) {
        AbstractC4492zt.h(str, "sourceInformation");
        if (getInserting() && this.sourceInformationEnabled) {
            this.writer.insertAux(str);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        if (this.sourceInformationEnabled) {
            end(false);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int i, String str) {
        AbstractC4492zt.h(str, "sourceInformation");
        if (this.sourceInformationEnabled) {
            m2630startBaiHCIY(i, null, GroupKind.Companion.m2643getGroupULZAiWs(), str);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startDefaults() {
        m2630startBaiHCIY(-127, null, GroupKind.Companion.m2643getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startMovableGroup(int i, Object obj) {
        m2630startBaiHCIY(i, obj, GroupKind.Companion.m2643getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    public void startNode() {
        m2630startBaiHCIY(125, null, GroupKind.Companion.m2644getNodeULZAiWs(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void startProviders(ProvidedValue<?>[] providedValueArr) {
        PersistentCompositionLocalMap persistentCompositionLocalMapUpdateProviderMapGroup;
        AbstractC4492zt.h(providedValueArr, "values");
        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        startGroup(203, ComposerKt.getProviderValues());
        PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) ActualJvm_jvmKt.invokeComposableForResult(this, new ComposerImpl$startProviders$currentProviders$1(providedValueArr, persistentCompositionLocalMapCurrentCompositionLocalScope));
        endGroup();
        boolean z = false;
        if (getInserting()) {
            persistentCompositionLocalMapUpdateProviderMapGroup = updateProviderMapGroup(persistentCompositionLocalMapCurrentCompositionLocalScope, persistentCompositionLocalMap);
            this.writerHasAProvider = true;
        } else {
            Object objGroupGet = this.reader.groupGet(0);
            AbstractC4492zt.f(objGroupGet, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) objGroupGet;
            Object objGroupGet2 = this.reader.groupGet(1);
            AbstractC4492zt.f(objGroupGet2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap3 = (PersistentCompositionLocalMap) objGroupGet2;
            if (getSkipping() && AbstractC4492zt.d(persistentCompositionLocalMap3, persistentCompositionLocalMap)) {
                skipGroup();
                persistentCompositionLocalMapUpdateProviderMapGroup = persistentCompositionLocalMap2;
            } else {
                persistentCompositionLocalMapUpdateProviderMapGroup = updateProviderMapGroup(persistentCompositionLocalMapCurrentCompositionLocalScope, persistentCompositionLocalMap);
                z = !AbstractC4492zt.d(persistentCompositionLocalMapUpdateProviderMapGroup, persistentCompositionLocalMap2);
            }
        }
        if (z && !getInserting()) {
            this.providerUpdates.set(this.reader.getCurrentGroup(), persistentCompositionLocalMapUpdateProviderMapGroup);
        }
        this.providersInvalidStack.push(ComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z;
        this.providerCache = persistentCompositionLocalMapUpdateProviderMapGroup;
        m2630startBaiHCIY(202, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m2643getGroupULZAiWs(), persistentCompositionLocalMapUpdateProviderMapGroup);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startReplaceableGroup(int i) {
        m2630startBaiHCIY(i, null, GroupKind.Companion.m2643getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public Composer startRestartGroup(int i) {
        m2630startBaiHCIY(i, null, GroupKind.Companion.m2643getGroupULZAiWs(), null);
        addRecomposeScope();
        return this;
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableGroup(int i, Object obj) {
        if (this.reader.getGroupKey() == i && !AbstractC4492zt.d(this.reader.getGroupAux(), obj) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        m2630startBaiHCIY(i, null, GroupKind.Companion.m2643getGroupULZAiWs(), obj);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableNode() {
        m2630startBaiHCIY(125, null, GroupKind.Companion.m2645getReusableNodeULZAiWs(), null);
        this.nodeExpected = true;
    }

    public final boolean tryImminentInvalidation$runtime_release(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        AbstractC4492zt.h(recomposeScopeImpl, "scope");
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null) {
            return false;
        }
        int indexFor = anchor.toIndexFor(this.reader.getTable$runtime_release());
        if (!this.isComposing || indexFor < this.reader.getCurrentGroup()) {
            return false;
        }
        ComposerKt.insertIfMissing(this.invalidations, indexFor, recomposeScopeImpl, obj);
        return true;
    }

    public final void updateCachedValue(Object obj) {
        updateValue(obj);
    }

    @Override // androidx.compose.runtime.Composer
    public void updateRememberedValue(Object obj) {
        updateValue(obj);
    }

    public final void updateValue(Object obj) {
        if (!getInserting()) {
            int groupSlotIndex = this.reader.getGroupSlotIndex() - 1;
            if (obj instanceof RememberObserver) {
                this.abandonSet.add(obj);
            }
            recordSlotTableOperation(true, new C16262(obj, groupSlotIndex));
            return;
        }
        this.writer.update(obj);
        if (obj instanceof RememberObserver) {
            record(new C16251(obj));
            this.abandonSet.add(obj);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void useNode() {
        validateNodeExpected();
        if (getInserting()) {
            ComposerKt.composeRuntimeError("useNode() called while inserting");
            throw new C1182Zu();
        }
        Object node = getNode(this.reader);
        recordDown(node);
        if (this.reusing && (node instanceof ComposeNodeLifecycleCallback)) {
            recordApplierOperation(C16272.INSTANCE);
        }
    }

    public final void verifyConsistent$runtime_release() {
        this.insertTable.verifyWellFormed();
    }

    private final void realizeDowns() {
        if (this.downNodes.isNotEmpty()) {
            realizeDowns(this.downNodes.toArray());
            this.downNodes.clear();
        }
    }

    private final void startGroup(int i, Object obj) {
        m2630startBaiHCIY(i, obj, GroupKind.Companion.m2643getGroupULZAiWs(), null);
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope(int i) {
        if (getInserting() && this.writerHasAProvider) {
            int parent = this.writer.getParent();
            while (parent > 0) {
                if (this.writer.groupKey(parent) == 202 && AbstractC4492zt.d(this.writer.groupObjectKey(parent), ComposerKt.getCompositionLocalMap())) {
                    Object objGroupAux = this.writer.groupAux(parent);
                    AbstractC4492zt.f(objGroupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) objGroupAux;
                    this.providerCache = persistentCompositionLocalMap;
                    return persistentCompositionLocalMap;
                }
                parent = this.writer.parent(parent);
            }
        }
        if (this.reader.getSize() > 0) {
            while (i > 0) {
                if (this.reader.groupKey(i) == 202 && AbstractC4492zt.d(this.reader.groupObjectKey(i), ComposerKt.getCompositionLocalMap())) {
                    PersistentCompositionLocalMap persistentCompositionLocalMap2 = this.providerUpdates.get(i);
                    if (persistentCompositionLocalMap2 == null) {
                        Object objGroupAux2 = this.reader.groupAux(i);
                        AbstractC4492zt.f(objGroupAux2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) objGroupAux2;
                    }
                    this.providerCache = persistentCompositionLocalMap2;
                    return persistentCompositionLocalMap2;
                }
                i = this.reader.parent(i);
            }
        }
        PersistentCompositionLocalMap persistentCompositionLocalMap3 = this.parentProvider;
        this.providerCache = persistentCompositionLocalMap3;
        return persistentCompositionLocalMap3;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(char c) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Character) && c == ((Character) objNextSlot).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(c));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(byte b) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Byte) && b == ((Number) objNextSlot).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(b));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(short s) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Short) && s == ((Number) objNextSlot).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(s));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(boolean z) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Boolean) && z == ((Boolean) objNextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(z));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(float f) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Float) && f == ((Number) objNextSlot).floatValue()) {
            return false;
        }
        updateValue(Float.valueOf(f));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(long j) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Long) && j == ((Number) objNextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(j));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(double d) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Double) && d == ((Number) objNextSlot).doubleValue()) {
            return false;
        }
        updateValue(Double.valueOf(d));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(int i) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Integer) && i == ((Number) objNextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(i));
        return true;
    }
}
