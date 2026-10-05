package defpackage;

import androidx.core.location.LocationRequestCompat;
import com.itextpdf.text.Meta;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: jn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3176jn extends G implements PS {
    public static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(C3176jn.class, "requested");
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(C3176jn.class, Object.class, Meta.PRODUCER);
    public final InterfaceC0939Tm c;
    private volatile boolean cancellationRequested;
    public final NS d;
    volatile /* synthetic */ Object producer;
    volatile /* synthetic */ long requested;

    /* JADX INFO: renamed from: jn$a */
    public static final class a implements InterfaceC0995Vm {
        public a() {
        }

        @Override // defpackage.InterfaceC0995Vm
        public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C3176jn.this.d.b(obj);
            if (C3176jn.e.decrementAndGet(C3176jn.this) > 0) {
                AbstractC3347lu.j(C3176jn.this.getCoroutineContext());
                return FW.a;
            }
            C3176jn c3176jn = C3176jn.this;
            C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
            c4374ya.A();
            c3176jn.producer = c4374ya;
            Object objX = c4374ya.x();
            if (objX == AbstractC0378Bt.d()) {
                AbstractC3416mi.c(interfaceC0793Of);
            }
            return objX == AbstractC0378Bt.d() ? objX : FW.a;
        }
    }

    /* JADX INFO: renamed from: jn$b */
    public static final class b implements InterfaceC0793Of {
        public final /* synthetic */ InterfaceC0988Vf a;
        public final /* synthetic */ C3176jn b;

        public b(InterfaceC0988Vf interfaceC0988Vf, C3176jn c3176jn) {
            this.a = interfaceC0988Vf;
            this.b = c3176jn;
        }

        @Override // defpackage.InterfaceC0793Of
        public InterfaceC0988Vf getContext() {
            return this.a;
        }

        @Override // defpackage.InterfaceC0793Of
        public void resumeWith(Object obj) throws Throwable {
            AbstractC0385Ca.c(new c(this.b), this.b);
        }
    }

    /* JADX INFO: renamed from: jn$c */
    public /* synthetic */ class c extends C0916Sp implements InterfaceC3750qp {
        public c(Object obj) {
            super(1, obj, C3176jn.class, "flowProcessing", "flowProcessing(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
            return ((C3176jn) this.receiver).K0(interfaceC0793Of);
        }
    }

    /* JADX INFO: renamed from: jn$d */
    public static final class d extends AbstractC0819Pf {
        public Object a;
        public /* synthetic */ Object b;
        public int d;

        public d(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return C3176jn.this.K0(this);
        }
    }

    public C3176jn(InterfaceC0939Tm interfaceC0939Tm, NS ns, InterfaceC0988Vf interfaceC0988Vf) {
        super(interfaceC0988Vf, false, true);
        this.c = interfaceC0939Tm;
        this.d = ns;
        this.requested = 0L;
        this.producer = J0();
    }

    public final Object I0(InterfaceC0793Of interfaceC0793Of) {
        Object objCollect = this.c.collect(new a(), interfaceC0793Of);
        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
    }

    public final InterfaceC0793Of J0() {
        return new b(getCoroutineContext(), this);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object K0(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        d dVar;
        C3176jn c3176jn;
        if (interfaceC0793Of instanceof d) {
            dVar = (d) interfaceC0793Of;
            int i = dVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.d = i - Integer.MIN_VALUE;
            } else {
                dVar = new d(interfaceC0793Of);
            }
        } else {
            dVar = new d(interfaceC0793Of);
        }
        Object obj = dVar.b;
        Object objD = AbstractC0378Bt.d();
        int i2 = dVar.d;
        if (i2 == 0) {
            LL.b(obj);
            try {
                dVar.a = this;
                dVar.d = 1;
                if (I0(dVar) == objD) {
                    return objD;
                }
                c3176jn = this;
                c3176jn.d.onComplete();
                return FW.a;
            } catch (Throwable th) {
                th = th;
                c3176jn = this;
                if (c3176jn.cancellationRequested || c3176jn.isActive() || th != c3176jn.i()) {
                    c3176jn.d.onError(th);
                }
                return FW.a;
            }
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c3176jn = (C3176jn) dVar.a;
        try {
            LL.b(obj);
            try {
                c3176jn.d.onComplete();
            } catch (Throwable th2) {
                AbstractC1247ag.a(c3176jn.getCoroutineContext(), th2);
            }
            return FW.a;
        } catch (Throwable th3) {
            th = th3;
            if (c3176jn.cancellationRequested) {
                try {
                    c3176jn.d.onError(th);
                } catch (Throwable th4) {
                    AbstractC0773Nl.a(th, th4);
                    AbstractC1247ag.a(c3176jn.getCoroutineContext(), th);
                }
            } else {
                c3176jn.d.onError(th);
            }
            return FW.a;
        }
    }

    @Override // defpackage.PS
    public void cancel() throws Throwable {
        this.cancellationRequested = true;
        cancel(null);
    }

    @Override // defpackage.PS
    public void l(long j) {
        long j2;
        long j3;
        InterfaceC0793Of interfaceC0793Of;
        if (j <= 0) {
            return;
        }
        do {
            j2 = this.requested;
            j3 = j2 + j;
            if (j3 <= 0) {
                j3 = LocationRequestCompat.PASSIVE_INTERVAL;
            }
        } while (!e.compareAndSet(this, j2, j3));
        if (j2 <= 0) {
            do {
                interfaceC0793Of = (InterfaceC0793Of) f.getAndSet(this, null);
            } while (interfaceC0793Of == null);
            KL.a aVar = KL.a;
            interfaceC0793Of.resumeWith(KL.a(FW.a));
        }
    }
}
