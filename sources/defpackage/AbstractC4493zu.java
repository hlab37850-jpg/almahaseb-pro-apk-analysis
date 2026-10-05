package defpackage;

import java.io.IOException;

/* JADX INFO: renamed from: zu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC4493zu extends IOException {
    public C4321xu a;

    public AbstractC4493zu(String str, C4321xu c4321xu, Throwable th) {
        super(str);
        if (th != null) {
            initCause(th);
        }
        this.a = c4321xu;
    }

    public C4321xu a() {
        return this.a;
    }

    public String b() {
        return null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        C4321xu c4321xuA = a();
        String strB = b();
        if (c4321xuA == null && strB == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(100);
        sb.append(message);
        if (strB != null) {
            sb.append(strB);
        }
        if (c4321xuA != null) {
            sb.append('\n');
            sb.append(" at ");
            sb.append(c4321xuA.toString());
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    public AbstractC4493zu(String str, C4321xu c4321xu) {
        this(str, c4321xu, null);
    }
}
