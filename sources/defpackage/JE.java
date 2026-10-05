package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class JE extends RuntimeException {
    public JE(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public JE(Throwable th) {
        this("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + th, th);
    }
}
