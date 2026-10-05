package androidx.compose.animation.core;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC4492zt;
import defpackage.FC;
import defpackage.FW;
import defpackage.GC;
import defpackage.IC;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
@Stable
public final class MutatorMutex {
    private final AtomicReference<Mutator> currentMutator = new AtomicReference<>(null);
    private final GC mutex = IC.b(false, 1, null);

    public static final class Mutator {
        private final InterfaceC1830bu job;
        private final MutatePriority priority;

        public Mutator(MutatePriority mutatePriority, InterfaceC1830bu interfaceC1830bu) {
            AbstractC4492zt.h(mutatePriority, "priority");
            AbstractC4492zt.h(interfaceC1830bu, "job");
            this.priority = mutatePriority;
            this.job = interfaceC1830bu;
        }

        public final boolean canInterrupt(Mutator mutator) {
            AbstractC4492zt.h(mutator, "other");
            return this.priority.compareTo(mutator.priority) >= 0;
        }

        public final void cancel() {
            this.job.cancel(new MutationInterruptedException());
        }

        public final InterfaceC1830bu getJob() {
            return this.job;
        }

        public final MutatePriority getPriority() {
            return this.priority;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.MutatorMutex$mutate$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.animation.core.MutatorMutex$mutate$2", f = "InternalMutatorMutex.kt", l = {ShapeTypes.PLAQUE_TABS, ShapeTypes.FLOW_CHART_PROCESS}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC3750qp $block;
        final /* synthetic */ MutatePriority $priority;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MutatorMutex this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$priority = mutatePriority;
            this.this$0 = mutatorMutex;
            this.$block = interfaceC3750qp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$priority, this.this$0, this.$block, interfaceC0793Of);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [GC, int] */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            GC gc;
            InterfaceC3750qp interfaceC3750qp;
            Mutator mutator;
            MutatorMutex mutatorMutex;
            Mutator mutator2;
            Throwable th;
            MutatorMutex mutatorMutex2;
            GC gc2;
            Object objD = AbstractC0378Bt.d();
            ?? r1 = this.label;
            try {
                try {
                    if (r1 == 0) {
                        LL.b(obj);
                        InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                        MutatePriority mutatePriority = this.$priority;
                        InterfaceC0988Vf.b bVar = interfaceC2052dg.getCoroutineContext().get(InterfaceC1830bu.s);
                        AbstractC4492zt.e(bVar);
                        Mutator mutator3 = new Mutator(mutatePriority, (InterfaceC1830bu) bVar);
                        this.this$0.tryMutateOrCancel(mutator3);
                        gc = this.this$0.mutex;
                        InterfaceC3750qp interfaceC3750qp2 = this.$block;
                        MutatorMutex mutatorMutex3 = this.this$0;
                        this.L$0 = mutator3;
                        this.L$1 = gc;
                        this.L$2 = interfaceC3750qp2;
                        this.L$3 = mutatorMutex3;
                        this.label = 1;
                        if (gc.c(null, this) == objD) {
                            return objD;
                        }
                        interfaceC3750qp = interfaceC3750qp2;
                        mutator = mutator3;
                        mutatorMutex = mutatorMutex3;
                    } else {
                        if (r1 != 1) {
                            if (r1 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutatorMutex2 = (MutatorMutex) this.L$2;
                            gc2 = (GC) this.L$1;
                            mutator2 = (Mutator) this.L$0;
                            try {
                                LL.b(obj);
                                FC.a(mutatorMutex2.currentMutator, mutator2, null);
                                gc2.b(null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                FC.a(mutatorMutex2.currentMutator, mutator2, null);
                                throw th;
                            }
                        }
                        mutatorMutex = (MutatorMutex) this.L$3;
                        interfaceC3750qp = (InterfaceC3750qp) this.L$2;
                        GC gc3 = (GC) this.L$1;
                        mutator = (Mutator) this.L$0;
                        LL.b(obj);
                        gc = gc3;
                    }
                    this.L$0 = mutator;
                    this.L$1 = gc;
                    this.L$2 = mutatorMutex;
                    this.L$3 = null;
                    this.label = 2;
                    Object objInvoke = interfaceC3750qp.invoke(this);
                    if (objInvoke == objD) {
                        return objD;
                    }
                    mutatorMutex2 = mutatorMutex;
                    gc2 = gc;
                    obj = objInvoke;
                    mutator2 = mutator;
                    FC.a(mutatorMutex2.currentMutator, mutator2, null);
                    gc2.b(null);
                    return obj;
                } catch (Throwable th3) {
                    mutator2 = mutator;
                    th = th3;
                    mutatorMutex2 = mutatorMutex;
                    FC.a(mutatorMutex2.currentMutator, mutator2, null);
                    throw th;
                }
            } catch (Throwable th4) {
                r1.b(null);
                throw th4;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.MutatorMutex$mutateWith$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.animation.core.MutatorMutex$mutateWith$2", f = "InternalMutatorMutex.kt", l = {ShapeTypes.PLAQUE_TABS, ShapeTypes.ACTION_BUTTON_SOUND}, m = "invokeSuspend")
    public static final class C12922 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0526Fp $block;
        final /* synthetic */ MutatePriority $priority;
        final /* synthetic */ T $receiver;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ MutatorMutex this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12922(MutatePriority mutatePriority, MutatorMutex mutatorMutex, InterfaceC0526Fp interfaceC0526Fp, T t, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$priority = mutatePriority;
            this.this$0 = mutatorMutex;
            this.$block = interfaceC0526Fp;
            this.$receiver = t;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C12922 c12922 = new C12922(this.$priority, this.this$0, this.$block, this.$receiver, interfaceC0793Of);
            c12922.L$0 = obj;
            return c12922;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((C12922) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [GC, int] */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            GC gc;
            InterfaceC0526Fp interfaceC0526Fp;
            Object obj2;
            Mutator mutator;
            MutatorMutex mutatorMutex;
            Mutator mutator2;
            Throwable th;
            MutatorMutex mutatorMutex2;
            GC gc2;
            Object objD = AbstractC0378Bt.d();
            ?? r1 = this.label;
            try {
                try {
                    if (r1 == 0) {
                        LL.b(obj);
                        InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                        MutatePriority mutatePriority = this.$priority;
                        InterfaceC0988Vf.b bVar = interfaceC2052dg.getCoroutineContext().get(InterfaceC1830bu.s);
                        AbstractC4492zt.e(bVar);
                        Mutator mutator3 = new Mutator(mutatePriority, (InterfaceC1830bu) bVar);
                        this.this$0.tryMutateOrCancel(mutator3);
                        gc = this.this$0.mutex;
                        interfaceC0526Fp = this.$block;
                        Object obj3 = this.$receiver;
                        MutatorMutex mutatorMutex3 = this.this$0;
                        this.L$0 = mutator3;
                        this.L$1 = gc;
                        this.L$2 = interfaceC0526Fp;
                        this.L$3 = obj3;
                        this.L$4 = mutatorMutex3;
                        this.label = 1;
                        if (gc.c(null, this) == objD) {
                            return objD;
                        }
                        obj2 = obj3;
                        mutator = mutator3;
                        mutatorMutex = mutatorMutex3;
                    } else {
                        if (r1 != 1) {
                            if (r1 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutatorMutex2 = (MutatorMutex) this.L$2;
                            gc2 = (GC) this.L$1;
                            mutator2 = (Mutator) this.L$0;
                            try {
                                LL.b(obj);
                                FC.a(mutatorMutex2.currentMutator, mutator2, null);
                                gc2.b(null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                FC.a(mutatorMutex2.currentMutator, mutator2, null);
                                throw th;
                            }
                        }
                        mutatorMutex = (MutatorMutex) this.L$4;
                        obj2 = this.L$3;
                        interfaceC0526Fp = (InterfaceC0526Fp) this.L$2;
                        GC gc3 = (GC) this.L$1;
                        mutator = (Mutator) this.L$0;
                        LL.b(obj);
                        gc = gc3;
                    }
                    this.L$0 = mutator;
                    this.L$1 = gc;
                    this.L$2 = mutatorMutex;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 2;
                    Object objMo13invoke = interfaceC0526Fp.mo13invoke(obj2, this);
                    if (objMo13invoke == objD) {
                        return objD;
                    }
                    mutatorMutex2 = mutatorMutex;
                    gc2 = gc;
                    obj = objMo13invoke;
                    mutator2 = mutator;
                    FC.a(mutatorMutex2.currentMutator, mutator2, null);
                    gc2.b(null);
                    return obj;
                } catch (Throwable th3) {
                    mutator2 = mutator;
                    th = th3;
                    mutatorMutex2 = mutatorMutex;
                    FC.a(mutatorMutex2.currentMutator, mutator2, null);
                    throw th;
                }
            } catch (Throwable th4) {
                r1.b(null);
                throw th4;
            }
        }
    }

    public static /* synthetic */ Object mutate$default(MutatorMutex mutatorMutex, MutatePriority mutatePriority, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.mutate(mutatePriority, interfaceC3750qp, interfaceC0793Of);
    }

    public static /* synthetic */ Object mutateWith$default(MutatorMutex mutatorMutex, Object obj, MutatePriority mutatePriority, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.mutateWith(obj, mutatePriority, interfaceC0526Fp, interfaceC0793Of);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryMutateOrCancel(Mutator mutator) {
        Mutator mutator2;
        do {
            mutator2 = this.currentMutator.get();
            if (mutator2 != null && !mutator.canInterrupt(mutator2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!FC.a(this.currentMutator, mutator2, mutator));
        if (mutator2 != null) {
            mutator2.cancel();
        }
    }

    public final <R> Object mutate(MutatePriority mutatePriority, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        return AbstractC2133eg.d(new AnonymousClass2(mutatePriority, this, interfaceC3750qp, null), interfaceC0793Of);
    }

    public final <T, R> Object mutateWith(T t, MutatePriority mutatePriority, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        return AbstractC2133eg.d(new C12922(mutatePriority, this, interfaceC0526Fp, t, null), interfaceC0793Of);
    }
}
