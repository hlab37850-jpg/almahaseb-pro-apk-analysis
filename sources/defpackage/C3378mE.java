package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: mE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3378mE extends AbstractC3132jE implements US {
    public final Callable a;

    public C3378mE(Callable callable) {
        this.a = callable;
    }

    @Override // defpackage.US
    public Object get() {
        return AbstractC0696Kl.c(this.a.call(), "The Callable returned a null value.");
    }

    @Override // defpackage.AbstractC3132jE
    public void l(InterfaceC3866sE interfaceC3866sE) {
        C0935Ti c0935Ti = new C0935Ti(interfaceC3866sE);
        interfaceC3866sE.a(c0935Ti);
        if (c0935Ti.isDisposed()) {
            return;
        }
        try {
            c0935Ti.e(AbstractC0696Kl.c(this.a.call(), "Callable returned a null value."));
        } catch (Throwable th) {
            AbstractC0722Ll.b(th);
            if (c0935Ti.isDisposed()) {
                FM.m(th);
            } else {
                interfaceC3866sE.onError(th);
            }
        }
    }
}
