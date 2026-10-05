package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2371hc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3347lu;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.C2020dG;
import defpackage.C4374ya;
import defpackage.CR;
import defpackage.DC;
import defpackage.E8;
import defpackage.ER;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC1243ae;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import defpackage.LL;
import defpackage.M8;
import defpackage.XS;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class Recomposer extends CompositionContext {
    private final DC _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final List<ControlledComposition> compositionInvalidations;
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable;
    private final List<MovableContentStateReference> compositionValuesAwaitingInsert;
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved;
    private final List<ControlledComposition> compositionsAwaitingApply;
    private Set<ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final InterfaceC0988Vf effectCoroutineContext;
    private final InterfaceC1243ae effectJob;
    private RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final List<ControlledComposition> knownCompositions;
    private final RecomposerInfoImpl recomposerInfo;
    private InterfaceC1830bu runnerJob;
    private IdentityArraySet<Object> snapshotInvalidations;
    private final Object stateLock;
    private InterfaceC4293xa workContinuation;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final DC _runningRecomposers = ER.a(ExtensionsKt.persistentSetOf());
    private static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(Boolean.FALSE);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl recomposerInfoImpl) {
            PersistentSet persistentSet;
            PersistentSet persistentSetAdd;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetAdd = persistentSet.add(recomposerInfoImpl);
                if (persistentSet == persistentSetAdd) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.b(persistentSet, persistentSetAdd));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl recomposerInfoImpl) {
            PersistentSet persistentSet;
            PersistentSet persistentSetRemove;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetRemove = persistentSet.remove(recomposerInfoImpl);
                if (persistentSet == persistentSetRemove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.b(persistentSet, persistentSetRemove));
        }

        public final void clearErrors$runtime_release() {
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                RecomposerErrorState recomposerErrorStateResetErrorState = ((RecomposerInfoImpl) it.next()).resetErrorState();
                if (recomposerErrorStateResetErrorState != null) {
                    arrayList.add(recomposerErrorStateResetErrorState);
                }
            }
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                RecomposerErrorInfo currentError = ((RecomposerInfoImpl) it.next()).getCurrentError();
                if (currentError != null) {
                    arrayList.add(currentError);
                }
            }
            return arrayList;
        }

        public final CR getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void invalidateGroupsWithKey$runtime_release(int i) {
            Recomposer._hotReloadEnabled.set(Boolean.TRUE);
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInfo currentError = recomposerInfoImpl.getCurrentError();
                if (currentError == null || currentError.getRecoverable()) {
                    recomposerInfoImpl.resetErrorState();
                    recomposerInfoImpl.invalidateGroupsWithKey(i);
                    recomposerInfoImpl.retryFailedCompositions();
                }
            }
        }

        public final void loadStateAndComposeForHotReload$runtime_release(Object obj) {
            AbstractC4492zt.h(obj, "token");
            Recomposer._hotReloadEnabled.set(Boolean.TRUE);
            Iterator it = ((Iterable) Recomposer._runningRecomposers.getValue()).iterator();
            while (it.hasNext()) {
                ((RecomposerInfoImpl) it.next()).resetErrorState();
            }
            List list = (List) obj;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((HotReloadable) list.get(i)).resetContent();
            }
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((HotReloadable) list.get(i2)).recompose();
            }
            Iterator it2 = ((Iterable) Recomposer._runningRecomposers.getValue()).iterator();
            while (it2.hasNext()) {
                ((RecomposerInfoImpl) it2.next()).retryFailedCompositions();
            }
        }

        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Recomposer._hotReloadEnabled.set(Boolean.TRUE);
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                AbstractC2371hc.D(arrayList, ((RecomposerInfoImpl) it.next()).saveStateAndDisposeForHotReload());
            }
            return arrayList;
        }

        public final void setHotReloadEnabled$runtime_release(boolean z) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(z));
        }

        private Companion() {
        }
    }

    public static final class HotReloadable {
        private InterfaceC0526Fp composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl compositionImpl) {
            AbstractC4492zt.h(compositionImpl, "composition");
            this.composition = compositionImpl;
            this.composable = compositionImpl.getComposable();
        }

        public final void clearContent() {
            if (this.composition.isRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m2629getLambda1$runtime_release());
            }
        }

        public final void recompose() {
            if (this.composition.isRoot()) {
                this.composition.setContent(this.composable);
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }
    }

    public static final class RecomposerErrorState implements RecomposerErrorInfo {
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean z, Exception exc) {
            AbstractC4492zt.h(exc, "cause");
            this.recoverable = z;
            this.cause = exc;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public Exception getCause() {
            return this.cause;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public boolean getRecoverable() {
            return this.recoverable;
        }
    }

    public final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState recomposerErrorState;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                recomposerErrorState = recomposer.errorState;
            }
            return recomposerErrorState;
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public InterfaceC0939Tm getState() {
            return Recomposer.this.getCurrentState();
        }

        public final void invalidateGroupsWithKey(int i) {
            List listF0;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                listF0 = AbstractC3240kc.F0(recomposer.knownCompositions);
            }
            ArrayList arrayList = new ArrayList(listF0.size());
            int size = listF0.size();
            for (int i2 = 0; i2 < size; i2++) {
                ControlledComposition controlledComposition = (ControlledComposition) listF0.get(i2);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((CompositionImpl) arrayList.get(i3)).invalidateGroupsWithKey(i);
            }
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List listF0;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                listF0 = AbstractC3240kc.F0(recomposer.knownCompositions);
            }
            ArrayList arrayList = new ArrayList(listF0.size());
            int size = listF0.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) listF0.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                HotReloadable hotReloadable = new HotReloadable((CompositionImpl) arrayList.get(i2));
                hotReloadable.clearContent();
                arrayList2.add(hotReloadable);
            }
            return arrayList2;
        }
    }

    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$awaitIdle$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.runtime.Recomposer$awaitIdle$2", f = "Recomposer.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC0793Of);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(State state, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(state, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            return E8.a(((State) this.L$0).compareTo(State.Idle) > 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$join$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.runtime.Recomposer$join$2", f = "Recomposer.kt", l = {}, m = "invokeSuspend")
    public static final class C16332 extends XS implements InterfaceC0526Fp {
        /* synthetic */ Object L$0;
        int label;

        public C16332(InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C16332 c16332 = new C16332(interfaceC0793Of);
            c16332.L$0 = obj;
            return c16332;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(State state, InterfaceC0793Of interfaceC0793Of) {
            return ((C16332) create(state, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            return E8.a(((State) this.L$0) == State.ShutDown);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$readObserverOf$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ ControlledComposition $composition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ControlledComposition controlledComposition) {
            super(1);
            this.$composition = controlledComposition;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m2648invoke(obj);
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2648invoke(Object obj) {
            AbstractC4492zt.h(obj, "value");
            this.$composition.recordReadOf(obj);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", l = {945}, m = "invokeSuspend")
    public static final class C16342 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0552Gp $block;
        final /* synthetic */ MonotonicFrameClock $parentFrameClock;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$3, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$3", f = "Recomposer.kt", l = {946}, m = "invokeSuspend")
        public static final class AnonymousClass3 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ InterfaceC0552Gp $block;
            final /* synthetic */ MonotonicFrameClock $parentFrameClock;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(InterfaceC0552Gp interfaceC0552Gp, MonotonicFrameClock monotonicFrameClock, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$block = interfaceC0552Gp;
                this.$parentFrameClock = monotonicFrameClock;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, this.$parentFrameClock, interfaceC0793Of);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((AnonymousClass3) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                    InterfaceC0552Gp interfaceC0552Gp = this.$block;
                    MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
                    this.label = 1;
                    if (interfaceC0552Gp.invoke(interfaceC2052dg, monotonicFrameClock, this) == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16342(InterfaceC0552Gp interfaceC0552Gp, MonotonicFrameClock monotonicFrameClock, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$block = interfaceC0552Gp;
            this.$parentFrameClock = monotonicFrameClock;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C16342 c16342 = Recomposer.this.new C16342(this.$block, this.$parentFrameClock, interfaceC0793Of);
            c16342.L$0 = obj;
            return c16342;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((C16342) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x00a5 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:28:0x009f, B:30:0x00a5, B:33:0x00ab), top: B:58:0x009f }] */
        /* JADX WARN: Code duplicated, block: B:46:0x00d4 A[Catch: all -> 0x00d8, TryCatch #1 {all -> 0x00d8, blocks: (B:44:0x00ce, B:46:0x00d4, B:49:0x00da), top: B:56:0x00ce }] */
        /* JADX WARN: Code duplicated, block: B:56:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC1830bu interfaceC1830buL;
            ObserverHandle observerHandle;
            Throwable th;
            List listF0;
            Object obj2;
            Recomposer recomposer;
            Object obj3;
            Recomposer recomposer2;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                observerHandle = (ObserverHandle) this.L$1;
                interfaceC1830buL = (InterfaceC1830bu) this.L$0;
                try {
                    LL.b(obj);
                    observerHandle.dispose();
                    obj3 = Recomposer.this.stateLock;
                    recomposer2 = Recomposer.this;
                    synchronized (obj3) {
                        try {
                            if (recomposer2.runnerJob == interfaceC1830buL) {
                                recomposer2.runnerJob = null;
                            }
                            recomposer2.deriveStateLocked();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    Recomposer.Companion.removeRunning(Recomposer.this.recomposerInfo);
                    return FW.a;
                } catch (Throwable th3) {
                    th = th3;
                    observerHandle.dispose();
                    obj2 = Recomposer.this.stateLock;
                    recomposer = Recomposer.this;
                    synchronized (obj2) {
                        try {
                            if (recomposer.runnerJob == interfaceC1830buL) {
                                recomposer.runnerJob = null;
                            }
                            recomposer.deriveStateLocked();
                            Recomposer.Companion.removeRunning(Recomposer.this.recomposerInfo);
                            throw th;
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                }
            }
            LL.b(obj);
            interfaceC1830buL = AbstractC3347lu.l(((InterfaceC2052dg) this.L$0).getCoroutineContext());
            Recomposer.this.registerRunnerJob(interfaceC1830buL);
            ObserverHandle observerHandleRegisterApplyObserver = Snapshot.Companion.registerApplyObserver(new Recomposer$recompositionRunner$2$unregisterApplyObserver$1(Recomposer.this));
            Recomposer.Companion.addRunning(Recomposer.this.recomposerInfo);
            try {
                Object obj4 = Recomposer.this.stateLock;
                Recomposer recomposer3 = Recomposer.this;
                synchronized (obj4) {
                    listF0 = AbstractC3240kc.F0(recomposer3.knownCompositions);
                }
                int size = listF0.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((ControlledComposition) listF0.get(i2)).invalidateAll();
                }
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, this.$parentFrameClock, null);
                this.L$0 = interfaceC1830buL;
                this.L$1 = observerHandleRegisterApplyObserver;
                this.label = 1;
                if (AbstractC2133eg.d(anonymousClass3, this) == objD) {
                    return objD;
                }
                observerHandle = observerHandleRegisterApplyObserver;
                observerHandle.dispose();
                obj3 = Recomposer.this.stateLock;
                recomposer2 = Recomposer.this;
                synchronized (obj3) {
                    if (recomposer2.runnerJob == interfaceC1830buL) {
                        recomposer2.runnerJob = null;
                    }
                    recomposer2.deriveStateLocked();
                    Recomposer.Companion.removeRunning(Recomposer.this.recomposerInfo);
                    return FW.a;
                }
            } catch (Throwable th5) {
                observerHandle = observerHandleRegisterApplyObserver;
                th = th5;
                observerHandle.dispose();
                obj2 = Recomposer.this.stateLock;
                recomposer = Recomposer.this;
                synchronized (obj2) {
                    if (recomposer.runnerJob == interfaceC1830buL) {
                        recomposer.runnerJob = null;
                    }
                    recomposer.deriveStateLocked();
                }
                Recomposer.Companion.removeRunning(Recomposer.this.recomposerInfo);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runFrameLoop$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.runtime.Recomposer", f = "Recomposer.kt", l = {822, 829}, m = "runFrameLoop")
    public static final class C16351 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C16351(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Recomposer.this.runFrameLoop(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runFrameLoop$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16362 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ ProduceFrameSignal $frameSignal;
        final /* synthetic */ List<ControlledComposition> $toApply;
        final /* synthetic */ List<ControlledComposition> $toRecompose;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16362(List<ControlledComposition> list, List<ControlledComposition> list2, ProduceFrameSignal produceFrameSignal) {
            super(1);
            this.$toRecompose = list;
            this.$toApply = list2;
            this.$frameSignal = produceFrameSignal;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).longValue());
        }

        public final InterfaceC4293xa invoke(long j) {
            int i;
            InterfaceC4293xa interfaceC4293xaDeriveStateLocked;
            if (Recomposer.this.getHasBroadcastFrameClockAwaiters()) {
                Recomposer recomposer = Recomposer.this;
                Trace trace = Trace.INSTANCE;
                Object objBeginSection = trace.beginSection("Recomposer:animation");
                try {
                    recomposer.broadcastFrameClock.sendFrame(j);
                    Snapshot.Companion.sendApplyNotifications();
                    FW fw = FW.a;
                    trace.endSection(objBeginSection);
                } catch (Throwable th) {
                    Trace.INSTANCE.endSection(objBeginSection);
                    throw th;
                }
            }
            Recomposer recomposer2 = Recomposer.this;
            List<ControlledComposition> list = this.$toRecompose;
            List<ControlledComposition> list2 = this.$toApply;
            ProduceFrameSignal produceFrameSignal = this.$frameSignal;
            Object objBeginSection2 = Trace.INSTANCE.beginSection("Recomposer:recompose");
            try {
                recomposer2.recordComposerModifications();
                synchronized (recomposer2.stateLock) {
                    try {
                        List list3 = recomposer2.compositionsAwaitingApply;
                        int size = list3.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            list2.add((ControlledComposition) list3.get(i2));
                        }
                        recomposer2.compositionsAwaitingApply.clear();
                        List list4 = recomposer2.compositionInvalidations;
                        int size2 = list4.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            list.add((ControlledComposition) list4.get(i3));
                        }
                        recomposer2.compositionInvalidations.clear();
                        produceFrameSignal.takeFrameRequestLocked();
                        FW fw2 = FW.a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                IdentityArraySet identityArraySet = new IdentityArraySet();
                try {
                    int size3 = list.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        ControlledComposition controlledCompositionPerformRecompose = recomposer2.performRecompose(list.get(i4), identityArraySet);
                        if (controlledCompositionPerformRecompose != null) {
                            list2.add(controlledCompositionPerformRecompose);
                        }
                    }
                    list.clear();
                    if (!list2.isEmpty()) {
                        recomposer2.changeCount = recomposer2.getChangeCount() + 1;
                    }
                    try {
                        int size4 = list2.size();
                        for (i = 0; i < size4; i++) {
                            list2.get(i).applyChanges();
                        }
                        list2.clear();
                        synchronized (recomposer2.stateLock) {
                            interfaceC4293xaDeriveStateLocked = recomposer2.deriveStateLocked();
                        }
                        Trace.INSTANCE.endSection(objBeginSection2);
                        return interfaceC4293xaDeriveStateLocked;
                    } catch (Throwable th3) {
                        list2.clear();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    list.clear();
                    throw th4;
                }
            } catch (Throwable th5) {
                Trace.INSTANCE.endSection(objBeginSection2);
                throw th5;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", l = {MetaDo.META_SETVIEWPORTEXT, 537}, m = "invokeSuspend")
    public static final class C16372 extends XS implements InterfaceC0552Gp {
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ List<ControlledComposition> $toApply;
            final /* synthetic */ Set<ControlledComposition> $toComplete;
            final /* synthetic */ List<MovableContentStateReference> $toInsert;
            final /* synthetic */ Set<ControlledComposition> $toLateApply;
            final /* synthetic */ List<ControlledComposition> $toRecompose;
            final /* synthetic */ Recomposer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Recomposer recomposer, List<ControlledComposition> list, List<MovableContentStateReference> list2, Set<ControlledComposition> set, List<ControlledComposition> list3, Set<ControlledComposition> set2) {
                super(1);
                this.this$0 = recomposer;
                this.$toRecompose = list;
                this.$toInsert = list2;
                this.$toLateApply = set;
                this.$toApply = list3;
                this.$toComplete = set2;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return FW.a;
            }

            /* JADX WARN: Code duplicated, block: B:156:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:163:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:165:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:56:0x010b A[Catch: all -> 0x0115, Exception -> 0x0117, TRY_LEAVE, TryCatch #8 {Exception -> 0x0117, blocks: (B:53:0x00f5, B:54:0x0105, B:56:0x010b), top: B:163:0x00f5, outer: #11 }] */
            /* JADX WARN: Code duplicated, block: B:69:0x0130 A[Catch: all -> 0x00d2, TRY_LEAVE, TryCatch #11 {all -> 0x00d2, blocks: (B:11:0x0043, B:12:0x004a, B:19:0x0071, B:20:0x0072, B:21:0x007c, B:23:0x0085, B:26:0x0090, B:28:0x0099, B:40:0x00ce, B:49:0x00e8, B:50:0x00eb, B:46:0x00df, B:51:0x00ec, B:62:0x011a, B:69:0x0130, B:80:0x0155, B:87:0x016c, B:88:0x0170, B:90:0x0174, B:91:0x0175, B:96:0x0188, B:97:0x0189, B:85:0x0168, B:86:0x016b, B:84:0x0163, B:67:0x012c, B:68:0x012f, B:66:0x0128, B:109:0x01b1, B:111:0x01ba, B:112:0x01be, B:124:0x01ea, B:126:0x01ec, B:127:0x01ed, B:128:0x01ee, B:130:0x01f4, B:131:0x01f7, B:133:0x0200, B:137:0x0216, B:142:0x022d, B:143:0x0230, B:141:0x0228, B:144:0x0231, B:145:0x0232, B:113:0x01bf, B:115:0x01ca, B:117:0x01d6, B:119:0x01dc, B:122:0x01e5, B:123:0x01e8, B:13:0x004b, B:15:0x0056, B:18:0x0068, B:89:0x0171, B:98:0x018a, B:100:0x0191, B:102:0x01a0, B:140:0x0222, B:29:0x00a3, B:31:0x00aa, B:36:0x00bb, B:38:0x00c2, B:53:0x00f5, B:54:0x0105, B:56:0x010b, B:71:0x0139, B:72:0x0140, B:74:0x0146, B:83:0x015d, B:65:0x0122, B:45:0x00d9), top: B:168:0x0043, inners: #0, #1, #2, #4, #5, #6, #8, #10, #12, #13 }] */
            /* JADX WARN: Code duplicated, block: B:74:0x0146 A[Catch: all -> 0x0150, Exception -> 0x0152, TRY_LEAVE, TryCatch #9 {Exception -> 0x0152, blocks: (B:71:0x0139, B:72:0x0140, B:74:0x0146), top: B:165:0x0139, outer: #10 }] */
            public final void invoke(long j) {
                Iterator<T> it;
                Iterator<T> it2;
                if (this.this$0.getHasBroadcastFrameClockAwaiters()) {
                    Recomposer recomposer = this.this$0;
                    Trace trace = Trace.INSTANCE;
                    Object objBeginSection = trace.beginSection("Recomposer:animation");
                    try {
                        recomposer.broadcastFrameClock.sendFrame(j);
                        Snapshot.Companion.sendApplyNotifications();
                        FW fw = FW.a;
                        trace.endSection(objBeginSection);
                    } catch (Throwable th) {
                        Trace.INSTANCE.endSection(objBeginSection);
                        throw th;
                    }
                }
                Recomposer recomposer2 = this.this$0;
                List<ControlledComposition> list = this.$toRecompose;
                List<MovableContentStateReference> list2 = this.$toInsert;
                Set<ControlledComposition> set = this.$toLateApply;
                List<ControlledComposition> list3 = this.$toApply;
                Set<ControlledComposition> set2 = this.$toComplete;
                Object objBeginSection2 = Trace.INSTANCE.beginSection("Recomposer:recompose");
                try {
                    recomposer2.recordComposerModifications();
                    synchronized (recomposer2.stateLock) {
                        try {
                            List list4 = recomposer2.compositionInvalidations;
                            int size = list4.size();
                            for (int i = 0; i < size; i++) {
                                list.add((ControlledComposition) list4.get(i));
                            }
                            recomposer2.compositionInvalidations.clear();
                            FW fw2 = FW.a;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    IdentityArraySet identityArraySet = new IdentityArraySet();
                    IdentityArraySet identityArraySet2 = new IdentityArraySet();
                    while (true) {
                        if (list.isEmpty() && list2.isEmpty()) {
                            break;
                        }
                        try {
                            try {
                                int size2 = list.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    ControlledComposition controlledComposition = list.get(i2);
                                    identityArraySet2.add(controlledComposition);
                                    ControlledComposition controlledCompositionPerformRecompose = recomposer2.performRecompose(controlledComposition, identityArraySet);
                                    if (controlledCompositionPerformRecompose != null) {
                                        list3.add(controlledCompositionPerformRecompose);
                                    }
                                }
                                list.clear();
                                if (identityArraySet.isNotEmpty()) {
                                    synchronized (recomposer2.stateLock) {
                                        try {
                                            List list5 = recomposer2.knownCompositions;
                                            int size3 = list5.size();
                                            for (int i3 = 0; i3 < size3; i3++) {
                                                ControlledComposition controlledComposition2 = (ControlledComposition) list5.get(i3);
                                                if (!identityArraySet2.contains(controlledComposition2) && controlledComposition2.observesAnyOf(identityArraySet)) {
                                                    list.add(controlledComposition2);
                                                }
                                            }
                                            FW fw3 = FW.a;
                                        } catch (Throwable th3) {
                                            throw th3;
                                        }
                                    }
                                }
                                if (list.isEmpty()) {
                                    try {
                                        C16372.invokeSuspend$fillToInsert(list2, recomposer2);
                                        while (!list2.isEmpty()) {
                                            AbstractC2371hc.D(set, recomposer2.performInsertValues(list2, identityArraySet));
                                            C16372.invokeSuspend$fillToInsert(list2, recomposer2);
                                        }
                                    } catch (Exception e) {
                                        Recomposer.processCompositionError$default(recomposer2, e, null, true, 2, null);
                                        C16372.invokeSuspend$clearRecompositionState(list, list2, list3, set, set2);
                                    }
                                }
                            } catch (Exception e2) {
                                Recomposer.processCompositionError$default(recomposer2, e2, null, true, 2, null);
                                C16372.invokeSuspend$clearRecompositionState(list, list2, list3, set, set2);
                                list.clear();
                            }
                        } catch (Throwable th4) {
                            list.clear();
                            throw th4;
                        }
                        Trace.INSTANCE.endSection(objBeginSection2);
                    }
                    if (list3.isEmpty()) {
                        if (!set.isEmpty()) {
                            if (!set2.isEmpty()) {
                                it2 = set2.iterator();
                                while (it2.hasNext()) {
                                    ((ControlledComposition) it2.next()).changesApplied();
                                }
                                set2.clear();
                            }
                            synchronized (recomposer2.stateLock) {
                                recomposer2.deriveStateLocked();
                                Snapshot.Companion.notifyObjectsInitialized();
                                recomposer2.compositionsRemoved = null;
                                FW fw4 = FW.a;
                                Trace.INSTANCE.endSection(objBeginSection2);
                                return;
                            }
                        }
                        AbstractC2371hc.D(set2, set);
                        it = set.iterator();
                        while (it.hasNext()) {
                            ((ControlledComposition) it.next()).applyLateChanges();
                        }
                        set.clear();
                        if (!set2.isEmpty()) {
                            it2 = set2.iterator();
                            while (it2.hasNext()) {
                                ((ControlledComposition) it2.next()).changesApplied();
                            }
                            set2.clear();
                        }
                        synchronized (recomposer2.stateLock) {
                            recomposer2.deriveStateLocked();
                            Snapshot.Companion.notifyObjectsInitialized();
                            recomposer2.compositionsRemoved = null;
                            FW fw5 = FW.a;
                            Trace.INSTANCE.endSection(objBeginSection2);
                            return;
                        }
                    }
                    recomposer2.changeCount = recomposer2.getChangeCount() + 1;
                    try {
                        try {
                            int size4 = list3.size();
                            for (int i4 = 0; i4 < size4; i4++) {
                                set2.add(list3.get(i4));
                            }
                            int size5 = list3.size();
                            for (int i5 = 0; i5 < size5; i5++) {
                                list3.get(i5).applyChanges();
                            }
                            list3.clear();
                            if (!set.isEmpty()) {
                                if (!set2.isEmpty()) {
                                    it2 = set2.iterator();
                                    while (it2.hasNext()) {
                                        ((ControlledComposition) it2.next()).changesApplied();
                                    }
                                    set2.clear();
                                }
                                synchronized (recomposer2.stateLock) {
                                    recomposer2.deriveStateLocked();
                                    Snapshot.Companion.notifyObjectsInitialized();
                                    recomposer2.compositionsRemoved = null;
                                    FW fw6 = FW.a;
                                    Trace.INSTANCE.endSection(objBeginSection2);
                                    return;
                                }
                            }
                            try {
                                try {
                                    AbstractC2371hc.D(set2, set);
                                    it = set.iterator();
                                    while (it.hasNext()) {
                                        ((ControlledComposition) it.next()).applyLateChanges();
                                    }
                                    set.clear();
                                    if (!set2.isEmpty()) {
                                        try {
                                            try {
                                                it2 = set2.iterator();
                                                while (it2.hasNext()) {
                                                    ((ControlledComposition) it2.next()).changesApplied();
                                                }
                                                set2.clear();
                                            } catch (Exception e3) {
                                                Recomposer.processCompositionError$default(recomposer2, e3, null, false, 6, null);
                                                C16372.invokeSuspend$clearRecompositionState(list, list2, list3, set, set2);
                                                set2.clear();
                                                Trace.INSTANCE.endSection(objBeginSection2);
                                            }
                                        } catch (Throwable th5) {
                                            set2.clear();
                                            throw th5;
                                        }
                                    }
                                    synchronized (recomposer2.stateLock) {
                                        recomposer2.deriveStateLocked();
                                    }
                                    Snapshot.Companion.notifyObjectsInitialized();
                                    recomposer2.compositionsRemoved = null;
                                    FW fw7 = FW.a;
                                    Trace.INSTANCE.endSection(objBeginSection2);
                                    return;
                                } catch (Exception e4) {
                                    Recomposer.processCompositionError$default(recomposer2, e4, null, false, 6, null);
                                    C16372.invokeSuspend$clearRecompositionState(list, list2, list3, set, set2);
                                    set.clear();
                                }
                            } catch (Throwable th6) {
                                set.clear();
                                throw th6;
                            }
                        } catch (Exception e5) {
                            Recomposer.processCompositionError$default(recomposer2, e5, null, false, 6, null);
                            C16372.invokeSuspend$clearRecompositionState(list, list2, list3, set, set2);
                            list3.clear();
                        }
                    } catch (Throwable th7) {
                        list3.clear();
                        throw th7;
                    }
                    Trace.INSTANCE.endSection(objBeginSection2);
                } catch (Throwable th8) {
                    Trace.INSTANCE.endSection(objBeginSection2);
                    throw th8;
                }
            }
        }

        public C16372(InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$clearRecompositionState(List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, Set<ControlledComposition> set, Set<ControlledComposition> set2) {
            list.clear();
            list2.clear();
            list3.clear();
            set.clear();
            set2.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
            list.clear();
            synchronized (recomposer.stateLock) {
                try {
                    List list2 = recomposer.compositionValuesAwaitingInsert;
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        list.add((MovableContentStateReference) list2.get(i));
                    }
                    recomposer.compositionValuesAwaitingInsert.clear();
                    FW fw = FW.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(InterfaceC2052dg interfaceC2052dg, MonotonicFrameClock monotonicFrameClock, InterfaceC0793Of interfaceC0793Of) {
            C16372 c16372 = Recomposer.this.new C16372(interfaceC0793Of);
            c16372.L$0 = monotonicFrameClock;
            return c16372.invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x008e  */
        /* JADX WARN: Code duplicated, block: B:15:0x00a4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:16:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:19:0x00b2  */
        /* JADX WARN: Code duplicated, block: B:21:0x00d9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:22:0x00da  */
        /* JADX WARN: Code duplicated, block: B:24:0x00e5  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00da -> B:23:0x00de). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00e5 -> B:11:0x0086). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // defpackage.AbstractC2171f7
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instruction units count: 238
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C16372.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", l = {791, 811, 812}, m = "invokeSuspend")
    public static final class C16382 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ InterfaceC0988Vf $recomposeCoroutineContext;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Recomposer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16382(InterfaceC0988Vf interfaceC0988Vf, Recomposer recomposer, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$recomposeCoroutineContext = interfaceC0988Vf;
            this.this$0 = recomposer;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(InterfaceC2052dg interfaceC2052dg, MonotonicFrameClock monotonicFrameClock, InterfaceC0793Of interfaceC0793Of) {
            C16382 c16382 = new C16382(this.$recomposeCoroutineContext, this.this$0, interfaceC0793Of);
            c16382.L$0 = interfaceC2052dg;
            c16382.L$1 = monotonicFrameClock;
            return c16382.invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0094  */
        /* JADX WARN: Code duplicated, block: B:24:0x00a4 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:29:0x00bc A[LOOP:0: B:28:0x00ba->B:29:0x00bc, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:33:0x00da  */
        /* JADX WARN: Code duplicated, block: B:43:0x012a  */
        /* JADX WARN: Code duplicated, block: B:47:0x0139 A[Catch: all -> 0x013e, TRY_LEAVE, TryCatch #1 {, blocks: (B:45:0x0133, B:47:0x0139), top: B:73:0x0133 }] */
        /* JADX WARN: Code duplicated, block: B:51:0x0140  */
        /* JADX WARN: Code duplicated, block: B:54:0x0144  */
        /* JADX WARN: Code duplicated, block: B:71:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:73:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a2 -> B:12:0x0039). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // defpackage.AbstractC2171f7
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 417
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C16382.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$writeObserverOf$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16391 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ ControlledComposition $composition;
        final /* synthetic */ IdentityArraySet<Object> $modifiedValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16391(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
            super(1);
            this.$composition = controlledComposition;
            this.$modifiedValues = identityArraySet;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m2649invoke(obj);
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2649invoke(Object obj) {
            AbstractC4492zt.h(obj, "value");
            this.$composition.recordWriteOf(obj);
            IdentityArraySet<Object> identityArraySet = this.$modifiedValues;
            if (identityArraySet != null) {
                identityArraySet.add(obj);
            }
        }
    }

    public Recomposer(InterfaceC0988Vf interfaceC0988Vf) {
        AbstractC4492zt.h(interfaceC0988Vf, "effectCoroutineContext");
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Recomposer$broadcastFrameClock$1(this));
        this.broadcastFrameClock = broadcastFrameClock;
        this.stateLock = new Object();
        this.knownCompositions = new ArrayList();
        this.snapshotInvalidations = new IdentityArraySet<>();
        this.compositionInvalidations = new ArrayList();
        this.compositionsAwaitingApply = new ArrayList();
        this.compositionValuesAwaitingInsert = new ArrayList();
        this.compositionValuesRemoved = new LinkedHashMap();
        this.compositionValueStatesAvailable = new LinkedHashMap();
        this._state = ER.a(State.Inactive);
        InterfaceC1243ae interfaceC1243aeA = AbstractC3347lu.a((InterfaceC1830bu) interfaceC0988Vf.get(InterfaceC1830bu.s));
        interfaceC1243aeA.C(new Recomposer$effectJob$1$1(this));
        this.effectJob = interfaceC1243aeA;
        this.effectCoroutineContext = interfaceC0988Vf.plus(broadcastFrameClock).plus(interfaceC1243aeA);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    private final void applyAndCheck(MutableSnapshot mutableSnapshot) {
        try {
            if (mutableSnapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
            mutableSnapshot.dispose();
        } catch (Throwable th) {
            mutableSnapshot.dispose();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(InterfaceC0793Of interfaceC0793Of) {
        C4374ya c4374ya;
        if (getHasSchedulingWork()) {
            return FW.a;
        }
        C4374ya c4374ya2 = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya2.A();
        synchronized (this.stateLock) {
            if (getHasSchedulingWork()) {
                c4374ya = c4374ya2;
            } else {
                this.workContinuation = c4374ya2;
                c4374ya = null;
            }
        }
        if (c4374ya != null) {
            KL.a aVar = KL.a;
            c4374ya.resumeWith(KL.a(FW.a));
        }
        Object objX = c4374ya2.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX == AbstractC0378Bt.d() ? objX : FW.a;
    }

    private final <T> T composing(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet, InterfaceC3588op interfaceC3588op) {
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, identityArraySet));
        try {
            Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
            try {
                T t = (T) interfaceC3588op.invoke();
                AbstractC0703Ks.b(1);
                mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                AbstractC0703Ks.a(1);
                AbstractC0703Ks.b(1);
                applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                return t;
            } finally {
                AbstractC0703Ks.b(1);
                mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                AbstractC0703Ks.a(1);
            }
        } catch (Throwable th) {
            AbstractC0703Ks.b(1);
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
            AbstractC0703Ks.a(1);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4293xa deriveStateLocked() {
        State state;
        if (((State) this._state.getValue()).compareTo(State.ShuttingDown) <= 0) {
            this.knownCompositions.clear();
            this.snapshotInvalidations = new IdentityArraySet<>();
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = null;
            InterfaceC4293xa interfaceC4293xa = this.workContinuation;
            if (interfaceC4293xa != null) {
                InterfaceC4293xa.a.a(interfaceC4293xa, null, 1, null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new IdentityArraySet<>();
            this.compositionInvalidations.clear();
            state = getHasBroadcastFrameClockAwaitersLocked() ? State.InactivePendingWork : State.Inactive;
        } else {
            state = (!this.compositionInvalidations.isEmpty() || this.snapshotInvalidations.isNotEmpty() || !this.compositionsAwaitingApply.isEmpty() || !this.compositionValuesAwaitingInsert.isEmpty() || this.concurrentCompositionsOutstanding > 0 || getHasBroadcastFrameClockAwaitersLocked()) ? State.PendingWork : State.Idle;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        InterfaceC4293xa interfaceC4293xa2 = this.workContinuation;
        this.workContinuation = null;
        return interfaceC4293xa2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedValues() {
        int i;
        List listM;
        synchronized (this.stateLock) {
            try {
                if (this.compositionValuesRemoved.isEmpty()) {
                    listM = AbstractC1886cc.m();
                } else {
                    List listZ = AbstractC2044dc.z(this.compositionValuesRemoved.values());
                    this.compositionValuesRemoved.clear();
                    listM = new ArrayList(listZ.size());
                    int size = listZ.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        MovableContentStateReference movableContentStateReference = (MovableContentStateReference) listZ.get(i2);
                        listM.add(HV.a(movableContentStateReference, this.compositionValueStatesAvailable.get(movableContentStateReference)));
                    }
                    this.compositionValueStatesAvailable.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int size2 = listM.size();
        for (i = 0; i < size2; i++) {
            C2020dG c2020dG = (C2020dG) listM.get(i);
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) c2020dG.a();
            MovableContentState movableContentState = (MovableContentState) c2020dG.b();
            if (movableContentState != null) {
                movableContentStateReference2.getComposition$runtime_release().disposeUnusedMovableContent(movableContentState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        synchronized (this.stateLock) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return !this.compositionsAwaitingApply.isEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    private final boolean getHasFrameWorkLocked() {
        return !this.compositionInvalidations.isEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.snapshotInvalidations.isNotEmpty() || !this.compositionInvalidations.isEmpty() || getHasBroadcastFrameClockAwaitersLocked();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.isClosed;
        }
        if (z) {
            Iterator it = this.effectJob.getChildren().iterator();
            while (it.hasNext()) {
                if (((InterfaceC1830bu) it.next()).isActive()) {
                }
            }
            return false;
        }
        return true;
    }

    public static /* synthetic */ void getState$annotations() {
    }

    private final void performInitialMovableContentInserts(ControlledComposition controlledComposition) {
        synchronized (this.stateLock) {
            List<MovableContentStateReference> list = this.compositionValuesAwaitingInsert;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (AbstractC4492zt.d(list.get(i).getComposition$runtime_release(), controlledComposition)) {
                    FW fw = FW.a;
                    ArrayList arrayList = new ArrayList();
                    performInitialMovableContentInserts$fillToInsert(arrayList, this, controlledComposition);
                    while (!arrayList.isEmpty()) {
                        performInsertValues(arrayList, null);
                        performInitialMovableContentInserts$fillToInsert(arrayList, this, controlledComposition);
                    }
                    return;
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            try {
                Iterator<MovableContentStateReference> it = recomposer.compositionValuesAwaitingInsert.iterator();
                while (it.hasNext()) {
                    MovableContentStateReference next = it.next();
                    if (AbstractC4492zt.d(next.getComposition$runtime_release(), controlledComposition)) {
                        list.add(next);
                        it.remove();
                    }
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ControlledComposition> performInsertValues(List<MovableContentStateReference> list, IdentityArraySet<Object> identityArraySet) {
        ArrayList arrayList;
        HashMap map = new HashMap(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            MovableContentStateReference movableContentStateReference = list.get(i);
            ControlledComposition composition$runtime_release = movableContentStateReference.getComposition$runtime_release();
            Object arrayList2 = map.get(composition$runtime_release);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map.put(composition$runtime_release, arrayList2);
            }
            ((ArrayList) arrayList2).add(movableContentStateReference);
        }
        for (Map.Entry entry : map.entrySet()) {
            ControlledComposition controlledComposition = (ControlledComposition) entry.getKey();
            List list2 = (List) entry.getValue();
            ComposerKt.runtimeCheck(!controlledComposition.isComposing());
            MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, identityArraySet));
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
                try {
                    synchronized (this.stateLock) {
                        arrayList = new ArrayList(list2.size());
                        int size2 = list2.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) list2.get(i2);
                            arrayList.add(HV.a(movableContentStateReference2, RecomposerKt.removeLastMultiValue(this.compositionValuesRemoved, movableContentStateReference2.getContent$runtime_release())));
                        }
                    }
                    controlledComposition.insertMovableContent(arrayList);
                    FW fw = FW.a;
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                } catch (Throwable th) {
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            } catch (Throwable th2) {
                applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                throw th2;
            }
        }
        return AbstractC3240kc.C0(map.keySet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition performRecompose(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
        Set<ControlledComposition> set;
        if (controlledComposition.isComposing() || controlledComposition.isDisposed() || ((set = this.compositionsRemoved) != null && set.contains(controlledComposition))) {
            return null;
        }
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, identityArraySet));
        try {
            Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
            if (identityArraySet != null) {
                try {
                    if (identityArraySet.isNotEmpty()) {
                        controlledComposition.prepareCompose(new Recomposer$performRecompose$1$1(identityArraySet, controlledComposition));
                    }
                } catch (Throwable th) {
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            }
            boolean zRecompose = controlledComposition.recompose();
            mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
            if (zRecompose) {
                return controlledComposition;
            }
            return null;
        } catch (Throwable th2) {
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
            throw th2;
        }
    }

    private final void processCompositionError(Exception exc, ControlledComposition controlledComposition, boolean z) throws Exception {
        Boolean bool = _hotReloadEnabled.get();
        AbstractC4492zt.g(bool, "_hotReloadEnabled.get()");
        if (!bool.booleanValue() || (exc instanceof ComposeRuntimeError)) {
            throw exc;
        }
        synchronized (this.stateLock) {
            try {
                ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", exc);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations = new IdentityArraySet<>();
                this.compositionValuesAwaitingInsert.clear();
                this.compositionValuesRemoved.clear();
                this.compositionValueStatesAvailable.clear();
                this.errorState = new RecomposerErrorState(z, exc);
                if (controlledComposition != null) {
                    List arrayList = this.failedCompositions;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        this.failedCompositions = arrayList;
                    }
                    if (!arrayList.contains(controlledComposition)) {
                        arrayList.add(controlledComposition);
                    }
                    this.knownCompositions.remove(controlledComposition);
                }
                deriveStateLocked();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Exception exc, ControlledComposition controlledComposition, boolean z, int i, Object obj) throws Exception {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(exc, controlledComposition, z);
    }

    private final InterfaceC3750qp readObserverOf(ControlledComposition controlledComposition) {
        return new AnonymousClass1(controlledComposition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recompositionRunner(InterfaceC0552Gp interfaceC0552Gp, InterfaceC0793Of interfaceC0793Of) {
        Object objG = M8.g(this.broadcastFrameClock, new C16342(interfaceC0552Gp, MonotonicFrameClockKt.getMonotonicFrameClock(interfaceC0793Of.getContext()), null), interfaceC0793Of);
        return objG == AbstractC0378Bt.d() ? objG : FW.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recordComposerModifications() {
        List listF0;
        boolean hasFrameWorkLocked;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            IdentityArraySet<Object> identityArraySet = this.snapshotInvalidations;
            this.snapshotInvalidations = new IdentityArraySet<>();
            synchronized (this.stateLock) {
                listF0 = AbstractC3240kc.F0(this.knownCompositions);
            }
            try {
                int size = listF0.size();
                for (int i = 0; i < size; i++) {
                    ((ControlledComposition) listF0.get(i)).recordModificationsOf(identityArraySet);
                    if (((State) this._state.getValue()).compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                this.snapshotInvalidations = new IdentityArraySet<>();
                synchronized (this.stateLock) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    this.snapshotInvalidations.addAll((Collection<? extends Object>) identityArraySet);
                    FW fw = FW.a;
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(InterfaceC1830bu interfaceC1830bu) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            }
            if (((State) this._state.getValue()).compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down");
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running");
            }
            this.runnerJob = interfaceC1830bu;
            deriveStateLocked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState recomposerErrorState;
        synchronized (this.stateLock) {
            recomposerErrorState = this.errorState;
            if (recomposerErrorState != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return recomposerErrorState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retryFailedCompositions() {
        List<ControlledComposition> list;
        synchronized (this.stateLock) {
            list = this.failedCompositions;
            this.failedCompositions = null;
        }
        if (list == null) {
            return;
        }
        while (!list.isEmpty()) {
            try {
                ControlledComposition controlledComposition = (ControlledComposition) AbstractC2371hc.P(list);
                if (controlledComposition instanceof CompositionImpl) {
                    controlledComposition.invalidateAll();
                    controlledComposition.setContent(((CompositionImpl) controlledComposition).getComposable());
                    if (this.errorState != null) {
                        break;
                    }
                }
            } catch (Throwable th) {
                if (!list.isEmpty()) {
                    synchronized (this.stateLock) {
                        try {
                            List<ControlledComposition> list2 = this.failedCompositions;
                            if (list2 != null) {
                                list2.addAll(list);
                                list = list2;
                            }
                            this.failedCompositions = list;
                            FW fw = FW.a;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                throw th;
            }
        }
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.stateLock) {
            try {
                List<ControlledComposition> list3 = this.failedCompositions;
                if (list3 != null) {
                    list3.addAll(list);
                    list = list3;
                }
                this.failedCompositions = list;
                FW fw2 = FW.a;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0087 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0088  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a2 -> B:13:0x003f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object runFrameLoop(androidx.compose.runtime.MonotonicFrameClock r8, androidx.compose.runtime.ProduceFrameSignal r9, defpackage.InterfaceC0793Of r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.compose.runtime.Recomposer.C16351
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = (androidx.compose.runtime.Recomposer.C16351) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = new androidx.compose.runtime.Recomposer$runFrameLoop$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = defpackage.AbstractC0378Bt.d()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L65
            if (r2 == r4) goto L4d
            if (r2 != r3) goto L45
            java.lang.Object r8 = r0.L$4
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            defpackage.LL.b(r10)
        L3f:
            r10 = r9
            r9 = r2
            r2 = r8
            r8 = r5
            r5 = r6
            goto L73
        L45:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L4d:
            java.lang.Object r8 = r0.L$4
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            defpackage.LL.b(r10)
            goto L8d
        L65:
            defpackage.LL.b(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r5 = r7
        L73:
            java.lang.Object r6 = r5.stateLock
            r0.L$0 = r5
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.L$4 = r2
            r0.label = r4
            java.lang.Object r6 = r9.awaitFrameRequest(r6, r0)
            if (r6 != r1) goto L88
            return r1
        L88:
            r6 = r5
            r5 = r8
            r8 = r2
            r2 = r9
            r9 = r10
        L8d:
            androidx.compose.runtime.Recomposer$runFrameLoop$2 r10 = new androidx.compose.runtime.Recomposer$runFrameLoop$2
            r10.<init>(r9, r8, r2)
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r0.L$3 = r9
            r0.L$4 = r8
            r0.label = r3
            java.lang.Object r10 = r5.withFrameNanos(r10, r0)
            if (r10 != r1) goto L3f
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.runFrameLoop(androidx.compose.runtime.MonotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal, Of):java.lang.Object");
    }

    private final InterfaceC3750qp writeObserverOf(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
        return new C16391(controlledComposition, identityArraySet);
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    public final Object awaitIdle(InterfaceC0793Of interfaceC0793Of) {
        Object objF = AbstractC1047Xm.f(AbstractC1047Xm.G(getCurrentState(), new AnonymousClass2(null)), interfaceC0793Of);
        return objF == AbstractC0378Bt.d() ? objF : FW.a;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            try {
                if (((State) this._state.getValue()).compareTo(State.Idle) >= 0) {
                    this._state.setValue(State.ShuttingDown);
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        InterfaceC1830bu.a.a(this.effectJob, null, 1, null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            synchronized (this.stateLock) {
                this.isClosed = true;
                FW fw = FW.a;
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    @ComposableInferredTarget(scheme = "[0[0]]")
    public void composeInitial$runtime_release(ControlledComposition controlledComposition, InterfaceC0526Fp interfaceC0526Fp) throws Exception {
        AbstractC4492zt.h(controlledComposition, "composition");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        boolean zIsComposing = controlledComposition.isComposing();
        try {
            Snapshot.Companion companion = Snapshot.Companion;
            MutableSnapshot mutableSnapshotTakeMutableSnapshot = companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, null));
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
                try {
                    controlledComposition.composeContent(interfaceC0526Fp);
                    FW fw = FW.a;
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                    if (!zIsComposing) {
                        companion.notifyObjectsInitialized();
                    }
                    synchronized (this.stateLock) {
                        if (((State) this._state.getValue()).compareTo(State.ShuttingDown) > 0 && !this.knownCompositions.contains(controlledComposition)) {
                            this.knownCompositions.add(controlledComposition);
                        }
                    }
                    try {
                        performInitialMovableContentInserts(controlledComposition);
                        try {
                            controlledComposition.applyChanges();
                            controlledComposition.applyLateChanges();
                            if (zIsComposing) {
                                return;
                            }
                            companion.notifyObjectsInitialized();
                        } catch (Exception e) {
                            processCompositionError$default(this, e, null, false, 6, null);
                        }
                    } catch (Exception e2) {
                        processCompositionError(e2, controlledComposition, true);
                    }
                } catch (Throwable th) {
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            } catch (Throwable th2) {
                applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                throw th2;
            }
        } catch (Exception e3) {
            processCompositionError(e3, controlledComposition, true);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
        AbstractC4492zt.h(movableContentStateReference, "reference");
        synchronized (this.stateLock) {
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, movableContentStateReference.getContent$runtime_release(), movableContentStateReference);
        }
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    public final CR getCurrentState() {
        return this._state;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public InterfaceC0988Vf getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    public final boolean getHasPendingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.snapshotInvalidations.isNotEmpty() || !this.compositionInvalidations.isEmpty() || this.concurrentCompositionsOutstanding > 0 || !this.compositionsAwaitingApply.isEmpty() || getHasBroadcastFrameClockAwaitersLocked();
        }
        return z;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public InterfaceC0988Vf getRecomposeCoroutineContext$runtime_release() {
        return C1172Zk.a;
    }

    public final InterfaceC0939Tm getState() {
        return getCurrentState();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
        InterfaceC4293xa interfaceC4293xaDeriveStateLocked;
        AbstractC4492zt.h(movableContentStateReference, "reference");
        synchronized (this.stateLock) {
            this.compositionValuesAwaitingInsert.add(movableContentStateReference);
            interfaceC4293xaDeriveStateLocked = deriveStateLocked();
        }
        if (interfaceC4293xaDeriveStateLocked != null) {
            KL.a aVar = KL.a;
            interfaceC4293xaDeriveStateLocked.resumeWith(KL.a(FW.a));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(ControlledComposition controlledComposition) {
        InterfaceC4293xa interfaceC4293xaDeriveStateLocked;
        AbstractC4492zt.h(controlledComposition, "composition");
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(controlledComposition)) {
                interfaceC4293xaDeriveStateLocked = null;
            } else {
                this.compositionInvalidations.add(controlledComposition);
                interfaceC4293xaDeriveStateLocked = deriveStateLocked();
            }
        }
        if (interfaceC4293xaDeriveStateLocked != null) {
            KL.a aVar = KL.a;
            interfaceC4293xaDeriveStateLocked.resumeWith(KL.a(FW.a));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime_release(RecomposeScopeImpl recomposeScopeImpl) {
        InterfaceC4293xa interfaceC4293xaDeriveStateLocked;
        AbstractC4492zt.h(recomposeScopeImpl, "scope");
        synchronized (this.stateLock) {
            this.snapshotInvalidations.add(recomposeScopeImpl);
            interfaceC4293xaDeriveStateLocked = deriveStateLocked();
        }
        if (interfaceC4293xaDeriveStateLocked != null) {
            KL.a aVar = KL.a;
            interfaceC4293xaDeriveStateLocked.resumeWith(KL.a(FW.a));
        }
    }

    public final Object join(InterfaceC0793Of interfaceC0793Of) {
        Object objQ = AbstractC1047Xm.q(getCurrentState(), new C16332(null), interfaceC0793Of);
        return objQ == AbstractC0378Bt.d() ? objQ : FW.a;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime_release(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState) {
        AbstractC4492zt.h(movableContentStateReference, "reference");
        AbstractC4492zt.h(movableContentState, "data");
        synchronized (this.stateLock) {
            this.compositionValueStatesAvailable.put(movableContentStateReference, movableContentState);
            FW fw = FW.a;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference movableContentStateReference) {
        MovableContentState movableContentStateRemove;
        AbstractC4492zt.h(movableContentStateReference, "reference");
        synchronized (this.stateLock) {
            movableContentStateRemove = this.compositionValueStatesAvailable.remove(movableContentStateReference);
        }
        return movableContentStateRemove;
    }

    public final void pauseCompositionFrameClock() {
        synchronized (this.stateLock) {
            this.frameClockPaused = true;
            FW fw = FW.a;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime_release(Set<CompositionData> set) {
        AbstractC4492zt.h(set, "table");
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime_release(ControlledComposition controlledComposition) {
        AbstractC4492zt.h(controlledComposition, "composition");
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime_release(ControlledComposition controlledComposition) {
        AbstractC4492zt.h(controlledComposition, "composition");
        synchronized (this.stateLock) {
            try {
                Set linkedHashSet = this.compositionsRemoved;
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                    this.compositionsRemoved = linkedHashSet;
                }
                linkedHashSet.add(controlledComposition);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void resumeCompositionFrameClock() {
        InterfaceC4293xa interfaceC4293xaDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                interfaceC4293xaDeriveStateLocked = deriveStateLocked();
            } else {
                interfaceC4293xaDeriveStateLocked = null;
            }
        }
        if (interfaceC4293xaDeriveStateLocked != null) {
            KL.a aVar = KL.a;
            interfaceC4293xaDeriveStateLocked.resumeWith(KL.a(FW.a));
        }
    }

    public final Object runRecomposeAndApplyChanges(InterfaceC0793Of interfaceC0793Of) {
        Object objRecompositionRunner = recompositionRunner(new C16372(null), interfaceC0793Of);
        return objRecompositionRunner == AbstractC0378Bt.d() ? objRecompositionRunner : FW.a;
    }

    @ExperimentalComposeApi
    public final Object runRecomposeConcurrentlyAndApplyChanges(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0793Of interfaceC0793Of) {
        Object objRecompositionRunner = recompositionRunner(new C16382(interfaceC0988Vf, this, null), interfaceC0793Of);
        return objRecompositionRunner == AbstractC0378Bt.d() ? objRecompositionRunner : FW.a;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(ControlledComposition controlledComposition) {
        AbstractC4492zt.h(controlledComposition, "composition");
        synchronized (this.stateLock) {
            this.knownCompositions.remove(controlledComposition);
            this.compositionInvalidations.remove(controlledComposition);
            this.compositionsAwaitingApply.remove(controlledComposition);
            FW fw = FW.a;
        }
    }

    private final void recordComposerModifications(InterfaceC3750qp interfaceC3750qp) {
        IdentityArraySet identityArraySet = this.snapshotInvalidations;
        if (identityArraySet.isNotEmpty()) {
            List list = this.knownCompositions;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((ControlledComposition) list.get(i)).recordModificationsOf(identityArraySet);
            }
            this.snapshotInvalidations = new IdentityArraySet();
        }
        List list2 = this.compositionInvalidations;
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            interfaceC3750qp.invoke(list2.get(i2));
        }
        this.compositionInvalidations.clear();
        if (deriveStateLocked() != null) {
            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
        }
    }
}
