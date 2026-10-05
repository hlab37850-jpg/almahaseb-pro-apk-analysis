package defpackage;

import java.util.Objects;

/* JADX INFO: renamed from: Wd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1012Wd {
    public static NullPointerException d(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public final InterfaceC0624Jj a() {
        C1087Yk c1087Yk = new C1087Yk();
        b(c1087Yk);
        return c1087Yk;
    }

    public final void b(InterfaceC1809be interfaceC1809be) {
        Objects.requireNonNull(interfaceC1809be, "observer is null");
        try {
            InterfaceC1809be interfaceC1809beQ = FM.q(this, interfaceC1809be);
            Objects.requireNonNull(interfaceC1809beQ, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            c(interfaceC1809beQ);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            AbstractC0722Ll.b(th);
            FM.m(th);
            throw d(th);
        }
    }

    public abstract void c(InterfaceC1809be interfaceC1809be);
}
