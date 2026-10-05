package defpackage;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
public class X4 extends B {
    public final int d;
    public final I8 e;
    public final ReentrantLock f;
    public Object[] g;
    public int h;
    private volatile /* synthetic */ int size;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[I8.values().length];
            iArr[I8.SUSPEND.ordinal()] = 1;
            iArr[I8.DROP_LATEST.ordinal()] = 2;
            iArr[I8.DROP_OLDEST.ordinal()] = 3;
            a = iArr;
        }
    }

    public X4(int i, I8 i8, InterfaceC3750qp interfaceC3750qp) {
        super(interfaceC3750qp);
        this.d = i;
        this.e = i8;
        if (i < 1) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
        }
        this.f = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i, 8)];
        Q5.u(objArr, C.a, 0, 0, 6, null);
        this.g = objArr;
        this.size = 0;
    }

    @Override // defpackage.B
    public boolean D(HJ hj) {
        ReentrantLock reentrantLock = this.f;
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
        return this.size == 0;
    }

    @Override // defpackage.B
    public boolean G() {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            return super.G();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.B
    public void H(boolean z) {
        InterfaceC3750qp interfaceC3750qp = this.a;
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            int i = this.size;
            C3965tW c3965tWC = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = this.g[this.h];
                if (interfaceC3750qp != null && obj != C.a) {
                    c3965tWC = OE.c(interfaceC3750qp, obj, c3965tWC);
                }
                Object[] objArr = this.g;
                int i3 = this.h;
                objArr[i3] = C.a;
                this.h = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            FW fw = FW.a;
            reentrantLock.unlock();
            super.H(z);
            if (c3965tWC != null) {
                throw c3965tWC;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // defpackage.B
    public Object L() {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object objJ = j();
                if (objJ == null) {
                    objJ = C.d;
                }
                reentrantLock.unlock();
                return objJ;
            }
            Object[] objArr = this.g;
            int i2 = this.h;
            Object obj = objArr[i2];
            AbstractC3957tO abstractC3957tO = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object objY = C.d;
            boolean z = false;
            if (i == this.d) {
                AbstractC3957tO abstractC3957tO2 = null;
                while (true) {
                    AbstractC3957tO abstractC3957tOY = y();
                    if (abstractC3957tOY == null) {
                        abstractC3957tO = abstractC3957tO2;
                        break;
                    }
                    AbstractC4492zt.e(abstractC3957tOY);
                    if (abstractC3957tOY.A(null) != null) {
                        objY = abstractC3957tOY.y();
                        abstractC3957tO = abstractC3957tOY;
                        z = true;
                        break;
                    }
                    abstractC3957tOY.B();
                    abstractC3957tO2 = abstractC3957tOY;
                }
            }
            if (objY != C.d && !(objY instanceof C0737Mb)) {
                this.size = i;
                Object[] objArr2 = this.g;
                objArr2[(this.h + i) % objArr2.length] = objY;
            }
            this.h = (this.h + 1) % this.g.length;
            FW fw = FW.a;
            reentrantLock.unlock();
            if (z) {
                AbstractC4492zt.e(abstractC3957tO);
                abstractC3957tO.x();
            }
            return obj;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void O(int i, Object obj) {
        if (i < this.d) {
            P(i);
            Object[] objArr = this.g;
            objArr[(this.h + i) % objArr.length] = obj;
        } else {
            Object[] objArr2 = this.g;
            int i2 = this.h;
            objArr2[i2 % objArr2.length] = null;
            objArr2[(i + i2) % objArr2.length] = obj;
            this.h = (i2 + 1) % objArr2.length;
        }
    }

    public final void P(int i) {
        Object[] objArr = this.g;
        if (i >= objArr.length) {
            int iMin = Math.min(objArr.length * 2, this.d);
            Object[] objArr2 = new Object[iMin];
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = this.g;
                objArr2[i2] = objArr3[(this.h + i2) % objArr3.length];
            }
            Q5.r(objArr2, C.a, i, iMin);
            this.g = objArr2;
            this.h = 0;
        }
    }

    public final YS Q(int i) {
        if (i < this.d) {
            this.size = i + 1;
            return null;
        }
        int i2 = a.a[this.e.ordinal()];
        if (i2 == 1) {
            return C.c;
        }
        if (i2 == 2) {
            return C.b;
        }
        if (i2 == 3) {
            return null;
        }
        throw new AD();
    }

    @Override // defpackage.AbstractC3108j0
    public Object g(AbstractC3957tO abstractC3957tO) {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            return super.g(abstractC3957tO);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.AbstractC3108j0
    public String h() {
        return "(buffer:capacity=" + this.d + ",size=" + this.size + ')';
    }

    @Override // defpackage.AbstractC3108j0
    public final boolean q() {
        return false;
    }

    @Override // defpackage.AbstractC3108j0
    public final boolean r() {
        return this.size == this.d && this.e == I8.SUSPEND;
    }

    @Override // defpackage.AbstractC3108j0
    public Object t(Object obj) {
        ReentrantLock reentrantLock = this.f;
        reentrantLock.lock();
        try {
            int i = this.size;
            C0737Mb c0737MbJ = j();
            if (c0737MbJ != null) {
                reentrantLock.unlock();
                return c0737MbJ;
            }
            YS ysQ = Q(i);
            if (ysQ != null) {
                reentrantLock.unlock();
                return ysQ;
            }
            if (i == 0) {
                while (true) {
                    JJ jjX = x();
                    if (jjX == null) {
                        break;
                    }
                    if (jjX instanceof C0737Mb) {
                        this.size = i;
                        reentrantLock.unlock();
                        return jjX;
                    }
                    AbstractC4492zt.e(jjX);
                    if (jjX.e(obj, null) != null) {
                        this.size = i;
                        FW fw = FW.a;
                        reentrantLock.unlock();
                        jjX.d(obj);
                        return jjX.a();
                    }
                }
            }
            O(i, obj);
            YS ys = C.b;
            reentrantLock.unlock();
            return ys;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
