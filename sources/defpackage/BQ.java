package defpackage;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BQ implements IQ {
    public static BQ b(Callable callable) {
        Objects.requireNonNull(callable, "callable is null");
        return FM.l(new CQ(callable));
    }

    public static BQ c(Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return FM.l(new DQ(obj));
    }

    @Override // defpackage.IQ
    public final void a(FQ fq) {
        Objects.requireNonNull(fq, "observer is null");
        FQ fqS = FM.s(this, fq);
        Objects.requireNonNull(fqS, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            f(fqS);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            AbstractC0722Ll.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final BQ d(InterfaceC0777Np interfaceC0777Np) {
        Objects.requireNonNull(interfaceC0777Np, "mapper is null");
        return FM.l(new EQ(this, interfaceC0777Np));
    }

    public final BQ e(InterfaceC0777Np interfaceC0777Np) {
        Objects.requireNonNull(interfaceC0777Np, "itemSupplier is null");
        return FM.l(new GQ(this, interfaceC0777Np, null));
    }

    public abstract void f(FQ fq);

    public final BQ g(AN an) {
        Objects.requireNonNull(an, "scheduler is null");
        return FM.l(new JQ(this, an));
    }
}
