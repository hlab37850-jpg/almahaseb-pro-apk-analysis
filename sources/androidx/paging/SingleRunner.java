package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC4492zt;
import defpackage.E8;
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

/* JADX INFO: loaded from: classes2.dex */
public final class SingleRunner {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_PRIORITY = 0;
    private final Holder holder;

    public static final class CancelIsolatedRunnerException extends CancellationException {
        private final SingleRunner runner;

        public CancelIsolatedRunnerException(SingleRunner singleRunner) {
            AbstractC4492zt.h(singleRunner, "runner");
            this.runner = singleRunner;
        }

        public final SingleRunner getRunner() {
            return this.runner;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

    public static final class Holder {
        private final boolean cancelPreviousInEqualPriority;
        private final GC mutex;
        private InterfaceC1830bu previous;
        private int previousPriority;
        private final SingleRunner singleRunner;

        public Holder(SingleRunner singleRunner, boolean z) {
            AbstractC4492zt.h(singleRunner, "singleRunner");
            this.singleRunner = singleRunner;
            this.cancelPreviousInEqualPriority = z;
            this.mutex = IC.b(false, 1, null);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object onFinish(InterfaceC1830bu interfaceC1830bu, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            SingleRunner$Holder$onFinish$1 singleRunner$Holder$onFinish$1;
            GC gc;
            Holder holder;
            if (interfaceC0793Of instanceof SingleRunner$Holder$onFinish$1) {
                singleRunner$Holder$onFinish$1 = (SingleRunner$Holder$onFinish$1) interfaceC0793Of;
                int i = singleRunner$Holder$onFinish$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    singleRunner$Holder$onFinish$1.label = i - Integer.MIN_VALUE;
                } else {
                    singleRunner$Holder$onFinish$1 = new SingleRunner$Holder$onFinish$1(this, interfaceC0793Of);
                }
            } else {
                singleRunner$Holder$onFinish$1 = new SingleRunner$Holder$onFinish$1(this, interfaceC0793Of);
            }
            Object obj = singleRunner$Holder$onFinish$1.result;
            Object objD = AbstractC0378Bt.d();
            int i2 = singleRunner$Holder$onFinish$1.label;
            if (i2 == 0) {
                LL.b(obj);
                gc = this.mutex;
                singleRunner$Holder$onFinish$1.L$0 = this;
                singleRunner$Holder$onFinish$1.L$1 = interfaceC1830bu;
                singleRunner$Holder$onFinish$1.L$2 = gc;
                singleRunner$Holder$onFinish$1.label = 1;
                if (gc.c(null, singleRunner$Holder$onFinish$1) == objD) {
                    return objD;
                }
                holder = this;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                GC gc2 = (GC) singleRunner$Holder$onFinish$1.L$2;
                InterfaceC1830bu interfaceC1830bu2 = (InterfaceC1830bu) singleRunner$Holder$onFinish$1.L$1;
                holder = (Holder) singleRunner$Holder$onFinish$1.L$0;
                LL.b(obj);
                gc = gc2;
                interfaceC1830bu = interfaceC1830bu2;
            }
            try {
                if (interfaceC1830bu == holder.previous) {
                    holder.previous = null;
                }
                FW fw = FW.a;
                return FW.a;
            } finally {
                gc.b(null);
            }
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [bu, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v1, types: [GC] */
        /* JADX WARN: Type inference failed for: r11v14 */
        /* JADX WARN: Type inference failed for: r11v15 */
        /* JADX WARN: Type inference failed for: r11v4, types: [GC] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v4, types: [bu] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public final Object tryEnqueue(int i, InterfaceC1830bu interfaceC1830bu, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            SingleRunner$Holder$tryEnqueue$1 singleRunner$Holder$tryEnqueue$1;
            Holder holder;
            ?? r2;
            GC gc;
            ?? r1;
            Holder holder2;
            int i2;
            if (interfaceC0793Of instanceof SingleRunner$Holder$tryEnqueue$1) {
                singleRunner$Holder$tryEnqueue$1 = (SingleRunner$Holder$tryEnqueue$1) interfaceC0793Of;
                int i3 = singleRunner$Holder$tryEnqueue$1.label;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    singleRunner$Holder$tryEnqueue$1.label = i3 - Integer.MIN_VALUE;
                } else {
                    singleRunner$Holder$tryEnqueue$1 = new SingleRunner$Holder$tryEnqueue$1(this, interfaceC0793Of);
                }
            } else {
                singleRunner$Holder$tryEnqueue$1 = new SingleRunner$Holder$tryEnqueue$1(this, interfaceC0793Of);
            }
            Object obj = singleRunner$Holder$tryEnqueue$1.result;
            Object objD = AbstractC0378Bt.d();
            int i4 = singleRunner$Holder$tryEnqueue$1.label;
            boolean z = true;
            try {
                if (i4 != 0) {
                    if (i4 == 1) {
                        i = singleRunner$Holder$tryEnqueue$1.I$0;
                        GC gc2 = (GC) singleRunner$Holder$tryEnqueue$1.L$2;
                        InterfaceC1830bu interfaceC1830bu2 = (InterfaceC1830bu) singleRunner$Holder$tryEnqueue$1.L$1;
                        holder = (Holder) singleRunner$Holder$tryEnqueue$1.L$0;
                        LL.b(obj);
                        r2 = interfaceC1830bu2;
                        gc = gc2;
                    } else {
                        if (i4 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i = singleRunner$Holder$tryEnqueue$1.I$0;
                        GC gc3 = (GC) singleRunner$Holder$tryEnqueue$1.L$2;
                        InterfaceC1830bu interfaceC1830bu3 = (InterfaceC1830bu) singleRunner$Holder$tryEnqueue$1.L$1;
                        holder2 = (Holder) singleRunner$Holder$tryEnqueue$1.L$0;
                        LL.b(obj);
                        r1 = interfaceC1830bu3;
                        gc = gc3;
                    }
                    holder = holder2;
                    r2 = r1;
                    holder.previous = r2;
                    holder.previousPriority = i;
                    interfaceC1830bu = gc;
                    Boolean boolA = E8.a(z);
                    interfaceC1830bu.b(null);
                    return boolA;
                }
                LL.b(obj);
                GC gc4 = this.mutex;
                singleRunner$Holder$tryEnqueue$1.L$0 = this;
                singleRunner$Holder$tryEnqueue$1.L$1 = interfaceC1830bu;
                singleRunner$Holder$tryEnqueue$1.L$2 = gc4;
                singleRunner$Holder$tryEnqueue$1.I$0 = i;
                singleRunner$Holder$tryEnqueue$1.label = 1;
                if (gc4.c(null, singleRunner$Holder$tryEnqueue$1) == objD) {
                    return objD;
                }
                holder = this;
                r2 = interfaceC1830bu;
                gc = gc4;
                InterfaceC1830bu interfaceC1830bu4 = holder.previous;
                if (interfaceC1830bu4 == null || !interfaceC1830bu4.isActive() || (i2 = holder.previousPriority) < i || (i2 == i && holder.cancelPreviousInEqualPriority)) {
                    if (interfaceC1830bu4 != null) {
                        interfaceC1830bu4.cancel(new CancelIsolatedRunnerException(holder.singleRunner));
                    }
                    if (interfaceC1830bu4 != null) {
                        singleRunner$Holder$tryEnqueue$1.L$0 = holder;
                        singleRunner$Holder$tryEnqueue$1.L$1 = r2;
                        singleRunner$Holder$tryEnqueue$1.L$2 = gc;
                        singleRunner$Holder$tryEnqueue$1.I$0 = i;
                        singleRunner$Holder$tryEnqueue$1.label = 2;
                        if (interfaceC1830bu4.F(singleRunner$Holder$tryEnqueue$1) == objD) {
                            return objD;
                        }
                        r1 = r2;
                        holder2 = holder;
                        gc = gc;
                        holder = holder2;
                        r2 = r1;
                    }
                    holder.previous = r2;
                    holder.previousPriority = i;
                    interfaceC1830bu = gc;
                } else {
                    z = false;
                    interfaceC1830bu = gc;
                }
                Boolean boolA2 = E8.a(z);
                interfaceC1830bu.b(null);
                return boolA2;
            } catch (Throwable th) {
                interfaceC1830bu.b(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SingleRunner$runInIsolation$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.SingleRunner", f = "SingleRunner.kt", l = {49}, m = "runInIsolation")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SingleRunner.this.runInIsolation(0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SingleRunner$runInIsolation$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.SingleRunner$runInIsolation$2", f = "SingleRunner.kt", l = {53, 59, 61, 61}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC3750qp $block;
        final /* synthetic */ int $priority;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$priority = i;
            this.$block = interfaceC3750qp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = SingleRunner.this.new AnonymousClass2(this.$priority, this.$block, interfaceC0793Of);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x008d A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [bu] */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v9, types: [bu] */
        /* JADX WARN: Type inference failed for: r3v2, types: [androidx.paging.SingleRunner$Holder] */
        /* JADX WARN: Type inference failed for: r9v15, types: [androidx.paging.SingleRunner$Holder] */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC1830bu interfaceC1830bu;
            ?? r9;
            Object objD = AbstractC0378Bt.d();
            ?? r1 = this.label;
            int i = 4;
            try {
                if (r1 != 0) {
                    if (r1 == 1) {
                        InterfaceC1830bu interfaceC1830bu2 = (InterfaceC1830bu) this.L$0;
                        LL.b(obj);
                        interfaceC1830bu = interfaceC1830bu2;
                    } else if (r1 == 2) {
                        InterfaceC1830bu interfaceC1830bu3 = (InterfaceC1830bu) this.L$0;
                        LL.b(obj);
                        r1 = interfaceC1830bu3;
                        r1 = interfaceC1830bu;
                        r9 = SingleRunner.this.holder;
                        i = 0;
                        this.L$0 = null;
                        this.label = 3;
                        if (r9.onFinish(r1, this) == objD) {
                            return objD;
                        }
                    } else {
                        if (r1 != 3) {
                            if (r1 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Throwable th = (Throwable) this.L$0;
                            LL.b(obj);
                            throw th;
                        }
                        LL.b(obj);
                    }
                    return FW.a;
                }
                LL.b(obj);
                InterfaceC0988Vf.b bVar = ((InterfaceC2052dg) this.L$0).getCoroutineContext().get(InterfaceC1830bu.s);
                if (bVar == null) {
                    throw new IllegalStateException("Internal error. coroutineScope should've created a job.");
                }
                InterfaceC1830bu interfaceC1830bu4 = (InterfaceC1830bu) bVar;
                Holder holder = SingleRunner.this.holder;
                int i2 = this.$priority;
                this.L$0 = interfaceC1830bu4;
                this.label = 1;
                Object objTryEnqueue = holder.tryEnqueue(i2, interfaceC1830bu4, this);
                if (objTryEnqueue == objD) {
                    return objD;
                }
                interfaceC1830bu = interfaceC1830bu4;
                obj = objTryEnqueue;
                if (((Boolean) obj).booleanValue()) {
                    InterfaceC3750qp interfaceC3750qp = this.$block;
                    this.L$0 = interfaceC1830bu;
                    this.label = 2;
                    if (interfaceC3750qp.invoke(this) == objD) {
                        r1 = interfaceC1830bu;
                        return objD;
                    }
                    r1 = interfaceC1830bu;
                    r9 = SingleRunner.this.holder;
                    i = 0;
                    this.L$0 = null;
                    this.label = 3;
                    if (r9.onFinish(r1, this) == objD) {
                        return objD;
                    }
                }
                return FW.a;
            } catch (Throwable th2) {
                ?? r3 = SingleRunner.this.holder;
                this.L$0 = th2;
                this.label = i;
                if (r3.onFinish(r1, this) == objD) {
                    return objD;
                }
                throw th2;
            }
        }
    }

    public SingleRunner() {
        this(false, 1, null);
    }

    public static /* synthetic */ Object runInIsolation$default(SingleRunner singleRunner, int i, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return singleRunner.runInIsolation(i, interfaceC3750qp, interfaceC0793Of);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object runInIsolation(int i, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        SingleRunner singleRunner;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
        }
        Object obj = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            LL.b(obj);
            try {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(i, interfaceC3750qp, null);
                anonymousClass1.L$0 = this;
                anonymousClass1.label = 1;
                if (AbstractC2133eg.d(anonymousClass2, anonymousClass1) == objD) {
                    return objD;
                }
            } catch (CancelIsolatedRunnerException e) {
                e = e;
                singleRunner = this;
                if (e.getRunner() != singleRunner) {
                    throw e;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            singleRunner = (SingleRunner) anonymousClass1.L$0;
            try {
                LL.b(obj);
            } catch (CancelIsolatedRunnerException e2) {
                e = e2;
                if (e.getRunner() != singleRunner) {
                    throw e;
                }
            }
        }
        return FW.a;
    }

    public SingleRunner(boolean z) {
        this.holder = new Holder(this, z);
    }

    public /* synthetic */ SingleRunner(boolean z, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? true : z);
    }
}
