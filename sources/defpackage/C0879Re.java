package defpackage;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: Re, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0879Re extends B {
    public final ReentrantLock d;
    public Object e;

    public C0879Re(InterfaceC3750qp interfaceC3750qp) {
        super(interfaceC3750qp);
        this.d = new ReentrantLock();
        this.e = C.a;
    }

    @Override // defpackage.B
    public boolean D(HJ hj) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            return super.D(hj);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.B
    public final boolean E() {
        return false;
    }

    @Override // defpackage.B
    public final boolean F() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            return this.e == C.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.B
    public void H(boolean z) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            C3965tW c3965tWO = O(C.a);
            FW fw = FW.a;
            reentrantLock.unlock();
            super.H(z);
            if (c3965tWO != null) {
                throw c3965tWO;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // defpackage.B
    public Object L() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            Object obj = this.e;
            YS ys = C.a;
            if (obj != ys) {
                this.e = ys;
                FW fw = FW.a;
                return obj;
            }
            Object objJ = j();
            if (objJ == null) {
                objJ = C.d;
            }
            return objJ;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final C3965tW O(Object obj) {
        InterfaceC3750qp interfaceC3750qp;
        Object obj2 = this.e;
        C3965tW c3965tWD = null;
        if (obj2 != C.a && (interfaceC3750qp = this.a) != null) {
            c3965tWD = OE.d(interfaceC3750qp, obj2, null, 2, null);
        }
        this.e = obj;
        return c3965tWD;
    }

    @Override // defpackage.AbstractC3108j0
    public String h() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            return "(value=" + this.e + ')';
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.AbstractC3108j0
    public final boolean q() {
        return false;
    }

    @Override // defpackage.AbstractC3108j0
    public final boolean r() {
        return false;
    }

    @Override // defpackage.AbstractC3108j0
    public Object t(Object obj) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            C0737Mb c0737MbJ = j();
            if (c0737MbJ != null) {
                reentrantLock.unlock();
                return c0737MbJ;
            }
            if (this.e == C.a) {
                while (true) {
                    JJ jjX = x();
                    if (jjX == null) {
                        break;
                    }
                    if (jjX instanceof C0737Mb) {
                        reentrantLock.unlock();
                        return jjX;
                    }
                    AbstractC4492zt.e(jjX);
                    if (jjX.e(obj, null) != null) {
                        FW fw = FW.a;
                        reentrantLock.unlock();
                        jjX.d(obj);
                        return jjX.a();
                    }
                }
            }
            C3965tW c3965tWO = O(obj);
            if (c3965tWO != null) {
                throw c3965tWO;
            }
            YS ys = C.b;
            reentrantLock.unlock();
            return ys;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
