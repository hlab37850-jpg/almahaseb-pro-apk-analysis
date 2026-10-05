package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public final class Jb0 extends Throwable {
    public Jb0(String str) {
        super("Failure occurred while trying to finish a future.");
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return this;
    }
}
