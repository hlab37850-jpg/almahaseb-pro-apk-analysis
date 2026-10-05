package defpackage;

/* JADX INFO: renamed from: ij, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2466ij extends RuntimeException {
    public final InterfaceC0988Vf a;

    public C2466ij(InterfaceC0988Vf interfaceC0988Vf) {
        this.a = interfaceC0988Vf;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.a.toString();
    }
}
