package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: Ke, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0689Ke extends AN {
    public static final b c;
    public static final IM d;
    public static final int e = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx3.computation-threads", 0).intValue());
    public static final c f;
    public final ThreadFactory a;
    public final AtomicReference b;

    /* JADX INFO: renamed from: Ke$a */
    public static final class a extends AN.c {
        public final C0706Kv a;
        public final C0415De b;
        public final C0706Kv c;
        public final c d;
        public volatile boolean e;

        public a(c cVar) {
            this.d = cVar;
            C0706Kv c0706Kv = new C0706Kv();
            this.a = c0706Kv;
            C0415De c0415De = new C0415De();
            this.b = c0415De;
            C0706Kv c0706Kv2 = new C0706Kv();
            this.c = c0706Kv2;
            c0706Kv2.a(c0706Kv);
            c0706Kv2.a(c0415De);
        }

        @Override // AN.c
        public InterfaceC0624Jj b(Runnable runnable) {
            return this.e ? EnumC1255al.INSTANCE : this.d.e(runnable, 0L, TimeUnit.MILLISECONDS, this.a);
        }

        @Override // AN.c
        public InterfaceC0624Jj c(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.e ? EnumC1255al.INSTANCE : this.d.e(runnable, j, timeUnit, this.b);
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            if (this.e) {
                return;
            }
            this.e = true;
            this.c.dispose();
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return this.e;
        }
    }

    /* JADX INFO: renamed from: Ke$b */
    public static final class b {
        public final int a;
        public final c[] b;
        public long c;

        public b(int i, ThreadFactory threadFactory) {
            this.a = i;
            this.b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.a;
            if (i == 0) {
                return C0689Ke.f;
            }
            c[] cVarArr = this.b;
            long j = this.c;
            this.c = 1 + j;
            return cVarArr[(int) (j % ((long) i))];
        }

        public void b() {
            for (c cVar : this.b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: renamed from: Ke$c */
    public static final class c extends C4108vD {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new IM("RxComputationShutdown"));
        f = cVar;
        cVar.dispose();
        IM im = new IM("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx3.computation-priority", 5).intValue())), true);
        d = im;
        b bVar = new b(0, im);
        c = bVar;
        bVar.b();
    }

    public C0689Ke() {
        this(d);
    }

    public static int a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    @Override // defpackage.AN
    public AN.c createWorker() {
        return new a(((b) this.b.get()).a());
    }

    @Override // defpackage.AN
    public InterfaceC0624Jj scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        return ((b) this.b.get()).a().f(runnable, j, timeUnit);
    }

    @Override // defpackage.AN
    public InterfaceC0624Jj schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return ((b) this.b.get()).a().g(runnable, j, j2, timeUnit);
    }

    @Override // defpackage.AN
    public void shutdown() {
        AtomicReference atomicReference = this.b;
        b bVar = c;
        b bVar2 = (b) atomicReference.getAndSet(bVar);
        if (bVar2 != bVar) {
            bVar2.b();
        }
    }

    @Override // defpackage.AN
    public void start() {
        b bVar = new b(e, this.a);
        if (FC.a(this.b, c, bVar)) {
            return;
        }
        bVar.b();
    }

    public C0689Ke(ThreadFactory threadFactory) {
        this.a = threadFactory;
        this.b = new AtomicReference(c);
        start();
    }
}
