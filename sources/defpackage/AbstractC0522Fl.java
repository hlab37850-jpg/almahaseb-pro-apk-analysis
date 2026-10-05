package defpackage;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: renamed from: Fl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0522Fl extends AbstractC0422Dl {
    public abstract Thread S();

    public void T(long j, AbstractC0448El.c cVar) {
        RunnableC0519Fi.f.d0(j, cVar);
    }

    public final void U() {
        Thread threadS = S();
        if (Thread.currentThread() != threadS) {
            AbstractC3761r0.a();
            LockSupport.unpark(threadS);
        }
    }
}
