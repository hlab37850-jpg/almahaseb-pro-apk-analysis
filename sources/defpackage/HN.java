package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class HN extends AN implements InterfaceC0624Jj {
    public static final InterfaceC0624Jj d = new g();
    public static final InterfaceC0624Jj e = AbstractC0598Ij.a();
    public final AN a;
    public final AbstractC3990tn b;
    public InterfaceC0624Jj c;

    public static final class a implements InterfaceC0777Np {
        public final AN.c a;

        /* JADX INFO: renamed from: HN$a$a, reason: collision with other inner class name */
        public final class C0008a extends AbstractC1012Wd {
            public final f a;

            public C0008a(f fVar) {
                this.a = fVar;
            }

            @Override // defpackage.AbstractC1012Wd
            public void c(InterfaceC1809be interfaceC1809be) {
                interfaceC1809be.a(this.a);
                this.a.a(a.this.a, interfaceC1809be);
            }
        }

        public a(AN.c cVar) {
            this.a = cVar;
        }

        @Override // defpackage.InterfaceC0777Np
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC1012Wd apply(f fVar) {
            return new C0008a(fVar);
        }
    }

    public static class b extends f {
        public final Runnable a;
        public final long b;
        public final TimeUnit c;

        public b(Runnable runnable, long j, TimeUnit timeUnit) {
            this.a = runnable;
            this.b = j;
            this.c = timeUnit;
        }

        @Override // HN.f
        public InterfaceC0624Jj b(AN.c cVar, InterfaceC1809be interfaceC1809be) {
            return cVar.c(new d(this.a, interfaceC1809be), this.b, this.c);
        }
    }

    public static class c extends f {
        public final Runnable a;

        public c(Runnable runnable) {
            this.a = runnable;
        }

        @Override // HN.f
        public InterfaceC0624Jj b(AN.c cVar, InterfaceC1809be interfaceC1809be) {
            return cVar.b(new d(this.a, interfaceC1809be));
        }
    }

    public static class d implements Runnable {
        public final InterfaceC1809be a;
        public final Runnable b;

        public d(Runnable runnable, InterfaceC1809be interfaceC1809be) {
            this.b = runnable;
            this.a = interfaceC1809be;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } finally {
                this.a.onComplete();
            }
        }
    }

    public static final class e extends AN.c {
        public final AtomicBoolean a = new AtomicBoolean();
        public final AbstractC3990tn b;
        public final AN.c c;

        public e(AbstractC3990tn abstractC3990tn, AN.c cVar) {
            this.b = abstractC3990tn;
            this.c = cVar;
        }

        @Override // AN.c
        public InterfaceC0624Jj b(Runnable runnable) {
            c cVar = new c(runnable);
            this.b.b(cVar);
            return cVar;
        }

        @Override // AN.c
        public InterfaceC0624Jj c(Runnable runnable, long j, TimeUnit timeUnit) {
            b bVar = new b(runnable, j, timeUnit);
            this.b.b(bVar);
            return bVar;
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            if (this.a.compareAndSet(false, true)) {
                this.b.onComplete();
                this.c.dispose();
            }
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return this.a.get();
        }
    }

    public static abstract class f extends AtomicReference implements InterfaceC0624Jj {
        public f() {
            super(HN.d);
        }

        public void a(AN.c cVar, InterfaceC1809be interfaceC1809be) {
            InterfaceC0624Jj interfaceC0624Jj;
            InterfaceC0624Jj interfaceC0624Jj2 = (InterfaceC0624Jj) get();
            if (interfaceC0624Jj2 != HN.e && interfaceC0624Jj2 == (interfaceC0624Jj = HN.d)) {
                InterfaceC0624Jj interfaceC0624JjB = b(cVar, interfaceC1809be);
                if (compareAndSet(interfaceC0624Jj, interfaceC0624JjB)) {
                    return;
                }
                interfaceC0624JjB.dispose();
            }
        }

        public abstract InterfaceC0624Jj b(AN.c cVar, InterfaceC1809be interfaceC1809be);

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            ((InterfaceC0624Jj) getAndSet(HN.e)).dispose();
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return ((InterfaceC0624Jj) get()).isDisposed();
        }
    }

    public HN(InterfaceC0777Np interfaceC0777Np, AN an) {
        this.a = an;
        AbstractC3990tn abstractC3990tnO = CW.q().o();
        this.b = abstractC3990tnO;
        try {
            this.c = ((AbstractC1012Wd) interfaceC0777Np.apply(abstractC3990tnO)).a();
        } catch (Throwable th) {
            throw AbstractC0696Kl.f(th);
        }
    }

    @Override // defpackage.AN
    public AN.c createWorker() {
        AN.c cVarCreateWorker = this.a.createWorker();
        AbstractC3990tn abstractC3990tnO = CW.q().o();
        AbstractC3258kn abstractC3258knF = abstractC3990tnO.f(new a(cVarCreateWorker));
        e eVar = new e(abstractC3990tnO, cVarCreateWorker);
        this.b.b(abstractC3258knF);
        return eVar;
    }

    @Override // defpackage.InterfaceC0624Jj
    public void dispose() {
        this.c.dispose();
    }

    @Override // defpackage.InterfaceC0624Jj
    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public static final class g implements InterfaceC0624Jj {
        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return false;
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
        }
    }
}
