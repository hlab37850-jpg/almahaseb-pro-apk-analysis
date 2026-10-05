package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: rE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3785rE extends AbstractC2157f0 {
    public final AN b;

    /* JADX INFO: renamed from: rE$a */
    public static final class a extends AtomicReference implements InterfaceC3866sE, InterfaceC0624Jj {
        public final InterfaceC3866sE a;
        public final AtomicReference b = new AtomicReference();

        public a(InterfaceC3866sE interfaceC3866sE) {
            this.a = interfaceC3866sE;
        }

        @Override // defpackage.InterfaceC3866sE
        public void a(InterfaceC0624Jj interfaceC0624Jj) {
            EnumC0771Nj.h(this.b, interfaceC0624Jj);
        }

        @Override // defpackage.InterfaceC3866sE
        public void b(Object obj) {
            this.a.b(obj);
        }

        public void c(InterfaceC0624Jj interfaceC0624Jj) {
            EnumC0771Nj.h(this, interfaceC0624Jj);
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            EnumC0771Nj.a(this.b);
            EnumC0771Nj.a(this);
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return EnumC0771Nj.b((InterfaceC0624Jj) get());
        }

        @Override // defpackage.InterfaceC3866sE
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // defpackage.InterfaceC3866sE
        public void onError(Throwable th) {
            this.a.onError(th);
        }
    }

    /* JADX INFO: renamed from: rE$b */
    public final class b implements Runnable {
        public final a a;

        public b(a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3785rE.this.a.a(this.a);
        }
    }

    public C3785rE(InterfaceC3705qE interfaceC3705qE, AN an) {
        super(interfaceC3705qE);
        this.b = an;
    }

    @Override // defpackage.AbstractC3132jE
    public void l(InterfaceC3866sE interfaceC3866sE) {
        a aVar = new a(interfaceC3866sE);
        interfaceC3866sE.a(aVar);
        aVar.c(this.b.scheduleDirect(new b(aVar)));
    }
}
