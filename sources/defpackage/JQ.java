package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class JQ extends BQ {
    public final IQ a;
    public final AN b;

    public static final class a extends AtomicReference implements FQ, InterfaceC0624Jj, Runnable {
        public final FQ a;
        public final GO b = new GO();
        public final IQ c;

        public a(FQ fq, IQ iq) {
            this.a = fq;
            this.c = iq;
        }

        @Override // defpackage.FQ
        public void a(InterfaceC0624Jj interfaceC0624Jj) {
            EnumC0771Nj.h(this, interfaceC0624Jj);
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            EnumC0771Nj.a(this);
            this.b.dispose();
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return EnumC0771Nj.b((InterfaceC0624Jj) get());
        }

        @Override // defpackage.FQ
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // defpackage.FQ
        public void onSuccess(Object obj) {
            this.a.onSuccess(obj);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.a(this);
        }
    }

    public JQ(IQ iq, AN an) {
        this.a = iq;
        this.b = an;
    }

    @Override // defpackage.BQ
    public void f(FQ fq) {
        a aVar = new a(fq, this.a);
        fq.a(aVar);
        aVar.b.a(this.b.scheduleDirect(aVar));
    }
}
