package defpackage;

/* JADX INFO: renamed from: sW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3884sW extends IllegalStateException {
    public C3884sW(Throwable th) {
        super("The exception could not be delivered to the consumer because it has already canceled/disposed the flow or the exception has nowhere to go to begin with. Further reading: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0#error-handling | " + th, th);
    }
}
