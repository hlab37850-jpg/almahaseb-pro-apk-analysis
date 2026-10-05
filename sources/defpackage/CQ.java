package defpackage;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class CQ extends BQ {
    public final Callable a;

    public CQ(Callable callable) {
        this.a = callable;
    }

    @Override // defpackage.BQ
    public void f(FQ fq) {
        InterfaceC0624Jj interfaceC0624JjB = AbstractC0598Ij.b();
        fq.a(interfaceC0624JjB);
        if (interfaceC0624JjB.isDisposed()) {
            return;
        }
        try {
            Object objCall = this.a.call();
            Objects.requireNonNull(objCall, "The callable returned a null value");
            if (interfaceC0624JjB.isDisposed()) {
                return;
            }
            fq.onSuccess(objCall);
        } catch (Throwable th) {
            AbstractC0722Ll.b(th);
            if (interfaceC0624JjB.isDisposed()) {
                FM.m(th);
            } else {
                fq.onError(th);
            }
        }
    }
}
