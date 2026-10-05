package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: ub, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4052ub extends CancellationException {
    public C4052ub() {
        super("Child of the scoped flow was cancelled");
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
