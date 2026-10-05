package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: renamed from: n8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3452n8 extends G {
    public final Thread c;
    public final AbstractC0422Dl d;

    public C3452n8(InterfaceC0988Vf interfaceC0988Vf, Thread thread, AbstractC0422Dl abstractC0422Dl) {
        super(interfaceC0988Vf, true, true);
        this.c = thread;
        this.d = abstractC0422Dl;
    }

    public final Object H0() throws Throwable {
        AbstractC3761r0.a();
        try {
            AbstractC0422Dl abstractC0422Dl = this.d;
            if (abstractC0422Dl != null) {
                AbstractC0422Dl.M(abstractC0422Dl, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    AbstractC0422Dl abstractC0422Dl2 = this.d;
                    long jP = abstractC0422Dl2 != null ? abstractC0422Dl2.P() : LocationRequestCompat.PASSIVE_INTERVAL;
                    if (z()) {
                        AbstractC0422Dl abstractC0422Dl3 = this.d;
                        if (abstractC0422Dl3 != null) {
                            AbstractC0422Dl.H(abstractC0422Dl3, false, 1, null);
                        }
                        AbstractC3761r0.a();
                        Object objH = AbstractC3755qu.h(W());
                        C2129ee c2129ee = objH instanceof C2129ee ? (C2129ee) objH : null;
                        if (c2129ee == null) {
                            return objH;
                        }
                        throw c2129ee.a;
                    }
                    AbstractC3761r0.a();
                    LockSupport.parkNanos(this, jP);
                } catch (Throwable th) {
                    AbstractC0422Dl abstractC0422Dl4 = this.d;
                    if (abstractC0422Dl4 != null) {
                        AbstractC0422Dl.H(abstractC0422Dl4, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            D(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            AbstractC3761r0.a();
            throw th2;
        }
    }

    @Override // defpackage.C3674pu
    public boolean b0() {
        return true;
    }

    @Override // defpackage.C3674pu
    public void w(Object obj) {
        if (AbstractC4492zt.d(Thread.currentThread(), this.c)) {
            return;
        }
        Thread thread = this.c;
        AbstractC3761r0.a();
        LockSupport.unpark(thread);
    }
}
