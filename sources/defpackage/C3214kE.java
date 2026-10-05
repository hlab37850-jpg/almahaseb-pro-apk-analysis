package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: kE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3214kE extends AbstractC3132jE {
    public final InterfaceC3624pE a;

    /* JADX INFO: renamed from: kE$a */
    public static final class a extends AtomicReference implements InterfaceC3296lE, InterfaceC0624Jj {
        public final InterfaceC3866sE a;

        public a(InterfaceC3866sE interfaceC3866sE) {
            this.a = interfaceC3866sE;
        }

        @Override // defpackage.InterfaceC3296lE
        public boolean a(Throwable th) {
            if (th == null) {
                th = AbstractC0696Kl.b("onError called with a null Throwable.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.a.onError(th);
                return true;
            } finally {
                dispose();
            }
        }

        @Override // defpackage.InterfaceC0993Vk
        public void b(Object obj) {
            if (obj == null) {
                e(AbstractC0696Kl.b("onNext called with a null value."));
            } else {
                if (isDisposed()) {
                    return;
                }
                this.a.b(obj);
            }
        }

        @Override // defpackage.InterfaceC3296lE
        public void c(InterfaceC4212wa interfaceC4212wa) {
            f(new C0359Ba(interfaceC4212wa));
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            EnumC0771Nj.a(this);
        }

        public void e(Throwable th) {
            if (a(th)) {
                return;
            }
            FM.m(th);
        }

        public void f(InterfaceC0624Jj interfaceC0624Jj) {
            EnumC0771Nj.f(this, interfaceC0624Jj);
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return EnumC0771Nj.b((InterfaceC0624Jj) get());
        }

        @Override // defpackage.InterfaceC0993Vk
        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            try {
                this.a.onComplete();
            } finally {
                dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }
    }

    public C3214kE(InterfaceC3624pE interfaceC3624pE) {
        this.a = interfaceC3624pE;
    }

    @Override // defpackage.AbstractC3132jE
    public void l(InterfaceC3866sE interfaceC3866sE) {
        a aVar = new a(interfaceC3866sE);
        interfaceC3866sE.a(aVar);
        try {
            this.a.subscribe(aVar);
        } catch (Throwable th) {
            AbstractC0722Ll.b(th);
            aVar.e(th);
        }
    }
}
