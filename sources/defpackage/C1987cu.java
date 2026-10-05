package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: cu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1987cu extends CancellationException {
    public final transient InterfaceC1830bu a;

    public C1987cu(String str, Throwable th, InterfaceC1830bu interfaceC1830bu) {
        super(str);
        this.a = interfaceC1830bu;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof C1987cu) {
                C1987cu c1987cu = (C1987cu) obj;
                if (!AbstractC4492zt.d(c1987cu.getMessage(), getMessage()) || !AbstractC4492zt.d(c1987cu.a, this.a) || !AbstractC4492zt.d(c1987cu.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        AbstractC4492zt.e(message);
        int iHashCode = ((message.hashCode() * 31) + this.a.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.a;
    }
}
