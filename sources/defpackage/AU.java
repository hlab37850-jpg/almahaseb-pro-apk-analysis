package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AU {
    private volatile /* synthetic */ int _size = 0;
    public BU[] a;

    public final void a(BU bu) {
        bu.c(this);
        BU[] buArrF = f();
        int iC = c();
        j(iC + 1);
        buArrF[iC] = bu;
        bu.setIndex(iC);
        l(iC);
    }

    public final BU b() {
        BU[] buArr = this.a;
        if (buArr != null) {
            return buArr[0];
        }
        return null;
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    public final BU e() {
        BU buB;
        synchronized (this) {
            buB = b();
        }
        return buB;
    }

    public final BU[] f() {
        BU[] buArr = this.a;
        if (buArr == null) {
            BU[] buArr2 = new BU[4];
            this.a = buArr2;
            return buArr2;
        }
        if (c() < buArr.length) {
            return buArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(buArr, c() * 2);
        AbstractC4492zt.g(objArrCopyOf, "copyOf(this, newSize)");
        BU[] buArr3 = (BU[]) objArrCopyOf;
        this.a = buArr3;
        return buArr3;
    }

    public final boolean g(BU bu) {
        boolean z;
        synchronized (this) {
            if (bu.a() == null) {
                z = false;
            } else {
                h(bu.getIndex());
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003a  */
    public final BU h(int i) {
        BU[] buArr = this.a;
        AbstractC4492zt.e(buArr);
        j(c() - 1);
        if (i < c()) {
            m(i, c());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                BU bu = buArr[i];
                AbstractC4492zt.e(bu);
                BU bu2 = buArr[i2];
                AbstractC4492zt.e(bu2);
                if (((Comparable) bu).compareTo(bu2) < 0) {
                    m(i, i2);
                    l(i2);
                } else {
                    k(i);
                }
            } else {
                k(i);
            }
        }
        BU bu3 = buArr[c()];
        AbstractC4492zt.e(bu3);
        bu3.c(null);
        bu3.setIndex(-1);
        buArr[c()] = null;
        return bu3;
    }

    public final BU i() {
        BU buH;
        synchronized (this) {
            buH = c() > 0 ? h(0) : null;
        }
        return buH;
    }

    public final void j(int i) {
        this._size = i;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    public final void k(int i) {
        while (true) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            if (i3 >= c()) {
                return;
            }
            BU[] buArr = this.a;
            AbstractC4492zt.e(buArr);
            int i4 = i2 + 2;
            if (i4 < c()) {
                BU bu = buArr[i4];
                AbstractC4492zt.e(bu);
                BU bu2 = buArr[i3];
                AbstractC4492zt.e(bu2);
                if (((Comparable) bu).compareTo(bu2) >= 0) {
                    i4 = i3;
                }
            } else {
                i4 = i3;
            }
            BU bu3 = buArr[i];
            AbstractC4492zt.e(bu3);
            BU bu4 = buArr[i4];
            AbstractC4492zt.e(bu4);
            if (((Comparable) bu3).compareTo(bu4) <= 0) {
                return;
            }
            m(i, i4);
            i = i4;
        }
    }

    public final void l(int i) {
        while (i > 0) {
            BU[] buArr = this.a;
            AbstractC4492zt.e(buArr);
            int i2 = (i - 1) / 2;
            BU bu = buArr[i2];
            AbstractC4492zt.e(bu);
            BU bu2 = buArr[i];
            AbstractC4492zt.e(bu2);
            if (((Comparable) bu).compareTo(bu2) <= 0) {
                return;
            }
            m(i, i2);
            i = i2;
        }
    }

    public final void m(int i, int i2) {
        BU[] buArr = this.a;
        AbstractC4492zt.e(buArr);
        BU bu = buArr[i2];
        AbstractC4492zt.e(bu);
        BU bu2 = buArr[i];
        AbstractC4492zt.e(bu2);
        buArr[i] = bu;
        buArr[i2] = bu2;
        bu.setIndex(i);
        bu2.setIndex(i2);
    }
}
